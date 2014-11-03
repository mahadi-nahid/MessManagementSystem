package com.mahadihasan.bazar;

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
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Bazar extends JFrame {

    private JLabel label;
    private JLabel name;
    private JLabel amountLabel;
    private JLabel dateLabel;
    private JComboBox nameComboBox;
    private JTextField amountField;
    private String[] names;
    private Date date;
    private JTextField dateField;
    private JButton saveButton;
    private JButton cancelButton;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;

    public Bazar() {
        super("Bazar");

        getContentPane().setBackground(Color.GREEN);

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

        label = new JLabel("Bazar");
        topPanel.add(label);
        
        centerPanel.setLayout(new GridLayout(3, 2, 2, 2));

        centerPanel.add(name);
        centerPanel.add(nameComboBox);
        centerPanel.add(amountLabel);
        centerPanel.add(amountField);
        centerPanel.add(dateLabel);
        centerPanel.add(dateField);
        //centerPanel.add(dateEditor);

        label.setFont(font1);
        name.setFont(font2);
        nameComboBox.setFont(font2);
        amountLabel.setFont(font2);
        dateLabel.setFont(font2);

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        bottomPanel.add(saveButton);
        bottomPanel.add(cancelButton);


        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);


        saveButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        String name;
                        int amount;
                        String date;

                        name = nameComboBox.getSelectedItem().toString();

                        amount = Integer.parseInt(amountField.getText());
                        date = dateField.getText();

                        Connect connect = new Connect();
                        try {
                            connect.upDateBazar(name, amount, date);
                        } catch (Exception exception) {
                        }

                       // MainWindow mainWindow = new MainWindow();
                        dispose();
                    }
                    
                    
                    
                });
        cancelButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        dispose();
                      //  MainWindow mainWindow = new MainWindow();
                    }
                });


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
