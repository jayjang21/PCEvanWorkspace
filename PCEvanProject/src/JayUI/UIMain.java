package JayUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;

import JoshDatabase.*;
import NolanBackground.*;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class UIMain extends JFrame implements KeyListener, ActionListener{

	static JPanel contentPane;
	static JPanel scrollContentPane;
	static JList itemList;
	//static JList btnList;
	static DefaultListModel btnListModel;
	static DefaultListModel itemListModel;
	static JButton button1;
	static JButton button2;
	static JButton btnGenerator;
	static ArrayList<JButton> button = new ArrayList<JButton>();
	static ArrayList<String> itemListReceipt = new ArrayList<String>();
	static int buttonI;
	static UIAddItem addItem;
	static UIDeleteItem deleteItem;
	static UIMain frame;
	static JScrollPane scrollPane;
	static int btnCollum = 0;
	static JButton btnCreditCard;
	static JButton btnSaveReceipt;
	static JLabel lblTotalPrice;
	static JLabel lblPaymentType;
	static JButton btnDeleteItem;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UIMain();
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
		
		itemListModel = new DefaultListModel();
		itemList = new JList(itemListModel);
		itemList.setSize(new Dimension(200,500));
		itemList.setLocation(10, 10);
		contentPane.add(itemList, BorderLayout.WEST);
		
		/*btnListModel = new DefaultListModel();
		btnList = new JList(itemListModel);
		btnList.setSize(new Dimension(400,500));
		btnList.setLocation(500, 50);
		contentPane.add(btnList, BorderLayout.WEST);*/
		
		scrollContentPane = new JPanel();
		//scrollContentPane.setBounds(0, 50, 600, 550);
		//scrollContentPane.setLocation(350, 50);
		scrollContentPane.setLayout(null);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(280, 60, 750, 550);
		//scrollPane.setLocation(350, 50);
		scrollPane.getViewport().setLayout(null);
		//scrollPane.setPreferredSize(new Dimension(1000, 700));
		//scrollPane.getViewport().setLayout(new ScrollPaneLayout());
		//scrollPane.setLayout(new ScrollPaneLayout());
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane.
		scrollPane.setViewportView(scrollContentPane);


		contentPane.add(scrollPane, BorderLayout.WEST);
		//scrollPane.setBounds(116, 133, 4, 4);

		//String[] initItemNames = DatabaseMain.readInitItemNames();
		String[] initItemNames = {"SkateGuard", "ChestGuard", "h", "k", "ie", "fjdkfj", "skdjfds","dkdk", "w", "q", "dd", "rrr", "wl", "wdkfj", "dkfjw", "r", "ekew", "widkfj", "qkqk", "dddd", "qqqqq", "dkdjwl", "wowowo", "ekd", "djflwkd", "wlwlwl", "dlfwkdj", "wkxkk", "qpqp", "dkfjw", "xkxk", "djwl"};
		
		for (String s: initItemNames){
			JButton btn = new JButton(String.format("%s", s));
			btn.setSize(new Dimension(100,100));
			setProperBtnLocation(btn);
			btn.addActionListener(this);
			
			button.add(btn);
			//System.out.print(btn.getLocation());
			//scrollContentPane.add(btn);
			//scrollPane.getViewport().add(btn, null);
			scrollContentPane.add(btn);

			//scrollContentPane.revalidate();
			//scrollPane.
			
			btnCollum++;
			buttonI++;
		}
		
		int y = button.get(buttonI-1).getLocation().y;
		
		scrollContentPane.setPreferredSize(new Dimension(730,y+120));
		scrollContentPane.setSize(730,y+120);


		scrollPane.repaint();
		
		/*for (String s : initItemNames){
			JButton btn = new JButton(String.format("%s", s));
			btn.setSize(new Dimension(100,100));
			setProperBtnLocation(btn);
			btn.addActionListener(this);
			contentPane.add(btn, BorderLayout.EAST);
			button.add(btn);

			btnCollum++;
			buttonI ++;

		}*/

		
		
		/*button1 = new JButton("SkateGuard");
		button1.setSize(new Dimension(100,100));
		button1.setLocation(500, 50);
		contentPane.add(button1, BorderLayout.EAST);
		
		button2 = new JButton("ChestGuard");
		button2.setSize(new Dimension(100,100));
		button2.setLocation(620, 50);
		contentPane.add(button2, BorderLayout.EAST);*/
		
		btnCreditCard = new JButton("Credit Card");
		btnCreditCard.setSize(new Dimension(100,100));
		btnCreditCard.setLocation(1100, 320);
		contentPane.add(btnCreditCard, null);
		
		btnGenerator = new JButton("Generate");
		btnGenerator.setSize(new Dimension(100,50));
		btnGenerator.setLocation(1100, 520);
		contentPane.add(btnGenerator, null);
		
		
		btnSaveReceipt = new JButton("Save Receipt");
		btnSaveReceipt.setSize(new Dimension(100,100));
		btnSaveReceipt.setLocation(1100, 420);
		contentPane.add(btnSaveReceipt, null);
		
		btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setSize(new Dimension(100,50));
		btnDeleteItem.setLocation(1100, 570);
		contentPane.add(btnDeleteItem, null);
		
		lblTotalPrice = new JLabel("Total Price = ");
		lblTotalPrice.setBounds(40, 530, 100, 16);
		contentPane.add(lblTotalPrice);
		
		lblPaymentType = new JLabel("");
		lblPaymentType.setBounds(75, 555, 100, 16);
		contentPane.add(lblPaymentType);
		
		
		addKeyListener(this);
		btnGenerator.addActionListener(this);
		btnDeleteItem.addActionListener(this);
		btnCreditCard.addActionListener(this);
		btnSaveReceipt.addActionListener(this);
		
		
			 

	
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_1){
			System.out.print("delete");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(JButton btn : button){
		if (e.getSource() == btn){
			System.out.print("test");
			//double price = BackgroundMain.getItemPrice(btn.getText());
			//Nolan
			//String buttonText = String.format("%s = %f", btn.getText(), price);
			String buttonText = String.format("%s", btn.getText());
			itemListModel.addElement(buttonText);
			//lblTotalPrice.setText(String.format("Total Price = %d", BackgroundMain.getTotalPrice));
			
			
		}  
		}
		if (e.getSource() == btnGenerator){
			System.out.print("Generator pressed");
			
			addItem = new UIAddItem();
			addItem.setVisible(true);
			//this.add(addItem);
			/*buttonI ++;
			JButton btn = new JButton("ChinGuard");
			btn.setSize(new Dimension(100,100));
			btn.setLocation(620+120*buttonI, 50);
			contentPane.add(btn, BorderLayout.EAST);
			button.add(btn);
			frame.repaint();*/

		}
		else if (e.getSource() == btnSaveReceipt){
			String[] string;
			for (int i=0; i >= itemList.getComponentCount(); i ++){
				itemListReceipt.add(itemList.getComponent(i).toString());
			}
			itemListReceipt.add(lblTotalPrice.getText());
			itemListReceipt.add(lblPaymentType.getText());
			//BackgroundMain.writeReceipt;
		} else if (e.getSource() == btnCreditCard){
			lblPaymentType.setText("Credit Card");
		} else if (e.getSource() == btnDeleteItem){
			deleteItem = new UIDeleteItem();
			deleteItem.setVisible(true);
		}
		
		
		}
	public static void setProperBtnLocation(JButton btn){
		
			double btnRow = buttonI/6;
			int btnRowInt = 0;
			if (btnRow > 5){
				btnRowInt = 6;
			} else if (btnRow > 4){
				btnRowInt = 5;
			} else if (btnRow > 3){
				btnRowInt = 4;
			} else if (btnRow > 2){
				btnRowInt = 3;
			} else if (btnRow > 1){
				btnRowInt = 2;
			} else if (btnRow > 0){
				btnRowInt = 1;
			}
			
			if (btnCollum > 5){
				btnCollum = 0;
			}
			btn.setLocation(10+120*btnCollum, 10+120*btnRowInt);
		
	}
	}
		
	
	
	
