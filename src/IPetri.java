public interface IPetri{
    public void addPlace(int nTokens) throws PetriException;
    public void removePlace(String id);
    public void setPlaceNTokens(String id, int nTokens) throws PetriException;

    public void addTransition();
    public void removeTransition(String id);
    public void doTransition(String id) throws PetriException;

    public void addArc(String sourceId, String targetId, int weight) throws PetriException;
    public void addEmptyArc(String sourceId, String targetId) throws PetriException;
    public void addZeroArc(String sourceId, String targetId) throws PetriException;
    public void removeArc(String id);
    public void setArcWeight(String id, int weight) throws PetriException;
    public void changeArcType(String id, String type) throws PetriException;
    
    public String getTypeById(String ref);
    public void display();
    
}