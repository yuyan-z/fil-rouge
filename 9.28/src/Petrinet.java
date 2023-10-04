import java.util.ArrayList;
import java.util.List;

public class Petrinet {
    List<Place> places = new ArrayList<Place>();
    List<Transition> transitions = new ArrayList<Transition>();
    List<Arc> arcs = new ArrayList<Arc>();

    // place
    public void add_place(String id, int n) {
        Place place = new Place(id, n);
        places.add(place);
    }

    public void remove_place(String id) {

    }

    // transition
    public void add_transition() {
        
    }

    public void remove_transition(String id) {
        
    }

    public void do_transition(String id) {
        // get transition by id
    }
    
    // arc
    public void add_arc(String id, String source_id, String target_id, int weight) {
        
    }

    public void remove_arc(String id) {
        
    }

    
    // find an index in PetriElem list by id
    int find_index(List<PetriElement> elems, String id) {
        int index = 0;
        return index;
    }


}
