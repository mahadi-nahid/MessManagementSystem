package com.mahadihasan.member;

import com.mahadihasan.db.Connect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
public class AddMember extends JFrame {

    private JLabel label;
    private JLabel fNameLabel;
    private JLabel lNameLabel;
    private JLabel nNameLabel;
    private JLabel mobLabel;
    private JLabel emailLabel;
    private JTextField fNameField;
    private JTextField lNameField;
    private JTextField nNameField;
    private JTextField mobField;
    private JTextField emailField;
    private JButton addButton;
    private JButton cancelButton;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private GridBagLayout layout;
    private GridBagConstraints constraints;

    public AddMember() {

        super("Add A Member");

        
        
        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        centerPanel.setLayout(new GridLayout(5, 2, 2, 2));
        Font font1 = new Font("Tahoma", Font.BOLD, 20);
        Font font2 = new Font("Tahoma", Font.BOLD, 15);

        label = new JLabel("Enter The Folowing Information ");
        topPanel.add(label);


        getContentPane().setBackground(Color.GREEN);
        fNameLabel = new JLabel("First Name : ");
        lNameLabel = new JLabel("LastName : ");
        nNameLabel = new JLabel("Nick Name :");
        mobLabel = new JLabel("MObile No : ");
        emailLabel = new JLabel("Email : ");


        fNameField = new JTextField(10);
        lNameField = new JTextField(10);
        nNameField = new JTextField(10);
        mobField = new JTextField(10);
        emailField = new JTextField(10);

        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");


        centerPanel.add(fNameLabel);
        centerPanel.add(fNameField);

        centerPanel.add(lNameLabel);
        centerPanel.add(lNameField);

        centerPanel.add(nNameLabel);
        centerPanel.add(nNameField);

        centerPanel.add(mobLabel);
        centerPanel.add(mobField);

        centerPanel.add(emailLabel);
        centerPanel.add(emailField);

        bottomPanel.add(addButton);
        bottomPanel.add(cancelButton);


        label.setFont(font1);
        fNameLabel.setFont(font2);
        lNameLabel.setFont(font2);
        nNameLabel.setFont(font2);
        mobLabel.setFont(font2);
        emailLabel.setFont(font2);

        addButton.setFont(font2);
        cancelButton.setFont(font2);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);


        addButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {

                        if (!(fNameField.getText().equals("") ||
                                lNameField.getText().equals("")||
                                nNameField.getText().equals("") ||
                                mobField.getText().equals("") ||
                                emailField.getText().equals("")
                                )) {

                            Member member = new Member(fNameField.getText(),
                                    lNameField.getText(),
                                    nNameField.getText(),
                                    mobField.getText(),
                                    emailField.getText());

                            String s = member.getFirstName();
                            
                            //JOptionPane.showMessageDialog(null, s);

                            Connect connect = new Connect();
                            try {
                                connect.saveMemberToDB(member);
                            } catch (Exception exception) {
                            }
                            JOptionPane.showMessageDialog(null, "Succesfully Added ",
                                               "Confirmation",JOptionPane.INFORMATION_MESSAGE);
                            
                            dispose();


                            // MainWindow mainWindow = new MainWindow();
                        }else{
                            JOptionPane.showMessageDialog(null, "Please Fill Up "
                                    + "This Form Completely", "Error",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });

        cancelButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        // MainWindow mainWindow = new MainWindow();
                        dispose();
                    }
                });


        //=======================================================

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        setLocation(screanWidth / 4, screanHeight / 4);

        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }
}
