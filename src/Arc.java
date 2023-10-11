public class Arc implements IArc{
    private String id;
    private Place place;
	private Transition transition;
    private String direction;
    private int weight;  // positive

    /* constructors */
    public Arc(String s, Place p, Transition t, int w) {
        id = s;
        place = p;
        transition = t;
        direction = "p2t";
        weight = w;
    }
    public Arc(String s, Transition t, Place p, int w) {
        id = s;
        place = p;
        transition = t;
        direction = "t2p";
        weight = w;
    }

    /* methods */
    @Override
    public String getId() {
        return id;
    }

    @Override
    public Place getPlace() {
        return place;
    }

    @Override
    public Transition getTransition() {
        return transition;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getDirection() {
        return direction;
    }

    @Override
    public void setWeight(int w) {
        weight = w;
    }

    @Override
    public boolean isFirable() {
        boolean res = false;
        // when nTokens >= weight in the source place 
        if (direction == "p2t" && place.getNTokens() >= weight) {
            res = true;
        }
        return res;
    }

    @Override
    public String toString() {
        String res;
        if (direction == "p2t") {
            res = place.getId() + "->" + transition.getId();
        }
        else{
            res = transition.getId() + "->" + place.getId();
        }
        return "(" + res + " weight=" + Integer.toString(weight) + ")";
    }
}
