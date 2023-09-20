public class Arc extends PetriElement{
    Place place;
	Transition transition;
	String direction;  // “p2t” or “t2p”
	int weight = 1;

    // constructeurs
    Arc(String id, Place p, Transition t, int w) {
        this.place = p;
        this.transition = t;
        this.direction = "p2t";
        this.weight = w;
    }
    Arc(String id, Transition t, Place p, int w) {
        this.place = p;
        this.transition = t;
        this.direction = "t2p";
        this.weight = w;
    }

    public int get_weight() {
        return this.weight;
    }

    public void set_weight(int w) {
        this.weight = w;
    }

    public boolean is_triggable() {
        boolean res = false;

        return res;
    }
}
