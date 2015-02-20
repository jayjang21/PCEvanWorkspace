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
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JList;
import javax.swing.JButton;

import JoshDatabase.*;
import NolanBackground.*;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.util.Arrays;

public class UIMain extends JFrame implements KeyListener, ActionListener, DocumentListener{

	static JPanel contentPane;
	static JPanel btnScrollContentPane;
	static JList itemList;

	//static JList itemList;
	//static JList btnList;
	//static DefaultListModel btnListModel;
	static DefaultListModel itemListModel;
	static JButton button1;
	static JButton button2;
	static JButton btnGenerator;
	static ArrayList<JButton> button = new ArrayList<JButton>();
	static ArrayList<String> itemListReceipt = new ArrayList<String>();
	static ArrayList<String> initItemNames = new ArrayList<String>();

	static int buttonI;
	static UIAddItem addItem;
	static UIDeleteItem deleteItem;
	static UISetting setting;
	static UIMultiplyItem multiplyItem;
	static UIMain frame;
	
	static JScrollPane btnScrollPane;
	static JScrollPane itemScrollPane;

	static int btnCollum = 0;
	static JButton btnCreditCard;
	static JButton btnSaveReceipt;
	static JLabel lblTotalPrice;
	static JLabel lblPaymentType;
	static JButton btnDeleteItem;
	static JButton btnMinus;
	static JButton btnComboBoxPlus;
	static JButton btnComboBoxMinus;
	static JComboBox comboBox;
	static JButton btnClear;
	static JButton btnSetting;
	static JButton btnMultiply;
	
	
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
		itemList.setSize(new Dimension(0,0));
		itemList.setLocation(10,10);
		//itemList.setLayoutOrientation(itemList.HORIZONTAL_WRAP);
		contentPane.add(itemList, BorderLayout.WEST);
		
		
		itemScrollPane = new JScrollPane();
		itemScrollPane.setBounds(10, 10, 200, 500);
		itemScrollPane.getViewport().setLayout(null);
		itemScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		itemScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		itemScrollPane.setViewportView(itemList);


		contentPane.add(itemScrollPane, BorderLayout.WEST);
		
		/*btnListModel = new DefaultListModel();
		btnList = new JList(itemListModel);
		btnList.setSize(new Dimension(400,500));
		btnList.setLocation(500, 50);
		contentPane.add(btnList, BorderLayout.WEST);*/
		
		btnScrollContentPane = new JPanel();
		//scrollContentPane.setBounds(0, 50, 600, 550);
		//scrollContentPane.setLocation(350, 50);
		btnScrollContentPane.setLayout(null);
		
		
		btnScrollPane = new JScrollPane();
		btnScrollPane.setBounds(280, 60, 750, 550);
		//scrollPane.setLocation(350, 50);
		btnScrollPane.getViewport().setLayout(null);
		//scrollPane.setPreferredSize(new Dimension(1000, 700));
		//scrollPane.getViewport().setLayout(new ScrollPaneLayout());
		//scrollPane.setLayout(new ScrollPaneLayout());
		btnScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		btnScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane.
		btnScrollPane.setViewportView(btnScrollContentPane);


		contentPane.add(btnScrollPane, BorderLayout.WEST);
		//scrollPane.setBounds(116, 133, 4, 4);

		initItemNames = BackgroundMain2.getItems();
		//String[] initItemNames = {"SkateGuard", "ChestGuard", "h", "k", "ie", "fjdkfj", "skdjfds","dkdk", "w", "q", "dd", "rrr", "wl", "wdkfj", "dkfjw", "r", "ekew", "widkfj", "qkqk", "dddd", "qqqqq", "dkdjwl", "wowowo", "ekd", "djflwkd", "wlwlwl", "dlfwkdj", "wkxkk", "qpqp", "dkfjw", "xkxk", "djwl"};
		if (!initItemNames.isEmpty()){
		for (int i = initItemNames.size(); i > 0; i --){
			JButton btn = new JButton(String.format("%s", initItemNames.get(i - 1)));
			btn.setSize(new Dimension(100,100));
			setProperBtnLocation(btn);
			btn.addActionListener(this);
			
			button.add(btn);
			//System.out.print(btn.getLocation());
			//scrollContentPane.add(btn);
			//scrollPane.getViewport().add(btn, null);
			btnScrollContentPane.add(btn);

			//scrollContentPane.revalidate();
			//scrollPane.
			
			btnCollum++;
			buttonI++;
		}
		
		int y = button.get(buttonI-1).getLocation().y;
		
		btnScrollContentPane.setPreferredSize(new Dimension(730,y+120));
		btnScrollContentPane.setSize(730,y+120);
		}
		
		
		btnScrollPane.repaint();
		
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
		
		btnMinus = new JButton("-");
		btnMinus.setSize(new Dimension(40,40));
		btnMinus.setLocation(215, 55);
		contentPane.add(btnMinus, null);
		
		btnMultiply = new JButton("x");
		btnMultiply.setSize(new Dimension(40,40));
		btnMultiply.setLocation(215, 15);
		contentPane.add(btnMultiply, null);
		
		btnClear = new JButton("Clear");
		btnClear.setSize(new Dimension(60,40));
		btnClear.setLocation(215, 95);
		contentPane.add(btnClear, null);
		
		btnComboBoxPlus = new JButton("+");
		btnComboBoxPlus.setSize(new Dimension(20,20));
		btnComboBoxPlus.setLocation(205, 563);
		contentPane.add(btnComboBoxPlus, null);
		
		btnComboBoxMinus = new JButton("-");
		btnComboBoxMinus.setSize(new Dimension(20,20));
		btnComboBoxMinus.setLocation(230, 563);
		contentPane.add(btnComboBoxMinus, null);
		
		btnSetting = new JButton("Setting");
		btnSetting.setSize(new Dimension(60,40));
		btnSetting.setLocation(1205, 15);
		contentPane.add(btnSetting, null);
		
		lblTotalPrice = new JLabel("Total Price = $");
		lblTotalPrice.setBounds(40, 530, 200, 16);
		contentPane.add(lblTotalPrice);
		
		/*tfItemMultiply = new JTextField();
		tfItemMultiply.setBounds(215, 30, 100, 20);
		contentPane.add(tfItemMultiply, BorderLayout.CENTER);
		tfItemMultiply.setColumns(10);*/
		
		
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(35, 560, 150, 27);
		comboBox.setEditable(true);
		comboBox.addItem("Cash");
		comboBox.addItem("Debit Card");
		comboBox.addItem("Master Card");
		comboBox.addItem("Visa Card");

		contentPane.add(comboBox);
		
		
		
		itemList.addKeyListener(this);
		btnGenerator.addActionListener(this);
		btnDeleteItem.addActionListener(this);
		btnSaveReceipt.addActionListener(this);
		btnMinus.addActionListener(this);
		btnMultiply.addActionListener(this);
		btnComboBoxPlus.addActionListener(this);
		btnComboBoxMinus.addActionListener(this);
		btnClear.addActionListener(this);
		btnSetting.addActionListener(this);
		

		setFocusable(true);

	
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
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			int ind = itemList.getSelectedIndex();
			

				if (ind < 0){
					System.out.print("No item is selected from the list yet");
				} else {
				
				//if (itemList.getComponent(ind) instanceof double.class) {
				//if(double.class.isAssignableFrom(itemList.getComponent(ind).getClass()))    
					if(itemList.getModel().getElementAt(ind) instanceof String)
					{
			
						System.out.print(BackgroundMain2.getPrice(itemListModel.getElementAt(ind).toString()));
						BackgroundMain2.totalPrice -= BackgroundMain2.getPrice(itemListModel.getElementAt(ind).toString());
						itemListModel.remove(ind);
						itemListModel.remove(ind);
						
						setProperItemScrollPaneScroll();

					} else {
						System.out.print("Please select an item to delete from the itemList");

					}
				}
			
			
				lblTotalPrice.setText(String.format("Total Price = $%f", BackgroundMain2.totalPrice));
		}
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
			double price = BackgroundMain2.getPrice(btn.getText());
			//Need the information
			//String priceStr = String.format("%f", price);
			
			itemListModel.addElement(btn.getText());
			itemListModel.addElement(price);
			
			setProperItemScrollPaneScroll();
	
			BackgroundMain2.totalPrice += price;
			lblTotalPrice.setText(String.format("Total Price = $%f", BackgroundMain2.getTotalPrice()));
//lblTotalPrice.setText(String.format("%f", BackgroundMain2.getTotalPrice()));
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
		
			/*
			 String a[] = new String[arraysize];
			 for(int i = 0; i < arraysize; i++)
			 {
			 a[i] = string whatever;
			 }
			 */
			for (int i=0; i < itemListModel.getSize(); i ++){
				itemListReceipt.add(itemListModel.get(i).toString());
			}
			itemListReceipt.add(lblTotalPrice.getText());
			itemListReceipt.add(comboBox.getEditor().getItem().toString());
			
			itemListModel.removeAllElements();
			
			setProperItemScrollPaneScroll();
			
			lblTotalPrice.setText("Total Price = $");
			
			System.out.print(itemListReceipt);
			 //First Step: convert ArrayList to an Object array.
            Object[] objDays = itemListReceipt.toArray();
            //Second Step: convert Object array to String array
            String[] strDays = Arrays.copyOf(objDays, objDays.length, String[].class);
            
			BackgroundMain2.writeReceipt(strDays);
			
			itemListReceipt.clear();
		}  else if (e.getSource() == btnDeleteItem){//
			
			deleteItem = new UIDeleteItem();
			deleteItem.setVisible(true);
		} else if (e.getSource() == btnMinus){
			
			int ind = itemList.getSelectedIndex();
			

			if (ind < 0){
				System.out.print("No item is selected from the list yet");
			} else {
				
				//if (itemList.getComponent(ind) instanceof double.class) {
				//if(double.class.isAssignableFrom(itemList.getComponent(ind).getClass()))    
				if(itemList.getModel().getElementAt(ind) instanceof String)
				{
			
					System.out.print(BackgroundMain2.getPrice(itemListModel.getElementAt(ind).toString()));
					BackgroundMain2.totalPrice -= BackgroundMain2.getPrice(itemListModel.getElementAt(ind).toString());
					itemListModel.remove(ind);
					itemListModel.remove(ind);
					
					setProperItemScrollPaneScroll();

				} else {
					System.out.print("Please select an item not the price from the itemList");

				}
			}
			
			
			lblTotalPrice.setText(String.format("Total Price = $%f", BackgroundMain2.totalPrice));
		} else if (e.getSource() == btnComboBoxPlus){
			
			Object item = comboBox.getEditor().getItem();
			//if ()
			boolean itemExists = false;
			int in = comboBox.getItemCount();
			for (int i = 0; i < comboBox.getItemCount(); i ++){
				if (comboBox.getItemAt(i).equals(item)){
					System.out.print("the item you are trying to add into the JComboBox already exists");
					itemExists = true;
					break;
				} 
			}
			if (!itemExists){
			comboBox.addItem(item);
			}
		} else if (e.getSource() == btnComboBoxMinus){
			comboBox.removeItem(comboBox.getSelectedItem());
			comboBox.getEditor().setItem("");
		} else if (e.getSource() == btnClear){
			itemListModel.removeAllElements();
			
			int y = itemListModel.getSize();
			
			itemList.setPreferredSize(new Dimension(180,y*15+y*2));
			//itemScrollPane.setPreferredSize(new Dimension(200,y*100));
			itemList.setSize(180,y*15+y*3);
	
			BackgroundMain2.totalPrice = 0;
			lblTotalPrice.setText("Total Price = $");
		} else if (e.getSource() == btnSetting){
			setting = new UISetting();
			setting.setVisible(true);
		} else if (e.getSource() == btnMultiply){
			multiplyItem = new UIMultiplyItem();
			multiplyItem.setVisible(true);
		}
		}
	public static void setProperBtnLocation(JButton btn){
		
			
			int btnRow = (int)(Math.ceil(buttonI/6));
			/*if (btnRow > 5){
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
			}*/
			
			if (btnCollum > 5){
				btnCollum = 0;
			}
			btn.setLocation(10+120*btnCollum, 10+120*btnRow);
		
	}
	
	public static void setProperItemScrollPaneScroll(){
		int y = itemListModel.getSize();
		
		itemList.setPreferredSize(new Dimension(180,y*15+y*2));
		itemList.setSize(180,y*15+y*3);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
	}
	
	
