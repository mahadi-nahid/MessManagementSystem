
package com.mahadihasan.deposit;

import com.mahadihasan.db.Connect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import messmanagement.MainWindow;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Deposit extends JFrame {
    
    private JLabel label;
    private JLabel name;
    private JLabel amountLabel;
    private JLabel dateLabel;
    
    private JComboBox nameComboBox;
    private JTextField amountField;
    private JTextField dateField;
    private String[] names;
    private int amount;
    private Date date;
    
    private JButton depositButton;
    private JButton cancelButton;
    
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    
    
    public Deposit() {
        
        super("Deposite");
       
        
        Connect connect = new Connect();
        names = connect.getMembers();
        
        //JOptionPane.showMessageDialog(null, names);
        
        
        Font font1 = new Font("Tahoma", Font.BOLD, 20);
        Font font2 = new Font("Tahoma", Font.BOLD, 15);
        
        
        name = new JLabel("Name : ");
        amountLabel = new JLabel("Amount : ");
        nameComboBox = new JComboBox(names);
        dateLabel = new JLabel("Date : ");
        amountField = new JTextField(10);
        dateField = new JTextField(10);
//        DateEditor dateEditor = new DateEditor(new JSpinner());
        
        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();
        
        label = new JLabel("Deposite");
        topPanel.add(label);
        centerPanel.setLayout(new GridLayout(3, 2, 2, 2));
        
       
        centerPanel.add(name);
        centerPanel.add(nameComboBox);
        centerPanel.add(amountLabel);
        centerPanel.add(amountField);
        centerPanel.add(dateLabel);
        centerPanel.add(dateField);
        
        label.setFont(font1);
        name.setFont(font2);
        nameComboBox.setFont(font2);
        amountLabel.setFont(font2);
        dateLabel.setFont(font2);
        
        //centerPanel.add(dateEditor);
        
        
        depositButton = new JButton("Deposit");
        cancelButton = new JButton("Cancel");
        
        bottomPanel.add(depositButton);
        bottomPanel.add(cancelButton);
        
        depositButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                String name;
                int amount;
                String date;
                
                name = nameComboBox.getSelectedItem().toString();
                
                amount = Integer.parseInt(amountField.getText());
                date = dateField.getText();
                
                
               // JOptionPane.showMessageDialog(null, "mamin   :: "+name+"\n"+amount+"\n"+date);
                
                Connect connect = new Connect();
                //AllInfo allInfo = new AllInfo();
                
                
                try {
                    connect.updateDeposit(name, amount, date);
                    //int a = allInfo.getMembersTotalDeposit(name);
                    //int b = allInfo.getMembersTotalMeal(name);
                }catch(Exception exception){
                    
                }
                dispose();
              //  MainWindow mainWindow = new MainWindow();
                
            }
        });
        cancelButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                dispose();
               // MainWindow mainWindow = new MainWindow();
            }
        });
        
        
        
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        
         getContentPane().setBackground(Color.GREEN);
         
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        setLocation(screanWidth/4, screanHeight/4);
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
