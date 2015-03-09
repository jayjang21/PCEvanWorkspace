package JayUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import NolanBackground.BackgroundMain2;
import NolanBackground.Items;

public class UIMultiplyItem extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	static JTextField tfItemName;
	static JTextField tfNumberMultiply;

	static JLabel lblItemName;
	static JLabel lblNumberMultiply;
	
	static JButton btnMultiply;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIMultiplyItem frame = new UIMultiplyItem();
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
	public UIMultiplyItem() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		tfItemName = new JTextField();
		tfItemName.setBounds(115, 35, 150, 20);
		contentPane.add(tfItemName, BorderLayout.CENTER);
		tfItemName.setColumns(10);
		
		tfNumberMultiply = new JTextField();
		tfNumberMultiply.setBounds(115, 75, 150, 20);
		contentPane.add(tfNumberMultiply, BorderLayout.CENTER);
		tfNumberMultiply.setColumns(10);
		
		
		lblItemName = new JLabel("Item Name :");
		lblItemName.setBounds(30, 35, 100, 20);
		contentPane.add(lblItemName, BorderLayout.CENTER);
		//lblItemName.setColumns(10);
		
		lblNumberMultiply = new JLabel("Multiply By :");
		lblNumberMultiply.setBounds(30, 75, 100, 20);
		contentPane.add(lblNumberMultiply, BorderLayout.CENTER);
		//lblNumberMultiply.setColumns(10);
		
		btnMultiply = new JButton("X");
		btnMultiply.setBounds(285, 45, 40, 40);
		contentPane.add(btnMultiply, BorderLayout.CENTER);
		//lblItemName.setColumns(10);
		
		
		
		btnMultiply.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnMultiply){
			
			Integer in = Integer.parseInt(tfNumberMultiply.getText());
			String itemName = tfItemName.getText();
			
			boolean nameExists = false;
			if (!UIMain.button.isEmpty()){
			for (JButton bt : UIMain.button){
			if (bt.getText().equals(tfItemName.getText())){
			nameExists = true;
			break;
			}
			}
			}
			if (nameExists){
			for (int i = 0; i < in; i ++){
				double price = BackgroundMain2.getPrice(itemName);
				//Need the information
				//String priceStr = String.format("%f", price);
				
				BackgroundMain2.totalPrice += price;

				UIMain.itemListModel.addElement(itemName);
				UIMain.itemListModel.addElement(price);
				
				UIMain.setProperItemScrollPaneScroll();
		
				UIMain.lblTotalPrice.setText(String.format("Total Price = $%f", BackgroundMain2.getTotalPrice()));
	//lblTotalPrice.setText(String.format("%f", BackgroundMain2.getTotalPrice()));
			}
			}
		}
		}

}
