package messmanagement;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class MessManagement extends JFrame {

    private JLabel label;
    private JButton logInButton;
    private JButton registerButton;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;
    private GridBagLayout layout;
    private GridBagConstraints constraints;

    public MessManagement() {

        super("Log In");

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception exception) {
        }

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();


        Font font = new Font("Tahoma", Font.BOLD, 14);
        setLayout(layout);

        getContentPane().setBackground(Color.MAGENTA);

        //========================================


        label = new JLabel("Enter Your Password: ");
        label.setFont(font);
        passwordField = new JPasswordField(10);

        logInButton = new JButton("Log In");

        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        addComponent(label, 1, 1, 1, 1);
        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        addComponent(passwordField, 1, 2, 2, 1);
       
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        addComponent(logInButton, 5, 2, 1, 1);
        

        logInButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        if (passwordField.getText().equals("nahid")) {
                            MainWindow mainWindow = new MainWindow();
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong PassWord", "Error",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });


//========================================================
        setSize(400, 400);
        setVisible(true);
        setResizable(false);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        setLocation(screanWidth / 4, screanHeight / 4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponent(Component component, int row,
            int column, int width, int height) {
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridheight = height;
        constraints.gridwidth = width;

        layout.setConstraints(component, constraints);
        add(component);
    }

    public static void main(String[] args) {
        MessManagement messManagement = new MessManagement();

    }
}
