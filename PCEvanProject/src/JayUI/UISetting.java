package JayUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import NolanBackground.BackgroundMain2;

public class UISetting extends JFrame implements ActionListener{

	static JPanel contentPane;
	static JTextField textField;
	static JLabel lblPath;
	static JButton btnSavePath;
	static JButton btnRevert;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UISetting frame = new UISetting();
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
	public UISetting() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(90, 50, 200, 20);
		textField.setText(BackgroundMain2.path);
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		lblPath = new JLabel("Path :");
		lblPath.setBounds(50, 50, 100, 20);
		contentPane.add(lblPath, BorderLayout.WEST);
		
		btnSavePath = new JButton("Save Path");
		btnSavePath.setBounds(300,37,80,20);
		contentPane.add(btnSavePath, BorderLayout.NORTH);
		
		btnRevert = new JButton("Revert to Default");
		btnRevert.setBounds(300,63,130,20);
		contentPane.add(btnRevert, BorderLayout.NORTH);
		
		btnSavePath.addActionListener(this);
		btnRevert.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnSavePath){
			BackgroundMain2.changeDirectory(textField.getText()) ;
		} else if (e.getSource() == btnRevert){
			BackgroundMain2.changeDirectory("res");
			textField.setText(BackgroundMain2.path);
		}
	}

}
