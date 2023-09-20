import java.util.ArrayList;
import java.util.List;

public class Transition extends PetriElement{
    List<Arc> in_arcs = new ArrayList<Arc>();
    List<Arc> out_arcs = new ArrayList<Arc>();

    // trigger the transition
    public void trigger() {
        // check the token necessary
        // for all arcs in in_arcs
         //     arc. is_triggable

        // remove tokens from the source places
        // for all arcs in in_arcs
        //  arc.place.remove(arc.weight)

        // add tokens to the target places
        // for all arcs in out_arcs,
        //  arc.place.remove(arc.weight)

    }

}
