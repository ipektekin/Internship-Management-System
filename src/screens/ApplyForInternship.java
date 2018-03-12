package screens;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;

public class ApplyForInternship {
	
	private JButton b;
	private ButtonGroup buttonGroup1;
	private JTextField tname;
	private JTextField tsurname;
	private JTextField temail;
	private JButton send;
	private JLabel lbStudent[] =new JLabel[7];
	private JCheckBox checkbox[] = new JCheckBox[4];
	private JButton attach;
	private JTextField tattach;
	private JButton attach2;
	private JTextField tattach2;
	private String compEmail = "ipek.tekin.95@hotmail.com";
	private String mailSubject = "INTERN";
	private String mailBody;
	
	private JFileChooser chooser1= new JFileChooser ();
	private File file1;
	private String filename1;
	
	private JFileChooser chooser2;
	private File file2;
	private String filename2;
	
	private JDateChooser dateChooser1;
	private JDateChooser dateChooser2;
	
	public ApplyForInternship() {
		CompanyScreen();
	}
	
	public void CompanyScreen() {
		JFrame f= new JFrame("Companies");
		
		
		lbStudent[0] = new JLabel("Choose the company you would like to apply");
		lbStudent[0].setBounds(10, 20, 300, 20);
		f.add(lbStudent[0]);
		
		checkbox[0] = new JCheckBox("Vestel");
		checkbox[1] = new JCheckBox("Doðuþ Tekno");
		checkbox[2] = new JCheckBox("HugoBoss");
		checkbox[3] = new JCheckBox("Petkim");
		
		checkbox[0].setBounds(10, 50, 100, 15);
		checkbox[1].setBounds(10, 75, 100, 15);
		checkbox[2].setBounds(10, 100, 100, 15);
		checkbox[3].setBounds(10, 125, 100, 15);
		
		checkbox[0].doClick();
		
		f.add(checkbox[0]); 	f.add(checkbox[1]);  f.add(checkbox[2]);  f.add(checkbox[3]);
		
        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(checkbox[0]);
        buttonGroup1.add(checkbox[1]);
        buttonGroup1.add(checkbox[2]);
        buttonGroup1.add(checkbox[3]);
        
        b = new JButton("Continue");
        b.setBounds(10, 150, 100, 20);
        b.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
            	//student info can be made parametrized to take the chosen company
                if( getSelectedButtonText(buttonGroup1)!=null) {
                	StudentInfo();
            		f.dispose();
                }
            }
        });
        f.add(b);
        
        f.setLayout(null);
        f.setSize(400, 300);
        f.setVisible(true);
		f.setLocationRelativeTo(null); 

        f.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		            StudentWindow d = new StudentWindow();
		            f.dispose();
		    }
		});
		
	}
	
	
	public void StudentInfo() {
		JFrame f = new JFrame("Enter your Information");
		
		lbStudent[1] = new JLabel("Name");
		lbStudent[1].setBounds(10, 20, 100, 15);
		f.add(lbStudent[1]);
		
		lbStudent[2] = new JLabel("Surname");
		lbStudent[2].setBounds(10, 40, 100, 15);
		f.add(lbStudent[2]);
		
		lbStudent[3] = new JLabel("E-mail");
		lbStudent[3].setBounds(10, 60, 100, 15);
		f.add(lbStudent[3]);
		
		lbStudent[4] = new JLabel("Begining Date");
		lbStudent[4].setBounds(10, 80, 100, 15);
		f.add(lbStudent[4]);
		
		JLabel lbDate = new JLabel ("End Date");
		lbDate.setBounds(10, 100, 100, 15);
		f.add(lbDate);
		
		lbStudent[5] = new JLabel("CV");
		lbStudent[5].setBounds(10, 120, 100, 15);
		f.add(lbStudent[5]);
		
		attach = new JButton("Attach");
		attach.setBounds(200, 120, 100, 15);
		attach.addActionListener(new ActionListener(){

			public void actionPerformed(java.awt.event.ActionEvent evt) {
			   
				 chooser1= new JFileChooser ();
				 chooser1.showOpenDialog(null);
				 file1=chooser1.getSelectedFile();
				 filename1 = file1.getAbsolutePath();
				 tattach.setText(filename1);
	
			
		}});
		
		attach2 = new JButton("Attach");
		attach2.setBounds(200, 140, 100, 15);
		attach2.addActionListener(new ActionListener(){

			public void actionPerformed(java.awt.event.ActionEvent evt) {
			   
				 chooser2= new JFileChooser ();
				 chooser2.showOpenDialog(null);
				 file2=chooser2.getSelectedFile();
				 filename2 = file2.getAbsolutePath();
				 tattach2.setText(filename2);
	
			
		}});
		
		lbStudent[6] = new JLabel("Transcript");
		lbStudent[6].setBounds(10, 140, 100, 15);
		f.add(lbStudent[6]);
		
		tname = new JTextField();
		tname.setBounds(120, 20, 100, 15);
		
		tsurname = new JTextField();
		tsurname.setBounds(120, 40, 100, 15);
		
		temail = new JTextField();
		temail.setBounds(120, 60, 100, 15);
		
		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(120,80,150,15);
		f.getContentPane().add(dateChooser1);
		
		dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(120,100,150,15);
		f.getContentPane().add(dateChooser2);
		
		tattach = new JTextField();
		tattach.setBounds(120,120,100,15);
		
		tattach2 = new JTextField();
		tattach2.setBounds(120,140,100,15);
		
		send = new JButton("SEND");
		send.setBounds(10, 160, 100, 20);
		send.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
                try {
                	if(dayCalculator(dateChooser1.getDate(),dateChooser2.getDate())) {
                		mailBody = "A student has applied for internship, CV and additional document is attached. Students desired internship time is the days between "+new SimpleDateFormat("dd-MM-yyyy").format(dateChooser1.getDate()) + " - "+new SimpleDateFormat("dd-MM-yyyy").format(dateChooser2.getDate())+"." ;
                		sendFromGMail(compEmail,mailSubject,mailBody);
                		sendApplication();
                		f.dispose();
                		StudentWindow s = new StudentWindow();
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
		
		f.add(tname); f.add(tsurname); f.add(temail); f.add(send);  
		f.add(tattach); f.add(attach); f.add(tattach2); f.add(attach2);
		f.setLayout(null);
		f.setSize(400, 300);
		f.setVisible(true);
		f.setLocationRelativeTo(null); 
		
		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	CompanyScreen();
		        f.dispose();
		    }
		});
	}
	
	public boolean dayCalculator(Date begin, Date end) {
		long difference = end.getTime() - begin.getTime();
		float days= (difference/(1000*60*60*24));
		if(days>=0 && days<30) {
			System.out.println("Internship must be at least 30 days");
			return false;
		}
		else if(days<0) {
			System.out.println("Choose correct dates");
			return false;
		}
		else 
			return true;
	}
	
	public void sendApplication() throws SQLException, ClassNotFoundException{
	 	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","");
    	
    	PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `applyinternship`(Company,Name,Surname,Email) VALUE (?,?,?,?)");
		
    	pstmt.setString(1, getSelectedButtonText(buttonGroup1) );
    	pstmt.setString(2, tname.getText());
    	pstmt.setString(3, tsurname.getText());
    	pstmt.setString(4, temail.getText());
    	pstmt.executeUpdate();
    }
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
	public void sendFromGMail(String to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust","smtp.gmail.com" );
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
            
            Multipart multipart = new MimeMultipart();
            
            BodyPart BodyPart1 = new MimeBodyPart();  
            BodyPart1.setText(body);  
            multipart.addBodyPart(BodyPart1);
            if(file1!=null) {
            	MimeBodyPart BodyPart2 = new MimeBodyPart();
            
            	String filepath = chooser1.getSelectedFile().getAbsolutePath();
            	String filenam = filename1;
            	DataSource source = new FileDataSource(filepath);  
            	BodyPart2.setDataHandler(new DataHandler(source));  
            	BodyPart2.setFileName(filenam);  
            	multipart.addBodyPart(BodyPart2);
            }
            if(file2!=null) {
            	MimeBodyPart BodyPart3 = new MimeBodyPart();
            
            	String filepat = chooser2.getSelectedFile().getAbsolutePath();
            	String filenam1 = filename2;
            	DataSource sourc = new FileDataSource(filepat);  
            	BodyPart3.setDataHandler(new DataHandler(sourc));  
            	BodyPart3.setFileName(filenam1);  
            	multipart.addBodyPart(BodyPart3);
            }
            
            message.setContent(multipart);
          
            Transport transport = session.getTransport("smtp");
            transport.connect(host, "hamzaipek35", "hamzaipek35");
            System.out.print("Sending mail");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Mail sent");
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
	}
	
}
