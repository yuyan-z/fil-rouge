import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.awt.*;
import javax.swing.*;



public class Transition {
    private String id;
    private List<IArc> inArcs;
    private List<IArc> outArcs;

    /* constructor */
    public Transition(String s) {
        id = s;
        inArcs = new ArrayList<IArc>();
        outArcs = new ArrayList<IArc>();
    }

    /* methods */
    public void addInArc(IArc a) {
        inArcs.add(a);
    }

    public void addOutArc(IArc a) {
        outArcs.add(a);
    }

    public void removeArc(IArc a) {
        inArcs.remove(a);
        outArcs.remove(a);
    }

    // fire the transition
    public boolean fire() {
        boolean isAllFirable = true;

        // check if all the arcs in inArcs are firable
        for (int i = 0; i < inArcs.size(); i++) {
            IArc arc = inArcs.get(i);
            if (arc.isFirable() == false) {
                isAllFirable = false;
                break;
            }
        }

        if (isAllFirable) {
            // remove tokens from the source places
            for (int i = 0; i < inArcs.size(); i++) {
                IArc arc = inArcs.get(i);
                if(arc.getWeight() > 0) {
                    arc.getPlace().removeTokens(arc.getWeight());
                }
            }

            // add tokens to the target places
            for (int i = 0; i < this.outArcs.size(); i++) {
                IArc arc = outArcs.get(i);

                arc.getPlace().addTokens(arc.getWeight());
            }
        }

        return isAllFirable;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        String inArcStr = "";
        String outArcStr = "";

        for (IArc arc : inArcs) {
            if(inArcStr == "") {
                inArcStr = inArcStr + arc.getId();
            }
            else{
                inArcStr = inArcStr + ", " + arc.getId();
            }
        }

        for (IArc arc : outArcs) {
            if(outArcStr == "") {
                outArcStr = outArcStr + arc.getId();
            }
            else{
                outArcStr = outArcStr + ", " + arc.getId();
            }
        }

        return "(inArcs=[" + inArcStr + "] outArcs=[" + outArcStr + "])";
    }

    public void drawTransition(Graphics g, int sqaureSize, int circleSize, int margin) {
        // draw sqaure
        int d = circleSize * 3 / 2 + sqaureSize / 2;
        int tx = margin + d + circleSize / 2;
        int ty = margin + d + circleSize / 2;
        int nPlaces = inArcs.size() + outArcs.size();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.GRAY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawRect(tx - sqaureSize / 2, ty - sqaureSize / 2, sqaureSize, sqaureSize);
        g2d.drawString(id, tx - sqaureSize / 2 + margin, ty - sqaureSize / 2 + sqaureSize + margin);

        System.out.println(Math.cos(1 * Math.PI));
        
        double i = 0.75;
        for (IArc arc : inArcs) {
            int px = tx + (int)(d * Math.cos(i * Math.PI)) - circleSize / 2;
            int py = ty - (int)(d * Math.sin(i * Math.PI)) - circleSize / 2;
            // draw place
            arc.getPlace().drawPlace(g, px, py, circleSize);
            arc.drawArc(g, tx, ty, px, py, sqaureSize, circleSize, i);
            i += 2 / (double)nPlaces;
        }

        for (IArc arc : outArcs) {
            int px = tx + (int)(d * Math.cos(i * Math.PI)) - circleSize / 2;
            int py = ty - (int)(d * Math.sin(i * Math.PI)) - circleSize / 2;
            // draw place
            arc.getPlace().drawPlace(g, px, py, circleSize);
            arc.drawArc(g, tx, ty, px, py, sqaureSize, circleSize, i);
            i += 2 / (double)nPlaces;
        }

    }


}
