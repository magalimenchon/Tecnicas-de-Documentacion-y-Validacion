package tudai.junit.test;

/**********************TestsRunner.java **********************************/
import org.junit.runner.JUnitCore;

import tudai.tdyv.junit.test.TestSuite;


public class TestsRunner {

	 public static void main(String args[]) {
	        JUnitCore.runClasses(TestSuite.class);
	    }
	
}