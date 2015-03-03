package JayUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UISale extends JFrame {

	private JPanel contentPane;
	
	public static JButton btnUpdate;
	public static JTextField tfItemName;
	public static JTextField tfItemDiscount;
	public static JLabel lblItemName;
	public static JLabel lblItemDiscount;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UISale frame = new UISale();
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
	public UISale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setSize(new Dimension(60,40));
		btnUpdate.setLocation(380, 230);
		contentPane.add(btnUpdate, null);
		
		lblItemName = new JLabel("Item Name:");
		lblItemName.setBounds(70, 70, 200, 16);
		contentPane.add(lblItemName);
		
		tfItemName = new JTextField();
		tfItemName.setBounds(190, 65, 134, 28);
		contentPane.add(tfItemName);
		tfItemName.setColumns(10);
		
		lblItemDiscount = new JLabel("Item Discount:    %");
		lblItemDiscount.setBounds(70, 120, 200, 16);
		contentPane.add(lblItemDiscount);
		
		tfItemDiscount = new JTextField();
		tfItemDiscount.setBounds(190, 115, 134, 28);
		contentPane.add(tfItemDiscount);
		tfItemDiscount.setColumns(10);
		
	}

}
