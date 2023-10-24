public class Place {
    private String id;
    private int nTokens;

	/* constructor */
    public Place(String s, int n) {
        id = s;
        nTokens = n;
    }

    /* methods */
	public int getNTokens() {
        return nTokens;
    }

	public void setNTokens(int n) {
        nTokens = n;
    }

	public void removeTokens(int n) {
        nTokens -= n;
    }

	public void addTokens(int n) {
        nTokens += n;
    }
    
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "(nTokens=" + nTokens + ")";
    }
}
