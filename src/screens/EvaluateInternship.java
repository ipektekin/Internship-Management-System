package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;

public class EvaluateInternship {

	JFrame f = new JFrame();
	
	
	public EvaluateInternship() {
		
		IDEnter();
	}
	
	
	private JButton btnNext[] = new JButton[8];
	private JLabel question[] = new JLabel[19];
	private JLabel lbInfo[] = new JLabel[9];
	private JLabel lbInsInfo[]= new JLabel[10];
	private JLabel lbAnswers[] = new JLabel[37];
	private JTextField tfID = new JTextField();
	private String mailSubject = "About your internship evaluation";
	private String mailSuccess = "Your internship evaluation has been accepted!";
	private String mailFail = "Your internship evaluation has been denied. Please contact your professor and refill your form.";
	private String begindate;
	private String enddate;
	
	public void IDEnter() {
		JFrame f = new JFrame("Enter ID");
		
		tfID.setBounds(150, 100, 100, 30);
		f.add(tfID);
		
		btnNext[7]= new JButton("Get Form");
		btnNext[7].setBounds(150, 200, 100, 30);
		btnNext[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						if(SearchID()) {
							StudentSection();
							f.dispose();
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
		f.add(btnNext[7]);
		
		
		f.setSize(400, 300);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null); 

		
		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		           	AcaWindow aca = new AcaWindow();
		            f.dispose();
		    }
		});
	}
	
	public boolean SearchID() throws SQLException, ClassNotFoundException {
		
		boolean flag = false;
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","");
    	
    	Statement stmt = conn.createStatement();
    	
		ResultSet rs = stmt.executeQuery("Select * from evaluationform");
		
		
		while(rs.next()) {
			if(!rs.getBoolean(38)) {
				
				if(rs.getString(1).equals(tfID.getText())) {
					if(rs.getString(1).equals(tfID.getText())) {
						int a=1;
						for(int i=0;i<37;i++,a++) {
							lbAnswers[i] = new JLabel(rs.getString(a));
						
						}
						begindate = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(39));
						enddate = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(40));
						flag = true;
					}
				}
				else
					System.out.println("Wrong ID");
			}
			else 
				System.out.println("That form is already evaluated.");
			
				
		}
		if(flag==true)
			return true;
		else
			return false;
    	
	}
	
	public void DeleteOnReject() throws SQLException, ClassNotFoundException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","");
    	
    	Statement stmt = conn.createStatement();
    	
		stmt.executeUpdate("DELETE FROM evaluationform WHERE id = '"+tfID.getText()+"'");
		
	}
	
	public void StudentSection() {
		JFrame f = new JFrame("Student Info");
		
		f.setSize(400, 300);
		f.setLayout(null);
		f.setVisible(true);
		
		lbInfo[0] = new JLabel("ID :");
		lbInfo[0].setBounds(10, 5, 100, 30);
		f.add(lbInfo[0]);
		
		lbAnswers[0].setBounds(160, 5, 150, 30);
		f.add(lbAnswers[0]);
		
		lbInfo[1] = new JLabel("Name :");
		lbInfo[1].setBounds(10, 45, 100, 30);
		f.add(lbInfo[1]);
		
		lbAnswers[1].setBounds(160, 45, 150, 30);
		f.add(lbAnswers[1]);
		
		lbInfo[2] = new JLabel("Surname :");
		lbInfo[2].setBounds(10, 85, 150, 30);
		f.add(lbInfo[2]);
		
		lbAnswers[2].setBounds(160, 85, 150, 30);
		f.add(lbAnswers[2]);
		
		lbInfo[3] = new JLabel("Faculty :");
		lbInfo[3].setBounds(10, 125, 100, 30);
		f.add(lbInfo[3]);
		
		lbAnswers[3].setBounds(160, 125, 150, 30);
		f.add(lbAnswers[3]);
		
		lbInfo[4] = new JLabel("Department :");
		lbInfo[4].setBounds(10, 165, 100, 30);
		f.add(lbInfo[4]);
		
		lbAnswers[4].setBounds(160, 165, 150, 30);
		f.add(lbAnswers[4]);
		
		lbInfo[5] = new JLabel("Type of Internship :");
		lbInfo[5].setBounds(10, 205, 150, 30);
		f.add(lbInfo[5]);
		System.out.print(lbAnswers[8].getText());
		
		lbAnswers[5].setBounds(160, 205, 150, 30);
		f.add(lbAnswers[5]);
		
		lbInfo[6] = new JLabel("Contact Address :");
		lbInfo[6].setBounds(10, 245, 150, 30);
		f.add(lbInfo[6]);
		
		lbAnswers[6].setBounds(160, 245, 150, 30);
		f.add(lbAnswers[6]);
		
		lbInfo[7] = new JLabel("GSM :");
		lbInfo[7].setBounds(10, 285, 100, 30);
		f.add(lbInfo[7]);
		
		lbAnswers[7].setBounds(160, 285, 150, 30);
		f.add(lbAnswers[7]);
		
		lbInfo[8] = new JLabel("E-mail :");
		lbInfo[8].setBounds(10, 325, 100, 30);
		f.add(lbInfo[8]);
		
		lbAnswers[8].setBounds(160, 325, 150, 30);
		f.add(lbAnswers[8]);
		
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
		           	IDEnter();
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
		
		lbAnswers[9].setBounds(160, 5, 150, 30);
		f.add(lbAnswers[9]);
		
		lbInsInfo[1] = new JLabel("Department :");
		lbInsInfo[1].setBounds(10, 45, 150, 30);
		f.add(lbInsInfo[1]);
			
		lbAnswers[10].setBounds(160, 45, 150, 30);
		f.add(lbAnswers[10]);
		
		lbInsInfo[2] = new JLabel("Address :");
		lbInsInfo[2].setBounds(10, 85, 150, 30);
		f.add(lbInsInfo[2]);
			
		lbAnswers[11].setBounds(160, 85, 150, 30);
		f.add(lbAnswers[11]);
		
		lbInsInfo[3] = new JLabel("Phone :");
		lbInsInfo[3].setBounds(10, 125, 150, 30);
		f.add(lbInsInfo[3]);
			
		lbAnswers[12].setBounds(160, 125, 150, 30);
		f.add(lbAnswers[12]);
		
		lbInsInfo[4] = new JLabel("Fax :");
		lbInsInfo[4].setBounds(10, 165, 150, 30);
		f.add(lbInsInfo[4]);
			
		lbAnswers[13].setBounds(160, 165, 150, 30);
		f.add(lbAnswers[13]);
		
		lbInsInfo[5] = new JLabel("E-mail :");
		lbInsInfo[5].setBounds(10, 205, 150, 30);
		f.add(lbInsInfo[5]);
			
		lbAnswers[14].setBounds(160, 205, 150, 30);
		f.add(lbAnswers[14]);
		
		lbInsInfo[6] = new JLabel("Supervisor :");
		lbInsInfo[6].setBounds(10, 245, 150, 30);
		f.add(lbInsInfo[6]);
			
		lbAnswers[15].setBounds(160, 245, 150, 30);
		f.add(lbAnswers[15]);
		
		lbInsInfo[7] = new JLabel("HR Manager");
		lbInsInfo[7].setBounds(10, 285, 150, 30);
		f.add(lbInsInfo[7]);
			
		lbAnswers[16].setBounds(160, 285, 150, 30);
		f.add(lbAnswers[16]);
		
		lbInsInfo[8] = new JLabel("Beginning date");
		lbInsInfo[8].setBounds(10, 325, 150, 30);
		f.add(lbInsInfo[8]);
		
		JLabel lbBegindate = new JLabel(begindate);
		lbBegindate.setBounds(160, 325, 150, 30);
		f.add(lbBegindate);
		
		lbInsInfo[9] = new JLabel("Completion date");
		lbInsInfo[9].setBounds(10, 365, 150, 30);
		f.add(lbInsInfo[9]);
		
		JLabel lbEnddate = new JLabel(enddate);
		lbEnddate.setBounds(160, 365, 150, 30);
		f.add(lbEnddate);
			
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
		
		question[0] = new JLabel("<html>Was any salary paid? If yes how much was paid?</html>");
		question[0].setBounds(10,5,300,45);
		f.add(question[0]);
		
		lbAnswers[17].setBounds(400,10,100,30);
		f.add(lbAnswers[17]);
		
		question[1] = new JLabel("Was there any transportation opportunity?");
		question[1].setBounds(10,55,300,60);
		f.add(question[1]);
		
		lbAnswers[18].setBounds(400,60,150,30);
		f.add(lbAnswers[18]);
		
		
		question[2] = new JLabel("Was any meal opportunity provided?");
		question[2].setBounds(10,105,300,60);
		f.add(question[2]);

		lbAnswers[19].setBounds(400,110,150,30);
		f.add(lbAnswers[19]);
		
		
		question[3] = new JLabel("<html>Were you able to practice the theoretical knowledge you got through your university life during your internship?</html>");
		question[3].setBounds(10,155,300,60);
		f.add(question[3]);
		
		lbAnswers[20].setBounds(400,160,150,30);
		f.add(lbAnswers[20]);
		
		
		question[4] = new JLabel("<html>Were you able to use your foreign languages during the internship period?</html>");
		question[4].setBounds(10,205,300,60);
		f.add(question[4]);
		
		lbAnswers[21].setBounds(400,210,150,30);
		f.add(lbAnswers[21]);
		
		question[5] = new JLabel("<html>Did your foreign language level help you carry out your responsibilities?</html>");
		question[5].setBounds(10,255,300,60);
		f.add(question[5]);
		
		lbAnswers[22].setBounds(400,260,150,30);
		f.add(lbAnswers[22]);
		
		question[6] = new JLabel("<html>Were you provided with an individual working place?</html>");
		question[6].setBounds(10,305,300,60);
		f.add(question[6]);
		
		lbAnswers[23].setBounds(400,310,150,30);
		f.add(lbAnswers[23]);
		
		question[7] = new JLabel("<html>Would you suggest the institution you did your internship to your friends?</html>");
		question[7].setBounds(10,355,300,60);
		f.add(question[7]);
		
		lbAnswers[24].setBounds(400,360,150,30);
		f.add(lbAnswers[24]);
		
		question[8] = new JLabel("<html>Would you want to work at this institution after your graduation?</html>");
		question[8].setBounds(10,405,300,60);
		f.add(question[8]);

		lbAnswers[25].setBounds(400,410,150,30);
		f.add(lbAnswers[25]);
		
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
		
		lbAnswers[26].setBounds(400,10,150,30);
		f.add(lbAnswers[26]);
		
		question[10] = new JLabel("<html>Doing internship directed me in making decisions about my will at positioning myself in working areas.</html>");
		question[10].setBounds(10,55,300,45);
		f.add(question[10]);
		
		lbAnswers[27].setBounds(400,60,150,30);
		f.add(lbAnswers[27]);
		
		question[11] = new JLabel("<html>The institution at which I did my internship met my expectations.</html>");
		question[11].setBounds(10,105,300,45);
		f.add(question[11]);
		
		lbAnswers[28].setBounds(400,110,150,30);
		f.add(lbAnswers[28]);
		
		question[12] = new JLabel("<html>The institution I did my internship at gives importance to research and development activities.</html>");
		question[12].setBounds(10,155,300,45);
		f.add(question[12]);
		
		lbAnswers[29].setBounds(400,160,150,30);
		f.add(lbAnswers[29]);
		
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
		
		lbAnswers[30].setBounds(470, 10, 300, 50);
		f.add(lbAnswers[30]);
		
		question[14] = new JLabel("<html>What is your reason in choosing the named institution for your internship?</html>");
		question[14].setBounds(10,75,450,55);
		f.add(question[14]);
		
		lbAnswers[31].setBounds(470, 80, 300, 50);
		f.add(lbAnswers[31]);
		
		question[15] = new JLabel("<html>At the institution I performed my internship, I learned to use the analysis methods (optimization techniques, statistical analysis techniques, design etc.) I was thought in the education program </html>");
		question[15].setBounds(10,145,450,45);
		f.add(question[15]);
		
		lbAnswers[32].setBounds(470, 150, 300, 50);
		f.add(lbAnswers[32]);
		
		question[16] = new JLabel("<html>Identify the most positive aspects of the institution you performed your internship at.</html>");
		question[16].setBounds(10,215,450,55);
		f.add(question[16]);
		
		lbAnswers[33].setBounds(470, 220, 300, 50);
		f.add(lbAnswers[33]);
		
		question[17] = new JLabel("<html>Identify the most negative aspects of the institution you performed your internship at.</html>");
		question[17].setBounds(10,285,450,55);
		f.add(question[17]);
		
		lbAnswers[34].setBounds(470, 290, 300, 50);
		f.add(lbAnswers[34]);
		
		question[18] = new JLabel("<html>I was able to associate the courses I took during my education, with the works during the internship process. </html>");
		question[18].setBounds(10, 355, 450, 50);
		f.add(question[18]);
		
		lbAnswers[35].setBounds(470, 360, 142, 45);
		f.add(lbAnswers[35]);
		
		lbAnswers[36].setBounds(628, 360, 145, 45);
		f.add(lbAnswers[36]);
		
		btnNext[5] = new JButton("ACCEPT");
		btnNext[5].setBounds(200, 420, 100, 30);
		btnNext[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	           	try {
	           		@SuppressWarnings("unused")
	           		AcaWindow aca = new AcaWindow();
	           		f.dispose();
	           		sendFromGMail(lbAnswers[8].getText(), mailSubject, mailSuccess);
	           		SetEvaluate();
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
		
		btnNext[5] = new JButton("REJECT");
		btnNext[5].setBounds(400, 420, 100, 30);
		btnNext[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sendFromGMail(lbAnswers[8].getText(), mailSubject, mailFail);
	           		DeleteOnReject();
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
	
	public void sendFromGMail(String to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", "hamzaipek35");
        props.put("mail.smtp.password", "hamzaipek35");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("hamzaipek35"));
            
            /*
             * for sending to multiple addresses
              InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }*/
            
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, "hamzaipek35", "hamzaipek35");
            System.out.print("Sending mail");
            transport.sendMessage(message, message.getAllRecipients());
            System.out.print("Mail sent");
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
	}
	public void SetEvaluate() throws SQLException, ClassNotFoundException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","");
    	
    	Statement stmt = conn.createStatement();
    	
		stmt.executeUpdate("UPDATE `evaluationform` SET `IsEvaluated` = '1' WHERE `evaluationform`.`id` = '"+tfID.getText()+"'");
		
	}

}
