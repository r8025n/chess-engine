import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor; 
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class StartWindow {
	// public static ImageIcon icon;
    public static Container c;
    public static JButton startButton,exitButton;
    public static Font font1,font2;
    public static Cursor crsr;

    StartWindow() {
        JFrame newFrame=new JFrame("STARTING WINDOW");
        newFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 50));
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(700,500);
        newFrame.setVisible(true);
        newFrame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		newFrame.setLocation(dim.width/2-newFrame.getSize().width/2, dim.height/2-newFrame.getSize().height/2);

        newFrame.getContentPane().setBackground(Color.black);
        
        JLabel newLabel=new JLabel();
        newLabel.setText("AUTONOMUS CHESS ENGINE");
        newFrame.add(newLabel);
        
        font2=new Font("ARIAL",Font.BOLD,40);
        newLabel.setFont(font2);
        
        startButton=new JButton("START GAME");
        exitButton=new JButton("EXIT");
        startButton.setToolTipText("Press to START the Game ");
        exitButton.setToolTipText("Press to EXIT the Game");
        newFrame.add(startButton);
        newFrame.add(exitButton);
        font1=new Font("ARIAL",Font.ITALIC,35);
        startButton.setFont(font1);
        exitButton.setFont(font1);
        startButton.setBackground(Color.LIGHT_GRAY);
        startButton.setForeground(Color.black);
        exitButton.setBackground(Color.LIGHT_GRAY);
        exitButton.setForeground(Color.black);
        
        crsr=new Cursor(Cursor.HAND_CURSOR);
        startButton.setCursor(crsr);
        exitButton.setCursor(crsr);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
            	newFrame.dispose();
                GameWindow gameWindow=new GameWindow();
            }
        });
        
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                newFrame.dispose();
                
            }
        });

        
        newFrame.add(startButton);
        newFrame.add(exitButton);
    }
}