import java.awt.*;

public interface IArc {
    public String getId();
    public Place getPlace();
    public Transition getTransition();
    public int getWeight();
    public void setWeight(int w);
    public String getDirection();
    public boolean isFirable();
    public void drawArc(Graphics g, int tx, int ty, int px, int py, int sqaureSize, int circleSize, double i);
}
