public interface IPetri{
    public void addPlace(int nTokens);
    public void removePlace(String id);
    public void addTransition();
    public void removeTransition(String id);
    public void doTransition(String id);
    public void addArc(String sourceId, String targetId, int weight);
    public void addEmptyArc(String sourceId, String targetId);
    public void addZeroArc(String sourceId, String targetId);
    public void removeArc(String id);
    public String getTypeById(String ref);
    public void dispaly();
}