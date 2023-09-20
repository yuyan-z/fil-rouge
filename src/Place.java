public class Place extends PetriElement{
    private int nTokens;

	// constructeur
    public Place(String s, int n) {
        this.id = s;
        this.nTokens = n;
    }

	public int getNTokens() {
        return nTokens;
    }

	public void setNTokens(int n) {
        this.nTokens = n;
    }

	public void removeTokens(int n) {
        this.nTokens -= n;
    }

	public void addTokens(int n) {
        this.nTokens += n;
    }

    @Override
    public String toString() {
        return this.id + " nTokens=" + this.nTokens;
    }
}
