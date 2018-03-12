package screens;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FillForm {
	
	private String[] types = {"office", "company", "factory", "industry"};
	private String[] answers = {"Never", "Little", "Moderately", "Very Much"};
	private String[] yesno = {"Yes", "No"};
	private String[] agreeing = {"No answer","Totally disagree","Partially disagree","Partially agree","Considerably agree","Totally agree"};
	private String s[] = new String[14];
	
	private JButton btnNext[] = new JButton[6];
	private JLabel question[] = new JLabel[19];
	private JTextArea taAnswers[] = new JTextArea[7];
	private JComboBox cbAnswers[] = new JComboBox[14];
	private JLabel lbInfo[] = new JLabel[9];
	private JTextField tfInfo[] = new JTextField[8];
	private JLabel lbInsInfo[]= new JLabel[10];
	private JTextField tfInsInfo[] = new JTextField[8];
	
	private JDateChooser dateChooser;
	private JDateChooser dateChooser1;
	
	public FillForm() {
		StudentSection();
	}
	
	public void StudentSection() {
		JFrame f = new JFrame("Student Info");
		
		f.setSize(400, 300);
		f.setLayout(null);
		f.setVisible(true);
		
		lbInfo[0] = new JLabel("ID :");
		lbInfo[0].setBounds(10, 5, 100, 30);
		f.add(lbInfo[0]);
		
		tfInfo[0] = new JTextField ();
		tfInfo[0].setBounds(160, 5, 150, 30);
		f.add(tfInfo[0]);
		
		lbInfo[1] = new JLabel("Name :");
		lbInfo[1].setBounds(10, 45, 100, 30);
		f.add(lbInfo[1]);
		
		tfInfo[1] = new JTextField ();
		tfInfo[1].setBounds(160, 45, 150, 30);
		f.add(tfInfo[1]);
		
		lbInfo[2] = new JLabel("Surname :");
		lbInfo[2].setBounds(10, 85, 150, 30);
		f.add(lbInfo[2]);
		
		tfInfo[2] = new JTextField ();
		tfInfo[2].setBounds(160, 85, 150, 30);
		f.add(tfInfo[2]);
		
		lbInfo[3] = new JLabel("Faculty :");
		lbInfo[3].setBounds(10, 125, 100, 30);
		f.add(lbInfo[3]);
		
		tfInfo[3] = new JTextField ();
		tfInfo[3].setBounds(160, 125, 150, 30);
		f.add(tfInfo[3]);
		
		lbInfo[4] = new JLabel("Department :");
		lbInfo[4].setBounds(10, 165, 100, 30);
		f.add(lbInfo[4]);
		
		tfInfo[4] = new JTextField ();
		tfInfo[4].setBounds(160, 165, 150, 30);
		f.add(tfInfo[4]);
		
		lbInfo[5] = new JLabel("Type of Internship :");
		lbInfo[5].setBounds(10, 205, 150, 30);
		f.add(lbInfo[5]);
		
		cbAnswers[13] = new JComboBox(types);
		cbAnswers[13].setBounds(160, 205, 150, 30);
		s[13]="office";
		cbAnswers[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[13] = (String)cbAnswers[13].getSelectedItem();
			}
			
		});
		f.add(cbAnswers[13]);
		
		lbInfo[6] = new JLabel("Contact Address :");
		lbInfo[6].setBounds(10, 245, 150, 30);
		f.add(lbInfo[6]);
		
		tfInfo[5] = new JTextField ();
		tfInfo[5].setBounds(160, 245, 150, 30);
		f.add(tfInfo[5]);
		
		lbInfo[7] = new JLabel("GSM :");
		lbInfo[7].setBounds(10, 285, 100, 30);
		f.add(lbInfo[7]);
		
		tfInfo[6] = new JTextField ();
		tfInfo[6].setBounds(160, 285, 150, 30);
		f.add(tfInfo[6]);
		
		lbInfo[8] = new JLabel("E-mail :");
		lbInfo[8].setBounds(10, 325, 100, 30);
		f.add(lbInfo[8]);
		
		tfInfo[7] = new JTextField ();
		tfInfo[7].setBounds(160, 325, 150, 30);
		f.add(tfInfo[7]);
		
		btnNext[0] = new JButton("NEXT");
		btnNext[0].setBounds(100, 400, 100, 30);
		btnNext[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstitutionSection();
				f.dispose();
			}
		});
		f.add(btnNext[0]);
		
		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		           	StudentWindow stu = new StudentWindow();
		            f.dispose();
		    }
		});
		
		f.setSize(400,500);
        f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null); 

	}
	
	
	
	
	public void InstitutionSection() {
		JFrame f = new JFrame("Instutition Info");
		
		lbInsInfo[0] = new JLabel("Name :");
		lbInsInfo[0].setBounds(10, 5, 150, 30);
		f.add(lbInsInfo[0]);
		
		tfInsInfo[0] = new JTextField();
		tfInsInfo[0].setBounds(160, 5, 150, 30);
		f.add(tfInsInfo[0]);
		
		lbInsInfo[1] = new JLabel("Department :");
		lbInsInfo[1].setBounds(10, 45, 150, 30);
		f.add(lbInsInfo[1]);
			
		tfInsInfo[1] = new JTextField();
		tfInsInfo[1].setBounds(160, 45, 150, 30);
		f.add(tfInsInfo[1]);
		
		lbInsInfo[2] = new JLabel("Address :");
		lbInsInfo[2].setBounds(10, 85, 150, 30);
		f.add(lbInsInfo[2]);
			
		tfInsInfo[2] = new JTextField();
		tfInsInfo[2].setBounds(160, 85, 150, 30);
		f.add(tfInsInfo[2]);
		
		lbInsInfo[3] = new JLabel("Phone :");
		lbInsInfo[3].setBounds(10, 125, 150, 30);
		f.add(lbInsInfo[3]);
			
		tfInsInfo[3] = new JTextField();
		tfInsInfo[3].setBounds(160, 125, 150, 30);
		f.add(tfInsInfo[3]);
		
		lbInsInfo[4] = new JLabel("Fax :");
		lbInsInfo[4].setBounds(10, 165, 150, 30);
		f.add(lbInsInfo[4]);
			
		tfInsInfo[4] = new JTextField();
		tfInsInfo[4].setBounds(160, 165, 150, 30);
		f.add(tfInsInfo[4]);
		
		lbInsInfo[5] = new JLabel("E-mail :");
		lbInsInfo[5].setBounds(10, 205, 150, 30);
		f.add(lbInsInfo[5]);
			
		tfInsInfo[5]= new JTextField();
		tfInsInfo[5].setBounds(160, 205, 150, 30);
		f.add(tfInsInfo[5]);
		
		lbInsInfo[6] = new JLabel("Supervisor :");
		lbInsInfo[6].setBounds(10, 245, 150, 30);
		f.add(lbInsInfo[6]);
			
		tfInsInfo[6] = new JTextField();
		tfInsInfo[6].setBounds(160, 245, 150, 30);
		f.add(tfInsInfo[6] );
		
		lbInsInfo[7] = new JLabel("HR Manager");
		lbInsInfo[7].setBounds(10, 285, 150, 30);
		f.add(lbInsInfo[7]);
			
		tfInsInfo[7] = new JTextField();
		tfInsInfo[7].setBounds(160, 285, 150, 30);
		f.add(tfInsInfo[7]);
		
		lbInsInfo[8] = new JLabel("Beginning date");
		lbInsInfo[8].setBounds(10, 325, 150, 30);
		f.add(lbInsInfo[8]);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(160,325,150,30);
		f.getContentPane().add(dateChooser);
		
		lbInsInfo[9] = new JLabel("Completion date");
		lbInsInfo[9].setBounds(10, 365, 150, 30);
		f.add(lbInsInfo[9]);
		
		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(160,365,150,30);
		f.getContentPane().add(dateChooser1);
			
		btnNext[1] = new JButton("NEXT");
		btnNext[1].setBounds(100, 425, 100, 30);
		btnNext[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvaluationSectionOne();
				f.dispose();
			}
		});
		f.add(btnNext[1]);
		
		f.setSize(400, 500);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null); 
		
		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	StudentSection();
		        f.dispose();
		    }
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void EvaluationSectionOne() {
		JFrame f = new JFrame("Institutional Evaluation");
		
		question[0] = new JLabel("<html>Was any salary paid?</html>");
		question[0].setBounds(10,5,300,45);
		f.add(question[0]);
		
		cbAnswers[0] = new JComboBox(yesno);
		cbAnswers[0].setBounds(400,10,100,30);
		s[0]="no";
		cbAnswers[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[0] = (String)cbAnswers[0].getSelectedItem();
			}
		});
		f.add(cbAnswers[0]);
		
		question[1] = new JLabel("Was there any transportation opportunity?");
		question[1].setBounds(10,55,300,60);
		f.add(question[1]);
		
		cbAnswers[1] = new JComboBox(answers);
		cbAnswers[1].setBounds(400,60,150,30);
		s[1]="Never";
		cbAnswers[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[1] = (String)cbAnswers[1].getSelectedItem();
			}
		});
		f.add(cbAnswers[1]);
		
		
		question[2] = new JLabel("Was any meal opportunity provided?");
		question[2].setBounds(10,105,300,60);
		f.add(question[2]);

		cbAnswers[2] = new JComboBox(answers);
		cbAnswers[2].setBounds(400,110,150,30);
		s[2]="Never";
		cbAnswers[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[2] = (String)cbAnswers[2].getSelectedItem();
			}
		});
		f.add(cbAnswers[2]);
		
		
		question[3] = new JLabel("<html>Were you able to practice the theoretical knowledge you got through your university life during your internship?</html>");
		question[3].setBounds(10,155,300,60);
		f.add(question[3]);
		
		cbAnswers[3] = new JComboBox(answers);
		cbAnswers[3].setBounds(400,160,150,30);
		s[3]="Never";
		cbAnswers[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[3] = (String)cbAnswers[3].getSelectedItem();
			}
		});
		f.add(cbAnswers[3]);
		
		
		question[4] = new JLabel("<html>Were you able to use your foreign languages during the internship period?</html>");
		question[4].setBounds(10,205,300,60);
		f.add(question[4]);
		
		cbAnswers[4] = new JComboBox(answers);
		cbAnswers[4].setBounds(400,210,150,30);
		s[4]="Never";
		cbAnswers[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[4] = (String)cbAnswers[4].getSelectedItem();
			}
		});
		f.add(cbAnswers[4]);
		
		question[5] = new JLabel("<html>Did your foreign language level help you carry out your responsibilities?</html>");
		question[5].setBounds(10,255,300,60);
		f.add(question[5]);
		
		cbAnswers[5] = new JComboBox(answers);
		cbAnswers[5].setBounds(400,260,150,30);
		s[5]="Never";
		cbAnswers[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[5] = (String)cbAnswers[5].getSelectedItem();
			}
		});
		f.add(cbAnswers[5]);
		
		question[6] = new JLabel("<html>Were you provided with an individual working place?</html>");
		question[6].setBounds(10,305,300,60);
		f.add(question[6]);
		
		cbAnswers[6] = new JComboBox(answers);
		cbAnswers[6].setBounds(400,310,150,30);
		s[6]="Never";
		cbAnswers[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[6] = (String)cbAnswers[6].getSelectedItem();
			}
		});
		f.add(cbAnswers[6]);
		
		question[7] = new JLabel("<html>Would you suggest the institution you did your internship to your friends?</html>");
		question[7].setBounds(10,355,300,60);
		f.add(question[7]);
		
		cbAnswers[7] = new JComboBox(answers);
		cbAnswers[7].setBounds(400,360,150,30);
		s[7]="Never";
		cbAnswers[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[7] = (String)cbAnswers[7].getSelectedItem();
			}
		});
		f.add(cbAnswers[7]);
		
		question[8] = new JLabel("<html>Would you want to work at this institution after your graduation?</html>");
		question[8].setBounds(10,405,300,60);
		f.add(question[8]);

		cbAnswers[8] = new JComboBox(answers);
		cbAnswers[8].setBounds(400,410,150,30);
		s[8]="Never";
		cbAnswers[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[8] = (String)cbAnswers[8].getSelectedItem();
			}
		});
		f.add(cbAnswers[8]);
		
		btnNext[2] = new JButton("NEXT");
		btnNext[2].setBounds(200, 460, 100, 30);
		btnNext[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvaluationSectionTwo();
				f.dispose();
			}
		});
		f.add(btnNext[2]);
		
		f.setSize(600, 550);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null); 

		
		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	InstitutionSection();
		        f.dispose();
		    }
		});
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void EvaluationSectionTwo() {
		JFrame f = new JFrame("Continuing Evaluation");
		
		question[9] = new JLabel("<html>Internship process gave me an objective point of view about business life and discipline.</html>");
		question[9].setBounds(10,5,300,45);
		f.add(question[9]);
		
		cbAnswers[9] = new JComboBox(agreeing);
		cbAnswers[9].setBounds(400,10,150,30);
		s[9]="No answer";
		cbAnswers[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[9] = (String)cbAnswers[9].getSelectedItem();
			}
		});
		f.add(cbAnswers[9]);
		
		question[10] = new JLabel("<html>Doing internship directed me in making decisions about my will at positioning myself in working areas.</html>");
		question[10].setBounds(10,55,300,45);
		f.add(question[10]);
		
		cbAnswers[10] = new JComboBox(agreeing);
		cbAnswers[10].setBounds(400,60,150,30);
		s[10]="No answer";
		cbAnswers[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[10] = (String)cbAnswers[10].getSelectedItem();
			}
		});
		f.add(cbAnswers[10]);
		
		question[11] = new JLabel("<html>The institution at which I did my internship met my expectations.</html>");
		question[11].setBounds(10,105,300,45);
		f.add(question[11]);
		
		cbAnswers[11] = new JComboBox(agreeing);
		cbAnswers[11].setBounds(400,110,150,30);
		s[11]="No answer";
		cbAnswers[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[11] = (String)cbAnswers[1].getSelectedItem();
			}
		});
		f.add(cbAnswers[11]);
		
		question[12] = new JLabel("<html>The institution I did my internship at gives importance to research and development activities.</html>");
		question[12].setBounds(10,155,300,45);
		f.add(question[12]);
		
		cbAnswers[12] = new JComboBox(agreeing);
		cbAnswers[12].setBounds(400,160,150,30);
		s[12]="No answer";
		cbAnswers[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s[12] = (String)cbAnswers[12].getSelectedItem();
			}
		});
		f.add(cbAnswers[12]);
		
		btnNext[3] = new JButton("NEXT");
		btnNext[3].setBounds(200, 200, 100, 30);
		btnNext[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvaluationSectionThree();
				f.dispose();
			}
		});
		f.add(btnNext[3]);
		
		f.setSize(600, 325);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null); 

		
		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	EvaluationSectionOne();
		        f.dispose();
		    }
		});
	}
	
	public void EvaluationSectionThree() {
		JFrame f = new JFrame("Continuing Evaluation");
		
		question[13] = new JLabel("<html>Please state your comments and suggestions.</html>");
		question[13].setBounds(10,5,450,55);
		f.add(question[13]);
		
		taAnswers[0] = new JTextArea();
		taAnswers[0].setBounds(470, 10, 300, 50);
		taAnswers[0].setLineWrap(true);
		taAnswers[0].setWrapStyleWord(true);
		f.add(taAnswers[0]);
		
		question[14] = new JLabel("<html>What is your reason in choosing the named institution for your internship?</html>");
		question[14].setBounds(10,75,450,55);
		f.add(question[14]);
		
		taAnswers[1] = new JTextArea();
		taAnswers[1].setBounds(470, 80, 300, 50);
		taAnswers[1].setLineWrap(true);
		taAnswers[1].setWrapStyleWord(true);
		f.add(taAnswers[1]);
		
		question[15] = new JLabel("<html>At the institution I performed my internship, I learned to use the analysis methods (optimization techniques, statistical analysis techniques, design etc.) I was thought in the education program </html>");
		question[15].setBounds(10,145,450,45);
		f.add(question[15]);
		
		taAnswers[2] = new JTextArea();
		taAnswers[2].setBounds(470, 150, 300, 50);
		taAnswers[2].setLineWrap(true);
		taAnswers[2].setWrapStyleWord(true);
		f.add(taAnswers[2]);
		
		question[16] = new JLabel("<html>Identify the most positive aspects of the institution you performed your internship at.</html>");
		question[16].setBounds(10,215,450,55);
		f.add(question[16]);
		
		taAnswers[3] = new JTextArea();
		taAnswers[3].setBounds(470, 220, 300, 50);
		taAnswers[3].setLineWrap(true);
		taAnswers[3].setWrapStyleWord(true);
		f.add(taAnswers[3]);
		
		question[17] = new JLabel("<html>Identify the most negative aspects of the institution you performed your internship at.</html>");
		question[17].setBounds(10,285,450,55);
		f.add(question[17]);
		
		taAnswers[4] = new JTextArea();
		taAnswers[4].setBounds(470, 290, 300, 50);
		taAnswers[4].setLineWrap(true);
		taAnswers[4].setWrapStyleWord(true);

		f.add(taAnswers[4]);
		
		question[18] = new JLabel("<html>I was able to associate the courses I took during my education, with the works during the internship process. </html>");
		question[18].setBounds(10, 355, 450, 50);
		f.add(question[18]);
		
		taAnswers[5] = new JTextArea("Courses :");
		taAnswers[5].setBounds(470, 360, 142, 90);
		taAnswers[5].setLineWrap(true);
		taAnswers[5].setWrapStyleWord(true);

		f.add(taAnswers[5]);
		
		taAnswers[6] = new JTextArea("Works :");
		taAnswers[6].setBounds(628, 360, 145, 90);
		taAnswers[6].setLineWrap(true);
		taAnswers[6].setWrapStyleWord(true);
		f.add(taAnswers[6]);
		
		btnNext[5] = new JButton("FINISH");
		btnNext[5].setBounds(200, 420, 100, 30);
		btnNext[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	           	try {
	           		sendForm();
	           		@SuppressWarnings("unused")
	           		StudentWindow stu = new StudentWindow();
	           		f.dispose();
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
		f.add(btnNext[5]);
		
		f.setSize(850, 500);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null); 

		
		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	EvaluationSectionTwo();
		        f.dispose();
		    }
		});
	}
	
	
	public void sendForm() throws SQLException, ClassNotFoundException{
		
	 	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","");
    	
    	PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `evaluationform`(id,name,surname,faculty,dept,type,addr,gsm,email,insname,insdept,insaddr,insphone,insfax,insemail,inssprvsr,inshrmngr,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19,q20,IsEvaluated,begindate,enddate) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

    	pstmt.setString(1, tfInfo[0].getText());
    	pstmt.setString(2, tfInfo[1].getText());
    	pstmt.setString(3, tfInfo[2].getText());
    	pstmt.setString(4, tfInfo[3].getText());
    	pstmt.setString(5, tfInfo[4].getText());
    	pstmt.setString(6, s[13]);
    	pstmt.setString(7, tfInfo[5].getText());
    	pstmt.setString(8, tfInfo[6].getText());
    	pstmt.setString(9, tfInfo[7].getText());
    	pstmt.setString(10, tfInsInfo[0].getText());
    	pstmt.setString(11, tfInsInfo[1].getText());
    	pstmt.setString(12, tfInsInfo[2].getText());
    	pstmt.setString(13, tfInsInfo[3].getText());
    	pstmt.setString(14, tfInsInfo[4].getText());
    	pstmt.setString(15, tfInsInfo[5].getText());
    	pstmt.setString(16, tfInsInfo[6].getText());
    	pstmt.setString(17, tfInsInfo[7].getText());
    	pstmt.setString(18, s[0]);
    	pstmt.setString(19, s[1]);
    	pstmt.setString(20, s[2]);
    	pstmt.setString(21, s[3]);
    	pstmt.setString(22, s[4]);
    	pstmt.setString(23, s[5]);
    	pstmt.setString(24, s[6]);
    	pstmt.setString(25, s[7]);
    	pstmt.setString(26, s[8]);
    	pstmt.setString(27, s[9]);
    	pstmt.setString(28, s[10]);
    	pstmt.setString(29, s[11]);
    	pstmt.setString(30, s[12]);
    	pstmt.setString(31, taAnswers[0].getText());
    	pstmt.setString(32, taAnswers[1].getText());
    	pstmt.setString(33, taAnswers[2].getText());
    	pstmt.setString(34, taAnswers[3].getText());
    	pstmt.setString(35, taAnswers[4].getText());
    	pstmt.setString(36, taAnswers[5].getText());
    	pstmt.setString(37, taAnswers[6].getText());
    	pstmt.setBoolean(38, false);
    	pstmt.setDate(39, new java.sql.Date(dateChooser.getDate().getTime()));
    	pstmt.setDate(40, new java.sql.Date(dateChooser1.getDate().getTime()));

    	
    	pstmt.executeUpdate();
    }
	
}
