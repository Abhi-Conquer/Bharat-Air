      
package airlinemanagementsystem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton reset, submit, close;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        tfusername = new JTextField("");
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);
        
        tfpassword = new JPasswordField("");
        tfpassword.setBounds(130, 60, 200, 20);
        add(tfpassword);
        
        JLabel lblusername = new JLabel("username");
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername);
        
        JLabel lblpassword = new JLabel("password");
        lblpassword.setBounds(20, 60, 100, 20);
        add(lblpassword);
        
        reset = new JButton("reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("submit");
        submit.setBounds(190, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("close");
        close.setBounds(140, 160, 120, 20);
        close.addActionListener(this);
        add(close);
        
        setSize(400, 250);
        setLocation(600, 250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== submit){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            try{
                Conn c = new Conn();
                
                String query = "Select * from login where username ='"+username+ "'and password = '"+password+"'";
                ResultSet rs = c.s.executeQuery(query);
                        
                if (rs.next()){
                    new Home();
                    setVisible(false);
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource()== close){
            setVisible(false);
        }else if (ae.getSource()== reset){
            tfusername.setText("");
            tfpassword.setText("");
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}