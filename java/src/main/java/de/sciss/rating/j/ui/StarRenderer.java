package de.sciss.rating.j.ui;

import de.sciss.rating.j.JRating;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class StarRenderer implements RatingRenderer {
    private final int dim;
    private final GeneralPath gp            = new GeneralPath();
    private final Stroke strkFocus          = new BasicStroke(2f);
    private final Color colrFocus           = new Color(115, 164, 209); // this is nimbus; no clue how to get laf independent
    private final Color colrFillMarked      = Color.darkGray;
    private final Color colrDrawMarked      = Color.darkGray;
    private final Color colrFillUnmarked    = new Color(224, 224, 224);
    private final Color colrDrawUnmarked    = new Color(192, 192, 192);

    public StarRenderer(int dim) {
        this.dim = dim;
        initShape();
    }

    public StarRenderer() {
        this(16);
    }

    private void initShape() {
        // TODO: these could be optimised
        float cx = dim * 0.5f;
        float cy = dim * 0.5f + 1;
        float r  = (dim - 3) * 0.5f;
        float rh = r * 0.4f;

        for (int i = 0; i < 10; i++) {
            double ang = Math.PI/180 * (i * 36 - 90);
            float ri   = i % 2 == 0 ? r : rh;
            float x    = (float) Math.cos(ang) * ri + cx;
            float y    = (float) Math.sin(ang) * ri + cy;
            if (i == 0) {
                gp.moveTo(x, y);
            } else {
                gp.lineTo(x, y);
            }
        }
        gp.closePath();
    }

    public Dimension getMarkSize() {
        return new Dimension(dim, dim);
    }

    @Override
    public void paint(Graphics g, JRating c, int index, boolean marked, boolean selected, boolean focused) {
        Graphics2D g2 = (Graphics2D) g;
        // g.setColor(Color.red);
        // g.fillRect(0, 0, 100, 100);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING  , RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE );
        if (focused) {
            Stroke strkOrig = g2.getStroke();
            g2.setStroke(strkFocus);
            g2.setColor(colrFocus);
            g2.draw(gp);
            g2.setStroke(strkOrig);
        }
        g2.setColor(marked ? colrFillMarked : colrFillUnmarked);
        // if (selected) g2.setColor(Color.red);
        g2.fill(gp);
        if (!focused) {
            g2.setColor(marked ? colrDrawMarked : colrDrawUnmarked);
            g2.draw(gp);
        }
    }
}
