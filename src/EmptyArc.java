public class EmptyArc implements IArc{
    private String id;
    private Place place;
	private Transition transition;
    
    /* constructors */
    public EmptyArc(String s, Place p, Transition t) {
        id = s;
        place = p;
        transition = t;
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
        return place.getNTokens();
    }

    @Override
    public void setWeight(int w) {
        return;
    }

    @Override
    public String getDirection() {
        return "p2t";
    }


    @Override
    public boolean isFirable() {
        boolean res = false;
        if (place.getNTokens() >= 1) {
            res = true;
        }
        return res;
    }

    @Override
    public String toString() {
        return "(" + place.getId() + "->" + transition.getId() + " EmptyArc)";
    }
}
