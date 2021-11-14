import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FinishingWindow extends JPanel{
	static boolean hasCollide = false;
	//JLayeredPane jp = new JLayeredPane();
	static String winner = "Computer Wins";

	@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setFont(new Font("TimesRoman", Font.PLAIN, 35));
        g.setColor(Color.yellow); 
        g.drawString("CHECKMATE", 190, 210);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.setColor(Color.green);
        g.drawString(winner, 220, 250);
        
        // g.drawImage(image,0, 0, null);
    }
}