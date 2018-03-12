package screens;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginDialogTest {
	private LoginDialog ldtest = new LoginDialog();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testMain() {
		try {
			LoginDialog ldmaintest = new LoginDialog();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("LoginDialog main failed.");
			fail();
		}
		return;
	}

	@Test
	public final void testCreateLogin() {
		try {
			ldtest.createLogin();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Create Login failed.");
			fail();
		}
		return;
	}

	@Test
	public final void testCheckLoginDetailsTrue() {
		try {
			assertTrue(LoginDialog.checkLoginDetails("student", "test"));
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Login failed.");
			fail();
		}
		return;
	}
	
	public final void testCheckLoginDetailsFalse() {
		try {
			assertFalse(LoginDialog.checkLoginDetails("dummy", "password"));
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("LoginDialog main failed.");
			fail();
		}
		return;
	}
	
}
