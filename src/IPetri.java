public interface IPetri {
    /* Add a place with nTokens 
     * If nTokens < 0, throw an execption
     * 
     * @param nTokens: number of tokens in the place
    */
    public void addPlace(int nTokens) throws PetriException;

    /* Remove the selected place by id

     * @param id
     */
    public void removePlace(String id);

    /* Set nTokens in the selected place
     * If nTokens < 0, throw an execption
     * 
     * @param id
     * @param nTokens: number of tokens in the place
    */
    public void setPlaceNTokens(String id, int nTokens) throws PetriException;

    /* Add a transition */
    public void addTransition();

    /* Remove the selected place by id
     *
     * @param id
    */
    public void removeTransition(String id);

    /* Fire the selected transition by id 
     * If the selected transition doesn't exist, throw an execption
     * 
     * @param id
    */
    public void doTransition(String id) throws PetriException;

    /* 
     * Add an arc by sourceId, targetId, weight
     * If weight < 1, throw an execption
     * If the corresponding place or transition doesn't exist, throw an execption
     * 
     * @param sourceId: id of the source object
     * @param targetId: id of the target object
     * @param weight
    */
    public void addArc(String sourceId, String targetId, int weight) throws PetriException;
    
    /* Add an empty arc by sourceId, targetId 
     * If the corresponding place or transition doesn't exist, throw an execption
     * 
     * @param sourceId: id of the source object
     * @param targetId: id of the target object
    */
    public void addEmptyArc(String sourceId, String targetId) throws PetriException;

    /* Add a zero arc by sourceId, targetId 
     * If the corresponding place or transition doesn't exist, throw an execption
     * 
     * @param sourceId: id of the source object
     * @param targetId: id of the target object
    */
    public void addZeroArc(String sourceId, String targetId) throws PetriException;

    /* Remove the selected arc/empty arc/zero arc
     * 
     * @param id
    */
    public void removeArc(String id);

    /* Set the weight for the selected arc 
     * If weight < 1, throw an execption
     * If the selected object isn't of type Arc, throw an execption
     * 
     * @param id
     * @param weight
    */
    public void setArcWeight(String id, int weight) throws PetriException;

    /* Change the type of the selected arc 
     * If the direction of the arc isn't Place->Transition, throw an execption
     * 
     * @param id
     * @param type: "Arc" or "EmptyArc" or "ZeroArc"
    */
    public void changeArcType(String id, String type) throws PetriException;
    
    /* Display the petri net */
    public void display();
}