import java.awt.*;

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

    public void drawPlace(Graphics g, int x, int y, int circleSize) {
        // draw place
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLUE);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawOval(x , y, circleSize, circleSize);
        g2d.drawString(id, x + circleSize / 2 - 5, y + circleSize + 10);
        g2d.drawString(String.valueOf(nTokens), x + circleSize / 2 - 5, y + circleSize / 2 + 5);
    }


}
