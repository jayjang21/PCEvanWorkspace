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
import NolanBackground.*;

public class UIAddItem extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	static JTextField tfItemPST;
	static JTextField tfItemGST;
	static JTextField tfItemPrice;
	static JTextField tfItemName;

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
		
		
		JLabel lblItemName = new JLabel("Item Name :");
		lblItemName.setSize(new Dimension(100, 50));
		lblItemName.setLocation(65, 50);
		contentPane.add(lblItemName, BorderLayout.NORTH);
		
		JLabel lblItemPrice = new JLabel("Item Price :     $");
		lblItemPrice.setSize(new Dimension(100, 50));
		lblItemPrice.setLocation(65, 80);
		contentPane.add(lblItemPrice, BorderLayout.NORTH);
		
		JLabel lblItemPST = new JLabel("Item PST :      %");
		lblItemPST.setSize(new Dimension(100, 50));
		lblItemPST.setLocation(65, 110);
		contentPane.add(lblItemPST, BorderLayout.NORTH);
		
		JLabel lblItemGST = new JLabel("Item GST :      %");
		lblItemGST.setSize(new Dimension(100, 50));
		lblItemGST.setLocation(65, 140);
		contentPane.add(lblItemGST, BorderLayout.NORTH);
		
		tfItemName = new JTextField();
		tfItemName.setBounds(164, 62, 134, 28);
		contentPane.add(tfItemName);
		tfItemName.setColumns(10);
		
		tfItemPrice = new JTextField();
		tfItemPrice.setBounds(164, 92, 134, 28);
		contentPane.add(tfItemPrice);
		tfItemPrice.setColumns(10);
		
		tfItemPST = new JTextField();
		tfItemPST.setBounds(164, 122, 134, 28);
		contentPane.add(tfItemPST);
		tfItemPST.setColumns(10);
		
		tfItemGST = new JTextField();
		tfItemGST.setBounds(164, 152, 134, 28);
		contentPane.add(tfItemGST);
		tfItemGST.setColumns(10);
		
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
			if (!UIMain.button.isEmpty()){
				for (JButton bt : UIMain.button){
					if (bt.getText().equals(tfItemName.getText())){
						System.out.print("This name that you are trying to generate already exists");
						nameExists = true;
						break;
					}
				}
			}
			if (!nameExists){
				if (tfItemName.getText() instanceof String){
					
			JButton btn = new JButton(String.format("%s", tfItemName.getText()));
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

			double itemPrice = Double.parseDouble(tfItemPrice.getText());
			double itemPST = Double.parseDouble(tfItemPST.getText());
			double itemGST = Double.parseDouble(tfItemGST.getText());

			
			BackgroundMain2.newItem(new Items(tfItemName.getText(),itemPrice,itemPST,itemGST));

			UIMain.scrollPane.repaint();
			tfItemName.setText("");
			tfItemPrice.setText("");
			
			//focus the textField.
			tfItemName.requestFocus();
				} else {
					System.out.print("All inputs need to be in the proper format");
				}
			}
		}
	}
	
}
