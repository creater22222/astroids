package ponggame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class PongGame extends JComponent implements MouseMotionListener
{
    JFrame fieldOfLosers;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int ballXPosistion = width/2;
    int ballYPosistion = height/2;
    int ballDiameter = 150;
    int ballXSpeed = 4;
    int ballYSpeed = 5;
    int score = 0;
    int paddleXPosistion = 10;
    int paddleYPosistion = height/2;
    Ellipse2D.Double ball;
    Rectangle2D.Double paddle;
            

    public static void main(String[] args)
    {
        new PongGame().getGoing();
    }

    public void getGoing()
    {
        fieldOfLosers = new JFrame("field of losers");
        fieldOfLosers.setVisible(true);
        fieldOfLosers.setSize(width, height);
        fieldOfLosers.add(this);
        fieldOfLosers.addMouseMotionListener(this);
        fieldOfLosers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        while (true)
        {
           repaint(); 
            if ((ballXPosistion > width - ballDiameter) && (ballXSpeed > 0))
            {
                ballXSpeed = -ballXSpeed;
            }
            if ((ballYPosistion > height - ballDiameter) && (ballYSpeed > 0))
            {
                ballYSpeed = -ballYSpeed;
            }
            if ((ballYPosistion < 0) && (ballYSpeed < 0))
            {
                ballYSpeed = -ballYSpeed;
            }
        }
    }

    @Override
    public void paint(Graphics g)
    {
        ballXPosistion = ballXPosistion+ballXSpeed;
        ballYPosistion = ballYPosistion+ballYSpeed;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(40f));
        g2.setColor(Color.MAGENTA);
        ball = new Ellipse2D.Double(ballXPosistion, ballYPosistion, ballDiameter, ballDiameter);
       // System.out.println(ball);
        g2.fill(ball);
        g2.setColor(Color.CYAN);
        g2.setColor(Color.GREEN);
        paddle = new Rectangle2D.Double(paddleXPosistion, paddleYPosistion, 25, 500);
        //System.out.println(paddle);
        g2.fill(paddle);
        if (ball.intersects(paddle))
        {
            ballXSpeed = -ballXSpeed;
            score++; 
            if (score%2==0)
            {
                ballXSpeed += 1/3;
                ballYSpeed += 1/3;
                
            }
            
        }
    }

    @Override
    public void mouseDragged(MouseEvent me)
    {
    }

    @Override
    public void mouseMoved(MouseEvent me)
    {
        paddleYPosistion = me.getY()-250;
    }
    
    
}
