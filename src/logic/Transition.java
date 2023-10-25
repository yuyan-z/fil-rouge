package logic;

import java.util.ArrayList;
import java.util.List;


class Transition {
    private String id;
    private List<IArc> inArcs;
    private List<IArc> outArcs;

    /* constructor */
    public Transition(String s) {
        id = s;
        inArcs = new ArrayList<IArc>();
        outArcs = new ArrayList<IArc>();
    }

    /* methods */
    public void addInArc(IArc a) {
        inArcs.add(a);
    }

    public void addOutArc(IArc a) {
        outArcs.add(a);
    }

    public void removeArc(IArc a) {
        inArcs.remove(a);
        outArcs.remove(a);
    }

    // fire the transition
    public boolean fire() {
        boolean isAllFirable = true;

        // check if all the arcs in inArcs are firable
        for (int i = 0; i < inArcs.size(); i++) {
            IArc arc = inArcs.get(i);
            if (arc.isFirable() == false) {
                isAllFirable = false;
                break;
            }
        }

        if (isAllFirable) {
            // remove tokens from the source places
            for (int i = 0; i < inArcs.size(); i++) {
                IArc arc = inArcs.get(i);
                if(arc.getWeight() > 0) {
                    arc.getPlace().removeTokens(arc.getWeight());
                }
            }

            // add tokens to the target places
            for (int i = 0; i < this.outArcs.size(); i++) {
                IArc arc = outArcs.get(i);

                arc.getPlace().addTokens(arc.getWeight());
            }
        }

        return isAllFirable;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        String inArcStr = "";
        String outArcStr = "";

        for (IArc arc : inArcs) {
            if (inArcStr == "") {
                inArcStr = inArcStr + arc.getId();
            } else {
                inArcStr = inArcStr + ", " + arc.getId();
            }
        }

        for (IArc arc : outArcs) {
            if (outArcStr == "") {
                outArcStr = outArcStr + arc.getId();
            } else {
                outArcStr = outArcStr + ", " + arc.getId();
            }
        }

        return "(inArcs=[" + inArcStr + "] outArcs=[" + outArcStr + "])";
    }

    public List<IArc> getInArcs() {
        return inArcs;
    }

    public List<IArc> getOutArcs() {
        return outArcs;
    }
}
