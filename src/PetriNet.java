import java.util.ArrayList;
import java.util.List;

public class PetriNet {
    List<Place> places = new ArrayList<Place>();
    List<Transition> transitions = new ArrayList<Transition>();
    List<Arc> arcs = new ArrayList<Arc>();

    // place
    public void addPlace(int nTokens) {
        // compute id by the length of the list of object
        String id = "p" + Integer.toString(this.places.size());

        Place place = new Place(id, nTokens);
        places.add(place);

        this.dispaly();
    }

    public void removePlace(String id) {

    }

    // transition
    public void addTransition() {
        // compute id by the length of the list of object
        String id = "t" + Integer.toString(this.transitions.size());
        
        Transition transition = new Transition(id);
        transitions.add(transition);

        this.dispaly();
    }

    public void removeTransition(String id) {
        
    }

    public void doTransition(String id) {
        int index = getIndexById(id);
        Transition transition = this.transitions.get(index);
        boolean isTrigged = transition.trigger();

        if (isTrigged) {
            System.out.println();
            System.out.println("Trigged");
            this.dispaly();
        }
        else {
            System.out.println();
            System.out.println("Can't trigger");
        }

    }
    
    // arc
    public void addArc(String sourceId, String targetId, int weight) {
        Place place;
        Transition transition;
        Arc arc;

        String id = "a" + Integer.toString(this.arcs.size());
        String sourceType = getTypeById(sourceId);
        String targetType = getTypeById(targetId);

        int sourceIndex = getIndexById(sourceId);
        int targetIndex = getIndexById(targetId);

        if (sourceType == "p" && targetType == "t") {
            place = this.places.get(sourceIndex);
            transition = this.transitions.get(targetIndex);
            arc = new Arc(id, place, transition, weight);
            transition.addInArcs(arc);
        }
        else if (sourceType == "t" && targetType == "p") {
            place = this.places.get(targetIndex);
            transition = this.transitions.get(sourceIndex);
            arc = new Arc(id, transition, place, weight);
            transition.addOutArcs(arc);
        }
        else {
            System.out.println("Error!");
            return;
        }

        this.arcs.add(arc);
        this.dispaly();
    }

    public void removeArc(String id) {
        
    }

    // get index in the list by id
    public int getIndexById(String id) {
        int index = Integer.parseInt(id.substring(1));
        return index;
    }

    public String getTypeById(String id) {
        return id.substring(0, 1).intern();
    }

    public void dispaly() {
        System.out.println();
        System.out.printf("places: ");
        System.out.println(this.places);
        System.out.printf("transitions: ");
        System.out.println(this.transitions);
        System.out.printf("arcs: ");
        System.out.println(this.arcs);
    }
}
