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

import javax.swing.event.DocumentEvent;

import javax.swing.event.DocumentListener;

import javax.swing.JTextField;

import javax.swing.JLabel;

import javax.swing.JButton;





import NolanBackground.BackgroundMain2;





public class UISetting extends JFrame implements ActionListener, DocumentListener{



static JPanel contentPane;
static JTextField textField;
static JTextField tfItemStatusName;
static JLabel lblPath;
static JLabel lblItemStatusName;
static JLabel lblItemStatusPrice;
static JLabel lblItemStatusGST;
static JLabel lblItemStatusPST;
static JLabel lblItemStatusSale;
static JButton btnSavePath;
static JButton btnRevert;
static JButton btnViewItemStatus;


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


tfItemStatusName = new JTextField();
tfItemStatusName.setBounds(90, 110, 200, 20);
contentPane.add(tfItemStatusName, BorderLayout.CENTER);
tfItemStatusName.setColumns(10);


lblPath = new JLabel("Path :");
lblPath.setBounds(50, 50, 100, 20);
contentPane.add(lblPath, BorderLayout.WEST);

lblItemStatusName = new JLabel("Item Name :");
lblItemStatusName.setBounds(10, 110, 100, 20);
contentPane.add(lblItemStatusName, BorderLayout.WEST);


lblItemStatusPrice = new JLabel("Item Price : $");
lblItemStatusPrice.setBounds(17, 140, 150, 20);
contentPane.add(lblItemStatusPrice, BorderLayout.WEST);


lblItemStatusGST = new JLabel("Item GST : %");
lblItemStatusGST.setBounds(23, 170, 150, 20);
contentPane.add(lblItemStatusGST, BorderLayout.WEST);


lblItemStatusPST = new JLabel("Item PST : %");
lblItemStatusPST.setBounds(25, 200, 150, 20);
contentPane.add(lblItemStatusPST, BorderLayout.WEST);


lblItemStatusSale = new JLabel("Item Sale : %");
lblItemStatusSale.setBounds(23, 230, 150, 20);
contentPane.add(lblItemStatusSale, BorderLayout.WEST);


btnSavePath = new JButton("Save Path");
btnSavePath.setBounds(300,37,80,20);
contentPane.add(btnSavePath, BorderLayout.NORTH);


btnRevert = new JButton("Revert to Default");
btnRevert.setBounds(300,63,130,20);
contentPane.add(btnRevert, BorderLayout.NORTH);


btnViewItemStatus = new JButton("View Item Status");
btnViewItemStatus.setBounds(300,110,127,20);
contentPane.add(btnViewItemStatus, BorderLayout.NORTH);



btnViewItemStatus.addActionListener(this);
btnSavePath.addActionListener(this);
btnRevert.addActionListener(this);





tfItemStatusName.getDocument().addDocumentListener(this);
//tfItemStatusName.setFocusable(true);
//tfItemStatusName.addActionListener(new ActionListener() {
    //    public void actionPerformed(ActionEvent e) {
    //      System.out.println("Text=" + tfItemStatusName.getText());
    //    }
    //  });
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
if (e.getSource() == btnSavePath){
BackgroundMain2.changeDirectory(textField.getText()) ;
//initUIMainButtons();

} else if (e.getSource() == btnRevert){
BackgroundMain2.changeDirectory("res");
textField.setText(BackgroundMain2.path);
//initUIMainButtons();

} else if (e.getSource() == btnViewItemStatus){
boolean nameExists = false;
if (!UIMain.button.isEmpty()){
for (JButton bt : UIMain.button){
if (bt.getText().equals(tfItemStatusName.getText())){

nameExists = true;

double Price = BackgroundMain2.getItem(bt.getText()).getPrice();
double GST = BackgroundMain2.getItem(bt.getText()).getGST()*100;
double PST = BackgroundMain2.getItem(bt.getText()).getPST()*100;
double Sale = BackgroundMain2.getItem(bt.getText()).getSale()*100;

lblItemStatusPrice.setText(String.format("Item Price : $%s", Price));
lblItemStatusGST.setText(String.format("Item GST : %%%s", GST));
lblItemStatusPST.setText(String.format("Item PST : %%%s", PST));
lblItemStatusSale.setText(String.format("Item Sale : %%%s", Sale));


break;
}
}

}

if (!nameExists){
System.out.print("This name that you are trying to view status of does not exist");
tfItemStatusName.setText("");
lblItemStatusPrice.setText("Item Price : $");
lblItemStatusGST.setText("Item GST : %");
lblItemStatusPST.setText("Item PST : %");
}

}/* else if (e.getSource() == tfItemStatusName){
lblItemStatusPrice.setText("Item Price : $");
lblItemStatusGST.setText("Item GST : %");
lblItemStatusPST.setText("Item PST : %");
}*/
}
public void initUIMainButtons(){
UIMain.button.clear();
UIMain.btnCollum = 0;
UIMain.buttonI = 0;
UIMain.btnScrollPane.removeAll();
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
UIMain.btnScrollContentPane.add(btn);

//scrollContentPane.revalidate();
//scrollPane.
UIMain.btnCollum++;
UIMain.buttonI++;
}

int y = UIMain.button.get(UIMain.buttonI-1).getLocation().y;

UIMain.btnScrollContentPane.setPreferredSize(new Dimension(730,y+120));
UIMain.btnScrollContentPane.setSize(730,y+120);

}


UIMain.btnScrollPane.repaint();
}



@Override

public void insertUpdate(DocumentEvent e) {
// TODO Auto-generated method stub
// TODO Auto-generated method stub
System.out.print("Insert");
lblItemStatusPrice.setText("Item Price : $");

lblItemStatusGST.setText("Item GST : %");
lblItemStatusPST.setText("Item PST : %");
}



@Override

public void removeUpdate(DocumentEvent e) {
// TODO Auto-generated method stub
System.out.print("Remove");
// TODO Auto-generated method stub
lblItemStatusPrice.setText("Item Price : $");
lblItemStatusGST.setText("Item GST : %");
lblItemStatusPST.setText("Item PST : %");
}


@Override
public void changedUpdate(DocumentEvent e) {
System.out.print("Change");
// TODO Auto-generated method stub
lblItemStatusPrice.setText("Item Price : $");
lblItemStatusGST.setText("Item GST : %");
lblItemStatusPST.setText("Item PST : %");
}





}