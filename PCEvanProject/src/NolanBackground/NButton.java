package NolanBackground;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NButton extends JButton {

	public NButton(String name){
		this.setText(name);
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
	}
	
	
}
