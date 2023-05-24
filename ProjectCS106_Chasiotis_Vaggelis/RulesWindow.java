import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class RulesWindow extends JFrame
{
    //Variables Area
    
    //Creating the frame
    JFrame frame = new JFrame();
    //Creating the Labels that will appear in the frame
    JLabel label = new JLabel(" These are the rules");
    JLabel label1 = new JLabel(" *If you score either 7 or 11, you win!");
    JLabel label2 = new JLabel(" *If you score either 2 or 3 or 12, you lose!");
    JLabel label3 = new JLabel(" *If you score something else,you get a POINT, and you re-roll");
    JLabel label4 = new JLabel(" *But, if you score 7 after your re-roll, you lose!");
    JLabel label5 = new JLabel(" *And if you score THE SAME number as your POINT, you win!"); 
    JLabel label6 = new JLabel(" That simple, have fun!");
    
    //Constructor Area
    public RulesWindow()
    {
        //arranging the labels specificly in the frame
        label.setBounds(0,0,300,50);
        label1.setBounds(0,20,400,50);
        label2.setBounds(0,40,500,50);
        label3.setBounds(0,60,600,50);
        label4.setBounds(0,80,500,50);
        label5.setBounds(0,100,600,50);
        label6.setBounds(0,120,400,50);
        
        //arranging the style and the length of the letters in each label
        label.setFont(new Font(null,Font.PLAIN,20));
        label1.setFont(new Font(null,Font.PLAIN,17));
        label2.setFont(new Font(null,Font.PLAIN,17));
        label3.setFont(new Font(null,Font.PLAIN,17));
        label4.setFont(new Font(null,Font.PLAIN,17));
        label5.setFont(new Font(null,Font.PLAIN,17));
        label6.setFont(new Font(null,Font.PLAIN,18));
        
        //adding the labels into the frame
        frame.add(label);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);
        
        //preparing the frame itself
        frame.setSize(520,230);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}