package screens;

import javax.swing.*;
import java.sql.*;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDialog extends JFrame {
	 
    private static JTextField tfUsername;
    private static JPasswordField pfPassword;
    private static JLabel lbUsername;
    private static JLabel lbPassword;
    private static JButton btnLogin;
    private static JButton btnCancel;
    private static JCheckBox chkStu;
    private static JCheckBox chkAca;
    
    public static void main(String[] args) {
    		try {
    			createLogin(); 
    		}
    		catch ( Exception e){
    			e.printStackTrace();
    		}
    	}
    
    public static void createLogin() {
    	JFrame f=new JFrame("Username Password Example");

        lbUsername = new JLabel("Username: ");
        lbUsername.setBounds(10, 5, 100, 30);
        
 
        tfUsername = new JTextField(20);
        tfUsername.setBounds(80, 5, 150, 30);
        
        lbPassword = new JLabel("Password: ");
        lbPassword.setBounds(10, 45, 100, 30);
        
 
        pfPassword = new JPasswordField(20);
        pfPassword.setBounds(80, 45, 150, 30);
        
        String password = new String(pfPassword.getPassword());
        
        chkStu = new JCheckBox("Student");
        chkStu.setBounds(10, 85, 75, 30);
        chkStu.doClick();
        
        chkAca = new JCheckBox("Academician");
        chkAca.setBounds(90, 85, 100, 30);
        chkAca.setSelected(false);
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(chkStu);
        buttonGroup1.add(chkAca);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(10, 150, 100, 30);
        btnLogin.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			try {
        				if(checkLoginDetails(getUsername(),getPassword())){
        					System.out.println("Valid login credentials");
        					if(chkStu.isSelected()) {
        						StudentWindow stu = new StudentWindow();
        						f.dispose();
                			}
                			else if(chkAca.isSelected()) {
                				AcaWindow aca = new AcaWindow();
                				f.dispose();
                			}
                			else
                				System.out.println("Wrong selection");
        				}
        				else {
        			    	System.out.println("Invalid login credentials");
        			    	pfPassword.setText("");
        			    	tfUsername.setText("");
        				}
        			}
        			catch (ClassNotFoundException ex) {
        				System.out.println("Class not found exception");
        			}
        			catch (SQLException ex) {
        				System.out.println("SQLException: " + ex.getMessage() + "\n");
        				System.out.println("SQLState:     " + ex.getSQLState() + "\n");
        				System.out.println("VendorError:  " + ex.getErrorCode() + "\n");
        			}
        			catch (Exception ex) {
        				System.out.println("Exception found.");
        			}
        		}
        });
        
        
        
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(120, 150, 100, 30);
        btnCancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                System.exit(0);
            }
        });
        
        
        f.add(lbUsername);f.add(tfUsername);
        f.add(lbPassword);f.add(pfPassword);
        f.add(chkStu);f.add(chkAca);
        f.add(btnLogin); f.add(btnCancel);
        f.setSize(400, 300);
        f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null); 
		
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    //Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(f, 
		            "Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }
		    }
		});
    }
    
    public static boolean checkLoginDetails(String tempuser,String temppass) throws SQLException, ClassNotFoundException{
    	boolean flag = false;
    	
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","");

    	Statement stmt = conn.createStatement();
    	
		ResultSet rs = stmt.executeQuery("select * from login");
	
		while(rs.next()) {
			if(rs.getString("username").equals(tempuser) && rs.getString("password").equals(temppass) && chkStu.isSelected()==rs.getBoolean("isstudent")) {
				flag = true;
				break;
			}
			else if(rs.getString("username").equals(tempuser) && rs.getString("password").equals(temppass) && !chkAca.isSelected()==rs.getBoolean("isstudent")) {
				flag = true;
				break;
			}
			else 
				flag = false;
		}
		if(flag==true)
			return true;
		else
			return false;
    }
    
    public static String getPassword() {
        return new String(pfPassword.getPassword());
    }
    
    public static String getUsername() {
        return tfUsername.getText().trim();
    }
}