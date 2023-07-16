
package bank.management.system;

import javax.swing.*;
import java.awt.*; //contains image feature
import java.awt.event.*; //contains actionlistener
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JButton login, signup,clear; 
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setTitle("Automatic Teller Machine");
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT); //used to scale the size of image
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3); //IMAGE CANT BE PUT IN JLABEL LIKE IMAGEICON
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text= new JLabel("Welcome To ATM");
        text.setFont(new Font("osward", Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno= new JLabel("Card No : ");
        cardno.setFont(new Font("Raleway", Font.BOLD,25));
        cardno.setBounds(120,150,150,30); // here y=150 bcoz ATM text itself is till 80(40 in y and 40 in height)
        add(cardno);
        
         cardTextField= new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin= new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD,25));
        pin.setBounds(120,220,250,30);// HERE Y= 220 BCOZ(150+40) ALREADY OCCUPIED BY CARD NUM
        add(pin);
        
         pinTextField= new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);
        
        login= new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear= new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup= new JButton("SIGN UP");
        signup.setBounds(300,350,100,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
        
       setSize(800,480);
       setUndecorated(true);
              setLocation(350,150);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber= cardTextField.getText();
            String pinnumber= pinTextField.getText();
            String query= "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login().setVisible(true);
    }
}
