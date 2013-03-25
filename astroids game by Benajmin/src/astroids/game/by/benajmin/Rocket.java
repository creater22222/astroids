package astroids.game.by.benajmin;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Rocket
{
    private int rocketXPos = 500;
    private int rocketYPos = 500;                    
    private int fasterThenSpeedLimitX = 0;
    private int fasterThenSpeedLimitY = 0;
    private int directionToCrashSite;
    int[] xPos =
    {
        -10, 12, 15, 0, 10, 10, 12, 12, 10, 10, 10, 12, 12, 10, 10, 0, -5, -5, -2
    };
    int[] yPos =
    {
        -0, -5, -5, -6, -5, -10, -5, -5, -4, -4, -0, 4, 4, 5, 5, 10, 5, 5, -4
    };
    Polygon uncontrolableRide = new Polygon(xPos, yPos, yPos.length);

    public void paintSelf(Graphics2D g2)
    {
        g2.setColor(Color.white);
        g2.drawString("direction = " + directionToCrashSite, 1800, 100);
        g2.drawString("speed = " + fasterThenSpeedLimitX, 1800, 200);
        g2.translate(rocketXPos, rocketYPos);
        g2.scale(10, 10);
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(.1f));
        g2.rotate(Math.toRadians(directionToCrashSite));
        g2.drawPolygon(uncontrolableRide); 
        rocketXPos = rocketXPos + fasterThenSpeedLimitX;
        if (rocketXPos > 1500)
        {
            rocketXPos = 0;
        }
        if (rocketXPos < 0)
        {
            rocketXPos = 1500;
        }
    }

    public void moveSelf()
    {
        
    }

    public void setFasterThenSpeedLimitX(int fasterThenSpeedLimitX)
    {
        this.fasterThenSpeedLimitX = fasterThenSpeedLimitX;
    }

    public void setFasterThenSpeedLimitY(int fasterThenSpeedLimitY)
    {
        this.fasterThenSpeedLimitY = fasterThenSpeedLimitY;
    }

    public void setDirectionToCrashSite(int directionToCrashSite)
    {
        this.directionToCrashSite = directionToCrashSite;
    }

    public int getFasterThenSpeedLimitX()
    {
        return fasterThenSpeedLimitX;
    }

    public int getFasterThenSpeedLimitY()
    {
        return fasterThenSpeedLimitY;
    }

    public int getDirectionToCrashSite()
    {
        return directionToCrashSite;
    }
}
