package fr.comprehensiveit.java.security.invocation;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import fr.comprehensiveit.java.security.invocation.SimpleInvoker;

public class SimpleInvokerTest {
	@Test
	public void testExecuteSimpleMethod() {
		SimpleInvoker simpleInstance = new SimpleInvoker();
		Map<String,Object> mapSimpleMethod = simpleInstance.executeSimpleMethod("fr.comprehensiveit.java.security.invocation.HelloWorld", "printHelloWorld");
		if(mapSimpleMethod.get("code") == "OK") {
			if(mapSimpleMethod.get("paramType") == String.class ) {
				org.junit.Assert.assertTrue("Le resultat :"+mapSimpleMethod.get("value"), mapSimpleMethod.get("paramType") == String.class);
			}else{
				fail("Can not print the value as the type is not printable"+mapSimpleMethod.get("paramType"));
			}
		}else{
			fail("The method return a KO code");
		}
	}
}
