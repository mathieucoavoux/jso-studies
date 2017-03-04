package fr.comprehensiveit.java.security.invocation;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import fr.comprehensiveit.java.security.invocation.SimpleInvoker;

public class SimpleInvokerTest {
	@Test
	public void testExecuteSimpleMethod() {
		
		String className = "fr.comprehensiveit.java.security.invocation.HelloWorld";
		String methodName = "printNewWorld";
		SimpleInvoker simpleInstance = new SimpleInvoker();
		
		//Appel de printHelloWorld sans arguement
		Map<String,Object> mapSimpleMethod = simpleInstance.executeSimpleMethod(className,methodName);
		if(mapSimpleMethod.get("code") == "OK") {
			if(mapSimpleMethod.get("paramType") == String.class ) {
				org.junit.Assert.assertTrue("Le resultat :"+mapSimpleMethod.get("value"), mapSimpleMethod.get("paramType") == String.class);
			}else{
				fail("Impossible d'afficher le résultat comme le type n'est pas affichable"+mapSimpleMethod.get("paramType"));
			}
		}else{
			fail("The method return a KO code");
		}
		//Appel de printHelloWorld avec argument
		Object[] args = new Object[]{ "Maélie" };
		Class[] argsType = new Class[]{ String.class };
		Map<String,Object> mapArgsMethod = simpleInstance.executeMethodWithArgs(className, methodName,args, argsType);
		if(mapArgsMethod.get("code") == "OK") {
			if(mapArgsMethod.get("paramType") == String.class ) {
				org.junit.Assert.assertTrue("Le resultat :"+mapArgsMethod.get("value"), mapArgsMethod.get("paramType") == String.class);
			}else{
				fail("Impossible d'afficher le résultat comme le type n'est pas affichable"+mapArgsMethod.get("paramType"));
			}
		}else{
			fail("The method return a KO code");
		}
	}
}
