import javax.swing.*;
import java.awt.*;

/**
 * Driver Class 
 * 
 * @author steven
 * @version 1.0
 */
public class Main extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args){
		MainPanel mp = new MainPanel();
		StatusBar bar = new StatusBar(mp);
	    JFrame frame = new JFrame("Word Finder");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    frame.setResizable(false);
	    JPanel bp = new JPanel();
	    bp.setLayout(new BorderLayout(2,1));
	    bp.add(new ControlPanel(mp,bar),BorderLayout.NORTH);
	    bp.add(mp,BorderLayout.CENTER);
	    bp.add(bar,BorderLayout.SOUTH);
	    frame.getContentPane().add(bp);
	    frame.pack();
	    frame.setVisible(true);
	}
}