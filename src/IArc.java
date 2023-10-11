public interface IArc{
    public String getId();
    public Place getPlace();
    public Transition getTransition();
    public int getWeight();
    public boolean isFirable();
}
