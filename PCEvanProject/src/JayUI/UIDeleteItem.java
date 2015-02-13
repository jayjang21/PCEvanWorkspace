package JayUI;

import java.awt.BorderLayout;
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
			for (JButton btn : UIMain.button){
				String ch = textField.getText();
				if ( btn.getText().equals(textField.getText()) ){
					btn.setVisible(false);
					UIMain.scrollContentPane.remove(i);
					UIMain.button.remove(i);
					
					//DataBaseMain.removeItem(btn.getText)
					UIMain.btnCollum = 0;
					UIMain.buttonI = 0;
					for (JButton bt: UIMain.button){
				
						bt.setSize(new Dimension(100,100));
						UIMain.setProperBtnLocation(bt);
						
						//System.out.print(btn.getLocation());
						//scrollContentPane.add(btn);
						//scrollPane.getViewport().add(btn, null);
						UIMain.scrollContentPane.add(btn);

						//scrollContentPane.revalidate();
						//scrollPane.
						
						UIMain.btnCollum++;
						UIMain.buttonI++;
					} 
					
					int y = UIMain.button.get(UIMain.buttonI-1).getLocation().y;
					
					UIMain.scrollContentPane.setPreferredSize(new Dimension(730,y+100+20));
					UIMain.scrollContentPane.setSize(730,y+100+20);


					UIMain.scrollPane.repaint();
					break;
				}else {
						System.out.print("the name you are searching to delete does not exit");
					}
				i++;
			}
			textField.setText("");
			//focus the textField.
			textField.requestFocus();
		}
		
	}

}
