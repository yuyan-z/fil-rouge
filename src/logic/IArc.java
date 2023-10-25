package logic;


public interface IArc {
    /* Get the id of the arc 
     * 
     * @return id
    */
    public String getId();

    /* Get the place related to the arc 
     * 
     * @return place
    */
    public Place getPlace();

    /* Get the transition related to the arc 
     * 
     * @return transition
    */
    public Transition getTransition();

    /* Get the weight of the arc 
     * 
     * @return weight
    */
    public int getWeight();

    /* Set the weight of the arc
     * 
     * @param w: weight
    */
    public void setWeight(int w);

    /* Get the direction of the arc 
     * 
     * @return direction
    */
    public String getDirection();

    /* check if the arc is firable
     * 
     * @return true or false
    */
    public boolean isFirable();
}
