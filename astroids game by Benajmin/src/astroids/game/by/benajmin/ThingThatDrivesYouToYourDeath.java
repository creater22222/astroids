package astroids.game.by.benajmin;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;

public class ThingThatDrivesYouToYourDeath
{
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    private double rocketXPos = 500;
    private double rocketYPos = 500;
    private double fasterThenSpeedLimitX = 0;// this is delta x
    private double fasterThenSpeedLimitY = 0;// this is delta y
    private double directionToCrashSite;
    private double fasterThenSpeedLimit = 0;
    int[] xPos =
    {
        0, 4, 4, 5, 5, 10, 5, 5, 4, 4, -4, -4, -5, -5, -10, -5, -5, -4, -4
    };
    int[] yPos =
    {
        -10, -2, -5, -5, 0, 10, 10, 12, 12, 10, 10, 12, 12, 10, 10, 0, -5, -5, -2
    };
    Polygon uncontrolableRide = new Polygon(xPos, yPos, yPos.length);

    public void paintSelf(Graphics2D g2)
    {
        g2.setColor(Color.red);
        g2.drawString("direction = " + (int)directionToCrashSite, 1800, 100);
        g2.drawString("speed = " + (int)fasterThenSpeedLimit, 1800, 200);
        g2.translate(rocketXPos, rocketYPos);
        g2.scale(10, 10);
        g2.setColor(Color.cyan);
        g2.setStroke(new BasicStroke(.1f));
        g2.rotate(Math.toRadians(directionToCrashSite));
        g2.fillPolygon(uncontrolableRide);
        if (rocketXPos > width)
        {
            rocketXPos = 0;
        }
        if (rocketXPos < 0)
        {
            rocketXPos = width;
        }
        if (rocketYPos > height)
        {
            rocketYPos = 0;
        }
        if (rocketYPos < 0)
        {
            rocketYPos = height;
        }
    }

    public void moveSelf()
    {
        fasterThenSpeedLimitX = getFasterThenSpeedLimit() * Math.sin(Math.toRadians(directionToCrashSite));
        rocketXPos = fasterThenSpeedLimitX + rocketXPos;
        fasterThenSpeedLimitY = getFasterThenSpeedLimit() * -Math.cos(Math.toRadians(directionToCrashSite));
        rocketYPos = fasterThenSpeedLimitY + rocketYPos;
    }

    public void setFasterThenSpeedLimitX(double fasterThenSpeedLimitX)
    {
        this.fasterThenSpeedLimitX = fasterThenSpeedLimitX;
    }

    public void setFasterThenSpeedLimitY(double fasterThenSpeedLimitY)
    {
        this.fasterThenSpeedLimitY = fasterThenSpeedLimitY;
    }

    public void setDirectionToCrashSite(double directionToCrashSite)
    {
        this.directionToCrashSite = directionToCrashSite;
    }

    public double getFasterThenSpeedLimitX()
    {
        return fasterThenSpeedLimitX;
    }

    public double getFasterThenSpeedLimitY()
    {
        return (int) fasterThenSpeedLimitY;
    }

    public double getDirectionToCrashSite()
    {
        return directionToCrashSite;
    }

    public double getFasterThenSpeedLimit()
    {
        return fasterThenSpeedLimit;
    }

    public void setFasterThenSpeedLimit(double fasterThenSpeedLimit)
    {
        this.fasterThenSpeedLimit = fasterThenSpeedLimit;
    }
}
