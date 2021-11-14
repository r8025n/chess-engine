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
    public static Font buttonFont,headingFont;
    public static Cursor crsr;

    StartWindow() {
        JFrame newFrame = new JFrame("STARTING WINDOW");
        // JLabel background = new JLabel(new ImageIcon("./img2.jpg"));
        // newFrame.add(background);
        newFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 50));
        // background.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 50));
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(700,500);
        newFrame.setVisible(true);
        newFrame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		newFrame.setLocation(dim.width/2-newFrame.getSize().width/2, dim.height/2-newFrame.getSize().height/2);

        newFrame.getContentPane().setBackground(Color.black);
        
        JLabel headLabel = new JLabel();
        headLabel.setText("AUTONOMUS CHESS ENGINE");
        headLabel.setForeground(Color.yellow);
        newFrame.add(headLabel);
        // background.add(headLabel);
        
        headingFont = new Font("ARIAL",Font.BOLD,40);
        buttonFont = new Font("Sans",Font.BOLD,35);

        headLabel.setFont(headingFont);
        
        startButton = new JButton("START GAME");
        exitButton = new JButton("EXIT");
        startButton.setToolTipText("Press to START the Game ");
        exitButton.setToolTipText("Press to EXIT the Game");
        newFrame.add(startButton);
        newFrame.add(exitButton);
        // background.add(startButton);
        // background.add(exitButton);
        startButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);
        startButton.setBackground(Color.red);
        startButton.setForeground(Color.black);
        exitButton.setBackground(Color.blue);
        exitButton.setForeground(Color.black);
        
        crsr = new Cursor(Cursor.HAND_CURSOR);
        startButton.setCursor(crsr);
        exitButton.setCursor(crsr);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
            	newFrame.dispose();
                new Game();
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