package com.mahadihasan.details;

import com.mahadihasan.db.Connect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class AllMembersDatal extends JFrame {

    private JTextArea allInfoArea;
    private JTextArea mwInfoArea;
    private JButton allButton;
    private JButton memberWiseButton;
    private JButton backButton;
    private JComboBox nameComboBox;
    String[] names;

    public AllMembersDatal() {

        super("Details");

        
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.GRAY);
//=====================================================================

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        setLocation(screanWidth / 4, screanHeight / 4);

        //====================================================

        Font font1 = new Font("Tahoma", Font.BOLD, 20);
        Font font2 = new Font("Tahoma", Font.BOLD, 15);
        

        allInfoArea = new JTextArea(10, 10);
        mwInfoArea = new JTextArea(10, 10);

        allButton = new JButton("All");
        memberWiseButton = new JButton("MemberWise");

        Connect connect = new Connect();
        names = connect.getMembers();

        nameComboBox = new JComboBox(names);
        backButton = new JButton("BACK");

        add(allInfoArea);
        add(mwInfoArea);
        add(allButton);
        add(nameComboBox);
        add(memberWiseButton);
        add(backButton);

        allButton.addActionListener(
                new ActionListener() {

                    int a, b;
                    double mealRate;
                    int tBazarCost;

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        AllInfo allInfo = new AllInfo();
                        try {

                            a = allInfo.getTotalMeals();
                            b = allInfo.getTotalDeposit();
                            mealRate = allInfo.calculateMealRate();
                            tBazarCost = allInfo.getTotalBazarCost();
                        } catch (Exception exception) {
                        }

                        allInfoArea.setText("Total Deposit: " + b + "\nTotal Meal: " + a
                                + "\nTotal Bazar Cost: " + tBazarCost + "\nMeal Rate: " + mealRate);
                    }
                });

        memberWiseButton.addActionListener(
                new ActionListener() {

                    String name;
                    int deposit;
                    int meal;
                    double mealRate;
                    double balance;

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        AllInfo allInfo = new AllInfo();

                        name = nameComboBox.getSelectedItem().toString();
                        try {
                            deposit = allInfo.getMembersTotalDeposit(name);
                            meal = allInfo.getMembersTotalMeal(name);
                            mealRate = allInfo.calculateMealRate();
                            balance = allInfo.denaPaona(name);

                        } catch (Exception exception) {
                        }


                        mwInfoArea.setText("Total Deposit(" + name + "): " + deposit
                                + "\nTotal Meal: " + meal + "\nMeal Rate : " + mealRate
                                + "\nDena Paona : " + balance);
                    }
                });

        backButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        dispose();
                        //MainWindow mainWindow = new MainWindow();
                    }
                });
    }
}
