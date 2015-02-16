package JayUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
			initUIMainButtons();
			
		} else if (e.getSource() == btnRevert){
			BackgroundMain2.changeDirectory("res");
			textField.setText(BackgroundMain2.path);
			
			initUIMainButtons();

		}
	}
	public void initUIMainButtons(){
		UIMain.button.clear();
		UIMain.btnCollum = 0;
		UIMain.buttonI = 0;
		UIMain.scrollPane.removeAll();
		UIMain.initItemNames = BackgroundMain2.getItems();
		//String[] initItemNames = {"SkateGuard", "ChestGuard", "h", "k", "ie", "fjdkfj", "skdjfds","dkdk", "w", "q", "dd", "rrr", "wl", "wdkfj", "dkfjw", "r", "ekew", "widkfj", "qkqk", "dddd", "qqqqq", "dkdjwl", "wowowo", "ekd", "djflwkd", "wlwlwl", "dlfwkdj", "wkxkk", "qpqp", "dkfjw", "xkxk", "djwl"};
		if (!UIMain.initItemNames.isEmpty()){
		for (int i = UIMain.initItemNames.size(); i > 0; i --){
			JButton btn = new JButton(String.format("%s", UIMain.initItemNames.get(i - 1)));
			btn.setSize(new Dimension(100,100));
			UIMain.setProperBtnLocation(btn);
			btn.addActionListener(this);
			
			UIMain.button.add(btn);
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
		
		UIMain.scrollContentPane.setPreferredSize(new Dimension(730,y+120));
		UIMain.scrollContentPane.setSize(730,y+120);
		}
		
		
		UIMain.scrollPane.repaint();
	}

}
