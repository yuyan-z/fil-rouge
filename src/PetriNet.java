import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.awt.*;
import javax.swing.*;


public class PetriNet implements IPetri {
    private Map<String, Place> places;
    private Map<String, Transition> transitions;
    private Map<String, IArc> arcs;
    private int idxPlace;
    private int idxTransition;
    private int idxArc;

    private int FRAME_WIDTH = 600;
    private int FRAME_HEIGHT = 400;
    private int SQUARE_SIZE = 30;
    private int CIRCLE_SIZE = 50;
    private int MARGIN = 10;

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
    public void addPlace(int nTokens) throws PetriException {
        if (nTokens < 0) throw new PetriException("Error: nTokens should >= 0");

        String id = "p" + Integer.toString(idxPlace);
        places.put(id, new Place(id, nTokens));
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
    }

    public void setPlaceNTokens(String id, int nTokens) throws PetriException {
        if (nTokens < 0) throw new PetriException("Error: nTokens should >= 0");
        
        places.get(id).setNTokens(nTokens);
    }


    // transistion
    public void addTransition() {
        String id = "t" + Integer.toString(idxTransition);
        transitions.put(id, new Transition(id));
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
    }

    public void doTransition(String id) throws PetriException {
        Transition transition = transitions.get(id);
        if (transition == null) throw new PetriException("Error: id");

        if (transition.fire()) {
            System.out.println(transition.getId() + " fired");
        }
        else{
            System.out.println(transition.getId() + " can't fire");
            System.out.println("------");
        }
    }
    

    // arc
    public void addArc(String sourceId, String targetId, int weight) throws PetriException {
        if (weight < 1) throw new PetriException("Error: weight should >= 1");

        String sourceType = getTypeById(sourceId);
        String targetType = getTypeById(targetId);
        String id = "a" + Integer.toString(idxArc);
        IArc arc;

        if (sourceType == "p" && targetType == "t") {
            Place place = places.get(sourceId);
            Transition transition = transitions.get(targetId);
            if (place == null || transition == null) throw new PetriException("Error: sourceId or targetId");
    
            arc = new Arc(id, place, transition, weight);
            transition.addInArc(arc);
        }
        else if (sourceType == "t" && targetType == "p") {
            Place place = places.get(targetId);
            Transition transition = transitions.get(sourceId);
            if (place == null || transition == null) throw new PetriException("Error: sourceId or targetId");

            arc = new Arc(id, transition, place, weight);
            transition.addOutArc(arc);
        }
        else throw new PetriException("Error: sourceId or targetId");

        arcs.put(id, arc);
        ++idxArc;
    }

    public void setArcWeight(String id, int weight) throws PetriException {
        if (weight < 1) throw new PetriException("Error: weight should >= 1");

        if (arcs.get(id).getClass().getSimpleName().equals("Arc")) {
            arcs.get(id).setWeight(weight);
        }
        else throw new PetriException("Error: should be Arc");
    }

    public void addZeroArc(String sourceId, String targetId) throws PetriException {
        Place place = places.get(sourceId);
        Transition transition = transitions.get(targetId);
        if (place == null || transition == null) throw new PetriException("Error: sourceId or targetId");

        String id = "a" + Integer.toString(idxArc);
        IArc arc = new ZeroArc(id, place, transition);
        transition.addInArc(arc);
        arcs.put(id, arc);
        ++idxArc;

    }

    public void addEmptyArc(String sourceId, String targetId) throws PetriException {
        Place place = places.get(sourceId);
        Transition transition = transitions.get(targetId);
        if (place == null || transition == null) throw new PetriException("Error: sourceId or targetId");

        String id = "a" + Integer.toString(idxArc);
        IArc arc = new EmptyArc(id, place, transition);
        transition.addInArc(arc);
        arcs.put(id, arc);
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
    }

    public void changeArcType(String id, String type) throws PetriException {
        if (arcs.get(id).getClass().getSimpleName().equals(type)) throw new PetriException("Error: type should be different");
        if (arcs.get(id).getDirection() == "t2p") throw new PetriException("Error: arc should be place->transition");

        // create a new arc with the same id
        Place place = arcs.get(id).getPlace();
        Transition transition = arcs.get(id).getTransition();

        if (type.equals("ZeroArc")) {
            IArc arc = new ZeroArc(id, place, transition);
            removeArc(id);  // remove original arc
            transition.addInArc(arc);
            arcs.put(id, arc);
        }
        else if (type.equals("EmptyArc")) {
            IArc arc = new EmptyArc(id, place, transition);
            removeArc(id);  // remove original arc
            transition.addInArc(arc);
            arcs.put(id, arc);
        }
        else if (type.equals("Arc")) {
            IArc arc = new Arc(id, place, transition, 1);
            removeArc(id);  // remove original arc
            transition.addInArc(arc);
            arcs.put(id, arc);
        }
        else {
            throw new PetriException("Error: type should be Arc/ZeroArc/EmptyArc !");
        }
    }

    public String getTypeById(String ref) {
        return ref.substring(0, 1).intern();
    }

    public void display() {
        String placesStr = "";
        String transitionsStr = "";
        String arcsStr = "";

        System.out.printf("places: ");
        for (Map.Entry<String, Place> entry : places.entrySet()) {
            if (placesStr == "") {
                placesStr = entry.getKey() + entry.getValue().toString();
            }
            else {
                placesStr = placesStr + ", " + entry.getKey() + entry.getValue().toString();
            }
        }
        System.out.println(placesStr);

        System.out.printf("transitions: ");
        for (Map.Entry<String, Transition> entry : transitions.entrySet()) {
            if (transitionsStr == "") {
                transitionsStr = entry.getKey() + entry.getValue().toString();
            }
            else {
                transitionsStr = transitionsStr + ", " + entry.getKey() + entry.getValue().toString();
            }
        }
        System.out.println(transitionsStr);

        System.out.printf("arcs: ");
        for (Map.Entry<String, IArc> entry : arcs.entrySet()) {
            if (arcsStr == "") {
                arcsStr = entry.getKey() + entry.getValue().toString();
            }
            else {
                arcsStr = arcsStr + ", " + entry.getKey() + entry.getValue().toString();
            }
        }
        System.out.println(arcsStr);

        System.out.println("------");
    }

    public void draw() {
        // create the JFrame window
        JFrame frame = new JFrame("Petri Net Simulation");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  // set frame visible

        // inner class
        class PetriPanel extends JPanel {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (Map.Entry<String, Transition> entry : transitions.entrySet()) {
                    entry.getValue().drawTransition(g, SQUARE_SIZE, CIRCLE_SIZE, MARGIN);
                }
            }
        }
        
        // create the panel
        PetriPanel petripanel = new PetriPanel();
        frame.add(petripanel);
    }
}


class PetriException extends Exception {
	private String msg;

	public PetriException(String s) {
		msg = s;
	}

	public String getMsg() {
		return msg;
	}
}
