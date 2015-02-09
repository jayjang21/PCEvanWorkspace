package JayUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;

import JoshDatabase.*;
import NolanBackground.*;

public class UIMain extends JFrame implements KeyListener, ActionListener{

	private JPanel contentPane;
	static JButton button1;
	static JButton button2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIMain frame = new UIMain();
					frame.setExtendedState(MAXIMIZED_BOTH);
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
	public UIMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JList list = new JList();
		contentPane.add(list, BorderLayout.WEST);
		
		button1 = new JButton("SkateGuard");
		button1.setSize(new Dimension(100,100));
		button1.setLocation(500, 50);
		contentPane.add(button1, BorderLayout.EAST);
		
		button2 = new JButton("ChestGuard");
		button2.setSize(new Dimension(100,100));
		button2.setLocation(620, 50);
		contentPane.add(button2, BorderLayout.EAST);
		
	
		addKeyListener(this);
		button1.addActionListener(this);
		
			 

	
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
		if (e.getSource() == button1){
			System.out.print("test");
		}
	}
	}
