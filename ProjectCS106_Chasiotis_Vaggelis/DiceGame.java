/**
 * This is my CS106 Project
 * Dice Game - "Snake Eyes"
 * Vaggelis Chasiotis
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
public class DiceGame extends JFrame implements ActionListener
{
    //Variables Area
    JButton playButton;
    JButton rollButton;
    JButton rulsButton;
    
    JLabel result;
    JTextField text;
    
    //Preparing the panels for each dice
    JPanel dieface1 = new JPanel();
    JPanel dieface2 = new JPanel();
    JPanel dieface3 = new JPanel();
    JPanel dieface4 = new JPanel();
    JPanel dieface5 = new JPanel();
    JPanel dieface6 = new JPanel();
    //Preparing the labels where the dice are going to appear
    JLabel image1 = new JLabel();
    JLabel image2 = new JLabel();
    JLabel image3 = new JLabel();
    JLabel image4 = new JLabel();
    JLabel image5 = new JLabel();
    JLabel image6 = new JLabel();

    //panels regarding the arrangement of the labels and buttons in the frame
    JPanel DiceTop = new JPanel();
    JPanel DiceBot = new JPanel();
    JPanel Buttons = new JPanel();
    JPanel labels = new JPanel();
    
    JPanel topPanels = new JPanel();
    
    int face1, face2;
    int sum;
    int point;
    
    String DiceFace1;
    String DiceFace2;
    
    //Constructor Area - creating an interface
    public DiceGame()
    {
        //Adding a title for the frame
        setTitle("Snake Eyes");
        
        //Creating objects based on variables
        playButton = new JButton("Play");
        rollButton = new JButton("Roll");
        rulsButton = new JButton("Rules");
        
        //arranging the textfield 
        result = new JLabel("Result:");
        text = new JTextField(10);
        text.setEditable(false);
        
        //attaching action listeners in each button
        playButton.addActionListener(this);
        rollButton.addActionListener(this);
        rulsButton.addActionListener(this);
        
        //Initiating the dice images
        image1.setIcon(new ImageIcon (getClass().getResource("dice1.png")) );
        dieface1.add(image1);
        image3.setIcon(new ImageIcon (getClass().getResource("dice3.png")) );
        dieface3.add(image3);
        image2.setIcon(new ImageIcon (getClass().getResource("dice2.png")) );
        dieface2.add(image2);
        image4.setIcon(new ImageIcon (getClass().getResource("dice4.png")) );
        dieface4.add(image4);
        image5.setIcon(new ImageIcon (getClass().getResource("dice5.png")) );
        dieface5.add(image5);
        image6.setIcon(new ImageIcon (getClass().getResource("dice6.png")) );
        dieface6.add(image6);
     
        
        //Flow Layout Manager to put component into the frame
        //panel for the buttons
        Buttons.setLayout(new FlowLayout());
        Buttons.add(rulsButton);
        Buttons.add(playButton);
        Buttons.add(rollButton);
        
        //panel for the result label and the text
        labels.setLayout(new FlowLayout());
        labels.add(result);
        labels.add(text);
        
        //panel for the area of the first two dice, as well as a border
        DiceTop.setLayout(new FlowLayout());
        DiceTop.add(dieface1);
        DiceTop.add(dieface3);
        DiceTop.setBorder(BorderFactory.createTitledBorder("Dice"));
        
        //panel for the area of the second two dice together with a border of course
        DiceBot.setLayout(new FlowLayout());
        DiceBot.add(dieface2);
        DiceBot.add(dieface4);
        DiceBot.setBorder(BorderFactory.createTitledBorder("Point"));

        //adding all the panels mentioned above into one big panel
        topPanels.setLayout(new BoxLayout(topPanels, BoxLayout.Y_AXIS));
        topPanels.add(Buttons);
        topPanels.add(labels);
        topPanels.add(DiceTop);
        topPanels.add(DiceBot);

        //adding the big panel into the frame
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        getContentPane().add(topPanels);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //Rules Button Properties
        if(e.getSource() == rulsButton)
        {
            //a connection with the rules window class
            RulesWindow myWindow = new RulesWindow();
        }
        //Play Button Properties
        if(e.getSource() == playButton)
        {
            //Initiating the random command
            Random r = new Random();
            //Setting up how many numbers we want to be randomized, in that case, 6 on each dice
            face1 = r.nextInt(6);
            face1++;
            
            face2 = r.nextInt(6);
            face2++;
            //preparing the right dice image depending on the random numbers
            DiceFace1 =  "dice" + face1 + ".png";
            DiceFace2 =  "dice" + face2 + ".png";
            
            image1.setIcon(new ImageIcon(DiceFace1));
            image3.setIcon(new ImageIcon(DiceFace2));
            
            //Displaying the dice
            System.out.println(face1);
            System.out.println(face2);
            
            sum = face1 + face2;
            
            rollButton.setEnabled(false);
            //setting the winning condition
            if(sum == 7 || sum == 11)
            {
                text.setText("You win!");
            }
            //setting the losing condition
            else if(sum == 2 || sum == 3 || sum == 12)
            {
                text.setText("You lose!");
            }
            //setting the point condition
            else if(sum == 1 || sum == 4 || sum == 5 || sum == 6 || sum == 8 || sum == 9 || sum == 10)
            {
                text.setText("Its a point! Re-roll");
                rollButton.setEnabled(true);
                playButton.setEnabled(false);
                point = sum;
            }
        }
        //Roll Button Properties
        if(e.getSource() == rollButton)
        {
            //Initiating the random command
            Random r = new Random();
            //Setting up how many numbers we want to be randomized, in that case, 6 on each dice
            face1 = r.nextInt(6);
            face1++;
            
            face2 = r.nextInt(6);
            face2++;
            
            //preparing the right dice image depending on the random numbers
            DiceFace1 =  "dice" + face1 + ".png";
            DiceFace2 =  "dice" + face2 + ".png";
            
            image2.setIcon(new ImageIcon(DiceFace1));
            image4.setIcon(new ImageIcon(DiceFace2));
            
            //displaying the dice
            System.out.println(face1);
            System.out.println(face2);
            
            sum = face1 + face2;
            //setting the winning condition 
            if(sum == point)
            {
                text.setText("You win!");
                rollButton.setEnabled(false);
                playButton.setEnabled(true);
            }
            //setting the losing condition
            else if(sum == 7)
            {
                text.setText("You lose!");
                rollButton.setEnabled(false);
                playButton.setEnabled(true);
            }
        }
    }
    
    public static void main(String[] args)
    {
        //Create an object to show it on the screen
        DiceGame frame = new DiceGame();
        
        WindowQuitter wquit = new WindowQuitter();
        
        frame.addWindowListener(wquit);
        
        //Set frame size
        frame.setSize(600,600);
        
        //Set frame visible
        frame.setVisible(true);
        
        //Prevent frame from resizing
        frame.setResizable(false);
    }
}
class WindowQuitter extends WindowAdapter
{
    public void windowClosing (WindowEvent e)
    {
        //Stop the program
        System.exit(0);
    }
}