/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo.quizoop.athallah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ThinkPad
 */
class LoginPage extends JFrame implements ActionListener {
    private JLabel titleLabel, usernameLabel, passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    private User user = new User();
    
    public LoginPage() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        JLabel titleLabel = new JLabel("Login");
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 30, 80, 25);
        add(usernameLabel);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 80, 25);
        add(passwordLabel);
        
        usernameTextField = new JTextField();
        usernameTextField.setBounds(120, 30, 120, 25);
        add(usernameTextField);
                
        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(120, 70, 120, 25);
        add(passwordTextField);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(90, 110, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);
        
        setVisible(true);
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == loginButton) {
                if (user.authenticate(usernameTextField.getText(), new String(passwordTextField.getPassword()))) {
                    JOptionPane.showMessageDialog(this, "Login Successful!");
                    new MainMenu();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong usernameor password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
}
