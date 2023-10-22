import java.awt.*;

public class Arc implements IArc {
    private String id;
    private Place place;
	private Transition transition;
    private String direction;
    private int weight;  // positive

    /* constructors */
    public Arc(String s, Place p, Transition t, int w) {
        id = s;
        place = p;
        transition = t;
        direction = "p2t";
        weight = w;
    }
    public Arc(String s, Transition t, Place p, int w) {
        id = s;
        place = p;
        transition = t;
        direction = "t2p";
        weight = w;
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
        return weight;
    }

    @Override
    public String getDirection() {
        return direction;
    }

    @Override
    public void setWeight(int w) {
        weight = w;
    }

    @Override
    public boolean isFirable() {
        boolean res = false;
        // when nTokens >= weight in the source place 
        if (direction == "p2t" && place.getNTokens() >= weight) {
            res = true;
        }
        return res;
    }

    @Override
    public String toString() {
        String res;
        if (direction == "p2t") {
            res = place.getId() + "->" + transition.getId();
        }
        else{
            res = transition.getId() + "->" + place.getId();
        }
        return "(" + res + " weight=" + Integer.toString(weight) + ")";
    }

    @Override
    public void drawArc(Graphics g, int tx, int ty, int px, int py, int sqaureSize, int circleSize, double i) {
        int ax1 = tx + (int)((sqaureSize * 3 / 4)* Math.cos(i * Math.PI));
        int ay1 = ty - (int)((sqaureSize * 3 / 4)* Math.sin(i * Math.PI));
        int ax2 = px + circleSize / 2 - (int)((circleSize / 2) * Math.cos(i * Math.PI));
        int ay2 = py + circleSize / 2 + (int)((circleSize / 2) * Math.sin(i * Math.PI));
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawLine(ax1, ay1, ax2, ay2);

        double ratio = 0.15;
        // draw arrow
        if (direction == "t2p") {
            g2d.drawLine(ax2, ay2, ax2 - (int)(10 * Math.cos((i + ratio) * Math.PI)), ay2 + (int)(10 * Math.sin((i + ratio) * Math.PI)));
            g2d.drawLine(ax2, ay2, ax2 - (int)(10 * Math.cos((i - ratio) * Math.PI)), ay2 + (int)(10 * Math.sin((i - ratio) * Math.PI)));
        }
        else {
            g2d.drawLine(ax1, ay1, ax1 + (int)(10 * Math.cos((i + ratio) * Math.PI)), ay1 - (int)(10 * Math.sin((i + ratio) * Math.PI)));
            g2d.drawLine(ax1, ay1, ax1 + (int)(10 * Math.cos((i - ratio) * Math.PI)), ay1 - (int)(10 * Math.sin((i - ratio) * Math.PI)));
        }

        g2d.drawString(String.valueOf(weight), (ax1 + ax2) / 2, (ay1 + ay2) / 2);


    }
}
