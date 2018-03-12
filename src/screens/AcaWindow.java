package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AcaWindow {

	private JButton internEva;
	private JButton checkStu;
	
	public AcaWindow(){
		JFrame f=new JFrame("Choose");
		
		checkStu = new JButton("Check Students");
		checkStu.setBounds(100,70,200,30);
		checkStu.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
                CheckStudents chkstu = new CheckStudents();
            	f.dispose();
            }
        });
		
		internEva = new JButton ("Evaluate Internship Form");
		internEva.setBounds(100,140,200,30);
		internEva.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
                EvaluateInternship evaIntern = new EvaluateInternship();
            	f.dispose();
            }
        });
		
		
		f.add(checkStu);
		f.add(internEva);
		f.setSize(400, 300);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null); 

		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		            LoginDialog d = new LoginDialog();
		            d.createLogin();
		            f.dispose();
		    }
		});
	}
	
}
