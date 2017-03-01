package fr.comprehensiveit.java.security.chaintransformer;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.comprehensiveit.java.security.chaintransformer.ClassChecker;

public class ClassCheckerTest {
	
	@Test
	public void testClassLoaderSecurity() {
		String greetings = "Hello";
		ClassChecker clck = new ClassChecker();
		String resultOutput = clck.classLoaderSecurity(greetings);
		System.out.println("Output :"+resultOutput);
	}
}
