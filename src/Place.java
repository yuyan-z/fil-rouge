public class Place extends PetriElement{
    int n_tokens;

	// constructeur
    Place(String s, int n) {
        this.id = s;
        this.n_tokens = n;
    }

	public int get_n_tokens() {
        return n_tokens;
    }

	public void set_n_tokens(int n) {
        this.n_tokens = n;
    }

	public void remove_tokens(int n) {
        this.n_tokens -= n;
    }

	public void add_tokens(int n) {
        this.n_tokens += n;
    }
}
