package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentWindow {
	
	private JButton internApply;
	private JButton reviewIntern;
	
	public StudentWindow(){
		JFrame f=new JFrame("Choose");
		internApply = new JButton("Apply for an Intership");
		internApply.setBounds(100,70,210,30);
		internApply.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
            	ApplyForInternship c = new ApplyForInternship();
            	f.dispose();
            }
        });
		
		reviewIntern = new JButton ("Fill Internship Evaluation Form");
		reviewIntern.setBounds(100,140,210,30);
		reviewIntern.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
                FillForm fill = new FillForm();
            	f.dispose();
            }
        });
		
		f.add(internApply);
		f.add(reviewIntern);
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
