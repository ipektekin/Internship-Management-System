package screens;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;

import javax.swing.*;

public class CheckStudents {
	private String column[] = {"ID","NAME","SURNAME","DEPT","EMAIL","EVALUATED"};
	//private ArrayList<String[]> list = new ArrayList<String[]>();
	private String data[][];
	public CheckStudents() {
		ShowStudents();
	}
	
	public void ShowStudents() {
		try {
			JFrame f = new JFrame();
			
			GetStudents();
			
			f.setSize(800, 300);
			f.setVisible(true);
			f.setLocationRelativeTo(null); 

			JTable jt = new JTable(data,column);
			jt.setBounds(30, 40, 200, 300);
			JScrollPane sp=new JScrollPane(jt);
			f.add(sp);
			
			f.addWindowListener(new java.awt.event.WindowAdapter() {
		    	@Override
		    	public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		            	AcaWindow aca = new AcaWindow();
		            	f.dispose();
		    	}
			});
		}
		catch (ClassNotFoundException ex) {
				System.out.println("Class not found exception");
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage() + "\n");
			System.out.println("SQLState:     " + ex.getSQLState() + "\n");
			System.out.println("VendorError:  " + ex.getErrorCode() + "\n");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void GetStudents() throws SQLException, ClassNotFoundException{
		
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","");
    	
    	Statement stmt = conn.createStatement();
    	
		ResultSet rs = stmt.executeQuery("Select id,name,surname,dept,email,IsEvaluated from evaluationform");
		int k=0;
		while(rs.next()) {
			k++;
		}
		rs.beforeFirst();
		data = new String[k][6];
		int i =0;
		while(rs.next()) {
			int a=1;
			for(int j=0;j<=5;j++,a++)	{
				data[i][j]=rs.getString(a);
			}
			i++;
		}
	}
	
}
