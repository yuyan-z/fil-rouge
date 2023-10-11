public interface IArc{
    public String getId();
    public Place getPlace();
    public Transition getTransition();
    public int getWeight();
    public void setWeight(int w);
    public String getDirection();
    public boolean isFirable();
}
