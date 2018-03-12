package screens;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FillFormTest {
	private FillForm f = new FillForm();
	

	@Test
	public final void testFillForm() throws Exception {
		try {
			FillForm ftest = new FillForm();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("FillForm constructor failed.");
			fail();
		}
		return;
	}

	@Test
	public final void testStudentSection() {
		try {
			f.StudentSection();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Student Section failed.");
			fail();
		}
		return;
	}

	@Test
	public final void testInstitutionSection() {
		try {
			f.InstitutionSection();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Institution section failed.");
			fail();
		}
		return;
	}

	@Test
	public final void testEvaluationSectionOne() {
		try {
			f.EvaluationSectionOne();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Evaluation section one failed.");
			fail();
		}
		return;
	}

	@Test
	public final void testEvaluationSectionTwo() {
		try {
			f.EvaluationSectionTwo();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Evaluation section two failed.");
			fail();
		}
		return;
	}

	@Test
	public final void testEvaluationSectionThree() {
		try {
			f.EvaluationSectionThree();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Evaluation section three failed.");
			fail();
		}
		return;
	}

}
