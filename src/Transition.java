import java.util.ArrayList;
import java.util.List;

public class Transition extends PetriElement{
    private List<Arc> inArcs = new ArrayList<Arc>();
    private List<Arc> outArcs = new ArrayList<Arc>();

    // constructeur
    Transition(String s) {
        this.id = s;
    }

    public void addInArcs(Arc a) {
        this.inArcs.add(a);
    }

    public void addOutArcs(Arc a) {
        this.outArcs.add(a);
    }

    // trigger the transition
    public boolean trigger() {
        boolean isAllTriggable = true;

        // check if all the arcs in inArcs are triggable
        for (int i = 0; i < this.inArcs.size(); i++) {
            Arc arc = this.inArcs.get(i);
            if (arc.isTriggable() == false) {
                isAllTriggable = false;
                break;
            }
        }

        if (isAllTriggable) {
            // remove tokens from the source places
            for (int i = 0; i < this.inArcs.size(); i++) {
                Arc arc = this.inArcs.get(i);
                arc.getPlace().removeTokens(arc.getWeight());
            }

            // add tokens to the target places
            for (int i = 0; i < this.outArcs.size(); i++) {
                Arc arc = this.outArcs.get(i);
                arc.getPlace().addTokens(arc.getWeight());
            }
        }

        return isAllTriggable;
    }

    @Override
    public String toString() {
        return this.id + " inArcs=" + this.inArcs + " outArcs=" + this.outArcs;
    }
}
