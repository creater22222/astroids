package astroids.game.by.benajmin;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Rocket
{
    int[] xPos =
    {
        -10, 12, 15, 0, 10, 10, 12, 12, 10, 10, 10, 12, 12, 10, 10, 0, -5, -5, -2
    };
    int[] yPos =
    {
        0, 5, 5, 6, 5, 10, 5, 5, 4, 4, 0, -4, -4, -5, -5, -10, -5, -5, -4, -5
    };
    Polygon uncontrolableRide = new Polygon(xPos, yPos, xPos.length);

    public void paintSelf(Graphics2D g2)
    {
        g2.translate(500, 500);
        g2.scale(20, 20);
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(.1f));
        g2.drawPolygon(uncontrolableRide);
    }
}
