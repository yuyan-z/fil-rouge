import java.awt.*;

public class ZeroArc implements IArc {
    private String id;
    private Place place;
	private Transition transition;

    /* constructor */
    public ZeroArc(String s, Place p, Transition t) {
        id = s;
        place = p;
        transition = t;
    }

    /* methods */
    @Override
    public String getId() {
        return id;
    }

    @Override
    public Place getPlace() {
        return place;
    }

    @Override
    public Transition getTransition() {
        return transition;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public void setWeight(int w) {
        return;
    }

    @Override
    public String getDirection() {
        return "p2t";
    }

    @Override
    public boolean isFirable() {
        boolean res = false;
        // when the source place has no tokens, it's firable
        if (place.getNTokens() == 0) {
            res = true;
        }
        return res;
    }

    @Override
    public String toString() {
        return "(" + place.getId() + "->" + transition.getId() + " ZeroArc)";
    }

    @Override
    public void drawArc(Graphics g, int tx, int ty, int px, int py, int sqaureSize, int circleSize, double i) {
        int ax1 = tx + (int)((sqaureSize * 3 / 4)* Math.cos(i * Math.PI));
        int ay1 = ty - (int)((sqaureSize * 3 / 4)* Math.sin(i * Math.PI));
        int ax2 = px + circleSize / 2 - (int)((circleSize / 2) * Math.cos(i * Math.PI));
        int ay2 = py + circleSize / 2 + (int)((circleSize / 2) * Math.sin(i * Math.PI));
        double ratio = 0.15;
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawLine(ax1, ay1, ax2, ay2);
        
        g2d.drawLine(ax2, ay2, ax2 - (int)(10 * Math.cos((i + ratio) * Math.PI)), ay2 + (int)(10 * Math.sin((i + ratio) * Math.PI)));
        g2d.drawLine(ax2, ay2, ax2 - (int)(10 * Math.cos((i - ratio) * Math.PI)), ay2 + (int)(10 * Math.sin((i - ratio) * Math.PI)));

        g2d.drawString("zero", (ax1 + ax2) / 2, (ay1 + ay2) / 2);
    }
}
