import java.awt.*;
import javax.swing.*;

/**
 * Main panel will be the panel to 
 * display the list of enabled words that 
 * matches with the input characters
 * @author steven
 *
 */

public class MainPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private List list;
	public MainPanel(){
		setLayout(new GridLayout(1,1));
    	setBackground (Color.white);
    	setPreferredSize(new Dimension(100,400));
    	list = new List();
    	add(list);
	}

	public void clear(){
		list.removeAll(); 
	}

	public void addList(Object[] text){
		for(Object s: text){
			list.add(s.toString());
		}
		updateUI();
	}
}