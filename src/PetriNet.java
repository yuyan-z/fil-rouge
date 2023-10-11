import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class PetriNet implements IPetri{
    private Map<String, Place> places;
    private Map<String, Transition> transitions;
    private Map<String, IArc> arcs;
    private int idxPlace;
    private int idxTransition;
    private int idxArc;

    /* constructor */
    public PetriNet() {
        places = new HashMap<String, Place>();
        transitions = new HashMap<String, Transition>();
        arcs = new HashMap<String, IArc>();
        idxPlace = 0;
        idxTransition = 0;
        idxArc = 0;
    }

    /* methods */
    // place
    public void addPlace(int nTokens) {
        String id = "p" + Integer.toString(idxPlace);
        places.put(id, new Place(id, nTokens));
        this.dispaly();
        ++idxPlace;
    }

    public void removePlace(String id) {
        // remove arcs with the place
        for (Iterator<Map.Entry<String, IArc>> it = arcs.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, IArc> item = it.next();
            IArc arc = item.getValue();
            if (arc.getPlace().getId().equals(id)) {
                arc.getTransition().removeArc(arc);
                it.remove();
            }
        }

        places.remove(id);
        this.dispaly();
    }

    // transistion
    public void addTransition() {
        String id = "t" + Integer.toString(idxTransition);
        transitions.put(id, new Transition(id));
        this.dispaly();
        ++idxTransition;
    }

    public void removeTransition(String id) {
        // remove arcs with the transition
        for (Iterator<Map.Entry<String, IArc>> it = arcs.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, IArc> item = it.next();
            IArc arc = item.getValue();
            if (arc.getTransition().getId().equals(id)) {
                it.remove();
            }
        }

        transitions.remove(id);
        this.dispaly();
    }

    public void doTransition(String id) {
        Transition transition = transitions.get(id);
        boolean isFired = transition.fire();

        if (isFired) {
            System.out.println(transition.getId() + " fired");
            this.dispaly();
        }
        else{
            System.out.println(transition.getId() + " can't fire");
            System.out.println("------");
        }
    }
    
    // arc
    public void addArc(String sourceId, String targetId, int weight) {
        Place place;
        Transition transition;
        Arc arc;

        String sourceType = getTypeById(sourceId);
        String targetType = getTypeById(targetId);
        String id = "a" + Integer.toString(idxArc);

        if (sourceType == "p" && targetType == "t") {
            place = places.get(sourceId);
            transition = transitions.get(targetId);
            arc = new Arc(id, place, transition, weight);
            transition.addInArc(arc);
        }
        else if (sourceType == "t" && targetType == "p") {
            place = places.get(targetId);
            transition = transitions.get(sourceId);
            arc = new Arc(id, transition, place, weight);
            transition.addOutArc(arc);
        }
        else{
            System.out.println("Error!");
            return;
        }

        arcs.put(id, arc);
        this.dispaly();
        ++idxArc;
    }

    public void addZeroArc(String sourceId, String targetId) {
        Place place;
        Transition transition;
        IArc arc;

        String sourceType = getTypeById(sourceId);
        String targetType = getTypeById(targetId);
        String id = "a" + Integer.toString(idxArc);

        if (sourceType == "p" && targetType == "t") {
            place = places.get(sourceId);
            transition = transitions.get(targetId);
            arc = new ZeroArc(id, place, transition);
            transition.addInArc(arc);
        }
        else{
            System.out.println("Error!");
            return;
        }

        arcs.put(id, arc);
        this.dispaly();
        ++idxArc;
    }

    public void addEmptyArc(String sourceId, String targetId) {
        Place place;
        Transition transition;
        IArc arc;

        String sourceType = getTypeById(sourceId);
        String targetType = getTypeById(targetId);
        String id = "a" + Integer.toString(idxArc);

        if (sourceType == "p" && targetType == "t") {
            place = places.get(sourceId);
            transition = transitions.get(targetId);
            arc = new EmptyArc(id, place, transition);
            transition.addInArc(arc);
        }
        else{
            System.out.println("Error!");
            return;
        }

        arcs.put(id, arc);
        this.dispaly();
        ++idxArc;
    }

    public void removeArc(String id) {
        // remove transitions with the arc
        IArc arc = arcs.get(id);
        for (Iterator<Map.Entry<String, Transition>> it = transitions.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Transition> item = it.next();
            item.getValue().removeArc(arc);
        }
        arcs.remove(id);
        this.dispaly();
    }

    public String getTypeById(String ref) {
        return ref.substring(0, 1).intern();
    }

    public void dispaly() {
        System.out.printf("places: ");
        System.out.println(places);
        System.out.printf("transitions: ");
        System.out.println(transitions);
        System.out.printf("arcs: ");
        System.out.println(arcs);
        System.out.println("------");
    }
}
