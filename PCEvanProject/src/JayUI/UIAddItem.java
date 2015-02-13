package JayUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import JayUI.UIMain;
public class UIAddItem extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	static JTextField textField;
	static JButton btnFinish;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIAddItem frame = new UIAddItem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UIAddItem() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setSize(new Dimension(100, 50));
		lblNewLabel.setLocation(65, 50);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setBounds(164, 62, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnFinish = new JButton("Add Item");
		btnFinish.setSize(new Dimension(100, 50));
		btnFinish.setLocation(330, 210);
		contentPane.add(btnFinish);
		
		btnFinish.addActionListener(this);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btnFinish){
			System.out.print("btnFinish pressed");
			boolean nameExists = false;
			for (JButton bt : UIMain.button){
				if (bt.getText().equals(textField.getText())){
					System.out.print("This name that you are trying to generate already exists");
					nameExists = true;
					break;
				}
			}
			if (!nameExists){
			JButton btn = new JButton(String.format("%s", textField.getText()));
			btn.setSize(new Dimension(100,100));
			UIMain.setProperBtnLocation(btn);
			btn.addActionListener(UIMain.frame);
			UIMain.scrollContentPane.add(btn, BorderLayout.EAST);
			UIMain.button.add(btn);
			
			UIMain.btnCollum ++;
			UIMain.buttonI ++;
			
			int i = btn.getLocation().y;
			UIMain.scrollContentPane.setPreferredSize(new Dimension(730,i+100+20));
			UIMain.scrollContentPane.setSize(730,i+100+20);


			UIMain.scrollPane.repaint();
			textField.setText("");
			//focus the textField.
			textField.requestFocus();
			}
		}
	}
	
}
