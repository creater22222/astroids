package astroids.game.by.benajmin;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

public class TheThingsYouBumpIntoAndDieFromInTheDark
{
    private double destroyersDirectionToCrashSite;
    double ThingThatGoesBumpAndThumpInTheNightYPos;
    double ThingsThatGoBumpAndThumpIntTheNightXSpeed;
    double ThingsThatGoBumpAndThumpInTheNightSpeed;
    double ThingsThatGoBumpAndThumpIntTheNightYSpeed;
    double ThingThatGoesBumpAndThumpInTheNightXPos;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int[] theGameRuinerxPos =
    {
        0, 2, 4, 5, 5, 10, 7, 5, 4, 4, -4, -4, -8, -5, -10, -5, -6, -4, -2
    };
    int[] theGameRuineryPos =
    {
        -8, -3, -7, -2, 1, 13, 12, 14, 14, 9, 9, 14, 14, 7, 4, 1, -7, -6, -9
    };
    Polygon theGameRuiner = new Polygon(theGameRuinerxPos, theGameRuineryPos, theGameRuineryPos.length);
    private final double ThingsThatGoBumpAndThumpInTheNightYSpeed  = 1;

    public TheThingsYouBumpIntoAndDieFromInTheDark()
    {
        this.ThingThatGoesBumpAndThumpInTheNightXPos = Math.random() * width;
        this.ThingThatGoesBumpAndThumpInTheNightYPos = Math.random() * height;
        int sideOfYourWorldthatYouWillBeKilledIn = (int) (Math.random() * 4) + 1;
        switch (sideOfYourWorldthatYouWillBeKilledIn)
        {
            case 1: //top
                ThingThatGoesBumpAndThumpInTheNightXPos = 0;
                ThingThatGoesBumpAndThumpInTheNightYPos = Math.random();


        }
        ThingsThatGoBumpAndThumpIntTheNightXSpeed = Math.sin(Math.toRadians(Math.toRadians(destroyersDirectionToCrashSite))) * ThingsThatGoBumpAndThumpInTheNightSpeed;
        ThingThatGoesBumpAndThumpInTheNightXPos = ThingsThatGoBumpAndThumpIntTheNightXSpeed + ThingThatGoesBumpAndThumpInTheNightXPos;
       ThingsThatGoBumpAndThumpIntTheNightYSpeed = -Math.cos(Math.toRadians(destroyersDirectionToCrashSite)) * ThingsThatGoBumpAndThumpInTheNightSpeed;
        ThingThatGoesBumpAndThumpInTheNightYPos = ThingsThatGoBumpAndThumpInTheNightYSpeed + ThingThatGoesBumpAndThumpInTheNightYPos;
    }

    public void paintSelf(Graphics2D g2)
    {
        g2.translate(ThingThatGoesBumpAndThumpInTheNightXPos, ThingThatGoesBumpAndThumpInTheNightYPos);
        g2.scale(10, 10);
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(.1f));
        g2.drawPolygon(theGameRuiner);
        g2.setTransform(new AffineTransform());
    }
}
