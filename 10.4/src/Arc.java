public class Arc extends PetriElement{
    private Place place;
	private Transition transition;
	private String direction;  // “p2t” or “t2p”
	private int weight = 1;

    // constructeurs
    Arc(String s, Place p, Transition t, int w) {
        this.id = s;
        this.place = p;
        this.transition = t;
        this.direction = "p2t";
        this.weight = w;
    }
    Arc(String s, Transition t, Place p, int w) {
        this.id = s;
        this.place = p;
        this.transition = t;
        this.direction = "t2p";
        this.weight = w;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int w) {
        this.weight = w;
    }

    public Place getPlace() {
        return this.place;
    }

    public boolean isTriggable() {
        boolean res = false;
        if (this.direction == "p2t" && this.place.getNTokens() >= this.weight) {
            res = true;
        }
        return res;
    }

    @Override
    public String toString() {
        String res;
        if (this.direction == "p2t") {
            res = this.place.getId() + "->" + this.transition.getId();
        }
        else {
            res = this.transition.getId() + "->" + this.place.getId();
        }
        return this.id + " " + res + " weight=" + Integer.toString(this.weight);
    }

    public String toString(boolean forTransition) {
        return this.id;
    }
}
