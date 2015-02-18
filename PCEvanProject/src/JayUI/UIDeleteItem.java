package JayUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import NolanBackground.BackgroundMain2;

public class UIDeleteItem extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	static JButton btnDeleteItem;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIDeleteItem frame = new UIDeleteItem();
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
	public UIDeleteItem() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setLocation(150, 110);
		textField.setSize(220, 30);
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setSize(100, 50);
		btnDeleteItem.setLocation(340, 220);
		contentPane.add(btnDeleteItem, BorderLayout.CENTER);
		
		lblNewLabel = new JLabel("Item Name :");
		lblNewLabel.setBounds(60, 75, 100, 100);
		contentPane.add(lblNewLabel);
		
		
		btnDeleteItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnDeleteItem){
			
			
			int i =0;
			boolean itemExistsInList = false;
			String ch = textField.getText();

			for (int in = 0; in < UIMain.itemListModel.getSize(); in ++){
				if (ch.equals(UIMain.itemListModel.getElementAt(in).toString())){
					itemExistsInList = true;
					break;
				}
			}
			if (!itemExistsInList){
			for (JButton btn : UIMain.button){
				if ( btn.getText().equals(textField.getText()) ){
					btn.setVisible(false);
					UIMain.btnScrollContentPane.remove(i);
					UIMain.button.remove(i);
					BackgroundMain2.delete(textField.getText());
					
					//DataBaseMain.removeItem(btn.getText)
					UIMain.btnCollum = 0;
					UIMain.buttonI = 0;
					for (JButton bt: UIMain.button){
				
						bt.setSize(new Dimension(100,100));
						UIMain.setProperBtnLocation(bt);
						
						//System.out.print(btn.getLocation());
						//scrollContentPane.add(btn);
						//scrollPane.getViewport().add(btn, null);
						UIMain.btnScrollContentPane.add(btn);

						//scrollContentPane.revalidate();
						//scrollPane.
						
						UIMain.btnCollum++;
						UIMain.buttonI++;
					} 
					
					int y = UIMain.button.get(UIMain.buttonI-1).getLocation().y;
					
					UIMain.btnScrollContentPane.setPreferredSize(new Dimension(730,y+100+20));
					UIMain.btnScrollContentPane.setSize(730,y+100+20);


					UIMain.btnScrollPane.repaint();
					break;
				}else {
						System.out.print("the name you are searching to delete does not exit");
					}
				i++;
			}
			} else {
				System.out.print("the item you are trying to delete is in the itemLists that the customer is trying to buy. (please save the reciept or delete the item from the itemLists first)");
			}
			//Nolan delete Item
			textField.setText("");
			//focus the textField.
			textField.requestFocus();
		}
		
	}

}