package screens;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApplyForInternshipTest {
	private ApplyForInternship apply = new ApplyForInternship();


	@Test
	public final void testApplyForInternship() {
		try {
			ApplyForInternship testing = new ApplyForInternship();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("ApplyForInternship constructor failed.");
			fail();
		}
		return;
		
	}

	@Test
	public final void testCompanyScreen() {
		try {
			apply.CompanyScreen();
			return;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("ApplyForInternship company screen failed.");
			fail();
		}
		return;
	}

	@Test
	public final void testStudentInfo() {
		try {
			apply.StudentInfo();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("ApplyForInternship student info failed.");
			fail();
		}
		return;
	}

	@Test
	public final void testSendFromGMail() throws ClassNotFoundException, SQLException {
		try {
			apply.sendFromGMail("ipek.tekin.95@hotmail.com", "Test mail", "This is a test mail.");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("ApplyForInternship send mail failed.");
			fail();
		}
		return;
		

	}

}
