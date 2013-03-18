package astroids.game.by.benajmin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class AstroidsGameByBenajmin extends JComponent
{
    Rocket thingThatYouDriveToYourDeath;
    JFrame spaceWhereYouDie;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static void main(String[] args)
    {
        new AstroidsGameByBenajmin().getGoing();
    }

    public void getGoing()
    {
        thingThatYouDriveToYourDeath = new Rocket();
        spaceWhereYouDie = new JFrame("field of losers");
        spaceWhereYouDie.setBackground(Color.black);
        spaceWhereYouDie.setVisible(true);
        spaceWhereYouDie.setSize(width, height);
        spaceWhereYouDie.add(this);
        spaceWhereYouDie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
     thingThatYouDriveToYourDeath.paintSelf(g2);
    }
}
