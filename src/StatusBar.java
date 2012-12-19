import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

/**
 * This is essentially another control bar that displays 
 * the number of words matches found 
 * and contains the methods to filter words.
 * @author steven
 *
 */
public class StatusBar extends JPanel{
	private static final long serialVersionUID = 1L;
	private MainPanel panel;
	private JLabel count;
	private JButton button;
	private JTextField text;
	private Object[] list;

	public StatusBar(MainPanel panel){
		this.panel = panel;

		setLayout(new GridLayout(3,1));
		count = new JLabel("Enter Your Letters!");
		button = new JButton("Filter");
		text = new JTextField(10);
		button.addActionListener(new ButtonListener());

		add(count);
		add(text);
		add(button);
	}

	public void setCount(int num){
		count.setText(num+ " Words Found!");
		updateUI();
	}

	public void setList(Object[] list){
		this.list = list;
	}

	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			panel.clear();
			ArrayList<Object> arr = new ArrayList<Object>();
			if(text.getText().isEmpty()){
				for(Object o: list){
					arr.add(o);
				}				
			}
			else{
				for(Object o: list){
					if(o.toString().matches(text.getText())){
						arr.add(o);
					}
				}
			}
			panel.addList(arr.toArray());
			setCount(arr.size());
		}
	}
}