
package messmanagement;

import com.mahadihasan.member.DeleteMember;
import com.mahadihasan.member.AddMember;
import com.mahadihasan.meal.Meal;
import com.mahadihasan.deposit.Deposit;
import com.mahadihasan.bazar.Bazar;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import com.mahadihasan.details.AllMembersDatal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.UIManager;



/**
 *
 * @author MAHADI HASAN NAHID
 */
public class MainWindow extends JFrame {
    
    private JLabel label;
    
    private JButton addMemberButton;
    private JButton bazarButton;
    private JButton mealButton;
    private JButton depositButton;
    private JButton detailButton;
    private JButton deleteMemberButton;
    
    private JFrame mainFrame;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;
    
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    
    public MainWindow() {
        
        super("Mess Management System");
        try { 
              UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
          
         }catch(Exception exception) {
             
         }
        
        getContentPane().setBackground(Color.RED);
        mainFrame = new JFrame();
        
        mainFrame.setSize(600,500);
        mainFrame.setVisible(true);
        
        //========================================
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        mainFrame.setLocation(screanWidth/4, screanHeight/4);
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //========================================================================
       
        addMemberButton = new JButton("Add Member");
        deleteMemberButton = new JButton("Delete A Member");
        bazarButton = new JButton("Update Bazar");
        mealButton = new JButton("Update Meal");
        depositButton = new JButton("Deposit");
        detailButton = new JButton("Detail");
        
        label = new JLabel("Welcome");
        
        Font font = new Font("Tahoma", Font.BOLD, 12);
        label.setFont(font);
        
        setFont(font);
        mainFrame.setLayout(new GridLayout(3,2,2,2));
        
        mainFrame.add(label);
        mainFrame.add(addMemberButton);
        mainFrame.add(deleteMemberButton);
        mainFrame.add(bazarButton);
        mainFrame.add(mealButton);
        mainFrame.add(depositButton);
        mainFrame.add(detailButton);
        
        ActionHandler handler = new ActionHandler();
        
       
        addMemberButton.addActionListener(handler);
        deleteMemberButton.addActionListener(handler);
        bazarButton.addActionListener(handler);
        mealButton.addActionListener(handler);
        depositButton.addActionListener(handler);
        detailButton.addActionListener(handler);
        
        
        
    }
    
    public class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            
            if(event.getSource() == addMemberButton) {
                AddMember newMember = new AddMember();
               
            }
            if(event.getSource() == deleteMemberButton) {
                DeleteMember deleteMember = new DeleteMember();              
            }
            if(event.getSource() == bazarButton) {
                Bazar bazar = new Bazar();
               
            }
            if(event.getSource() == mealButton) {
                Meal meal = new Meal();
                
            }
            if(event.getSource() == depositButton) {
                Deposit deposit = new Deposit();
               
            }
            if(event.getSource()==detailButton) {
                
                AllMembersDatal allMembersDatal = new AllMembersDatal();
               
            }
            
        }
        
    }
    
}
