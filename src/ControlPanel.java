import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

/**
 * Control Panel contains the input box and the button to 
 * start the algorithm
 * @author steven
 *
 */
public class ControlPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JTextField text;
	private MainPanel panel;
	private StatusBar bar;
	/**
	 * the class is given control over the main panel and the 
	 * status bar (which is essentially a mini control panel)
	 * @param panel
	 * @param bar
	 */
	public ControlPanel(MainPanel panel, StatusBar bar){
		this.panel = panel;
		this.bar = bar;
		setLayout(new FlowLayout());
   		setBackground(Color.white);

   		button = new JButton("Find Words");
   		button.addActionListener(new ButtonListener());

   		text = new JTextField(10);

   		add(text);
   		add(button);
	}

	private class ButtonListener implements ActionListener{
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent event){
			panel.clear();
			WordHandler word = new WordHandler(text.getText());
			Collection<String> list = word.wordList();
			Object[] arr = list.toArray();
			Arrays.sort(arr,new Comparator1());
			panel.addList(arr);
			bar.setCount(arr.length);
			bar.setList(arr);
		}
	}

	@SuppressWarnings("rawtypes")
	/**
	 * this comparator will prioritize the length of the string
	 * therefore the words that have more letters will appear 
	 * higher on the list
	 * @author steven
	 *
	 */
	private class Comparator1 implements Comparator{
		public int compare(Object ths ,Object tht) {
			if (((String)ths).length()<((String)tht).length()) {
				return 1;
			} 
			else if (((String)ths).length()>((String)tht).length()) {
				return -1;
			} else {
				return ((String)ths).compareTo((String)tht) ;
			}
		}
	}
}