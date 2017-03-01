package fr.comprehensiveit.java.security.invocation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SimpleInvoker {
	public Map<String,Object> executeSimpleMethod(String className,String methodName) {
		Map<String, Object> arrObject = new HashMap<String,Object>();
		try {
			Class<?> myClass = Class.forName(className);
			Object myClassInstance =  myClass.newInstance();
			Method myMethod = myClass.getMethod(methodName);
			Object output = myMethod.invoke(myClassInstance);
			Class<?> paramTypes = myMethod.getReturnType();
			arrObject.put("code", "OK");
			arrObject.put("paramType", paramTypes);
			arrObject.put("value", output);
			Method[] arrMethods = myClass.getDeclaredMethods();
			for(Integer indMeth=0;indMeth<arrMethods.length;indMeth++) {
				System.out.println("Method name :"+arrMethods[indMeth].getName());
			}
			Method myNewMeth = myClass.getMethod("printNewWorld");
			String name = "Maelie";
			String helloNew = (String) myNewMeth.invoke(name);
			System.out.println(helloNew);
			Method methBye = myClass.getMethod("goodBye",Locale.class);
			String goodBye = (String) methBye.invoke(myClassInstance,new Locale("hello"));
			System.out.println(goodBye);
		}catch (ClassNotFoundException notFoundEx) {
			System.out.println("La classe n'a pas ete trouvee");
			arrObject.put("code", "KO");
		}catch (Exception e) {
			System.out.println("Erreur non connue");
			e.printStackTrace();
			e.getCause();
			arrObject.put("code", "KO");
		}
		return arrObject;	
		
	}
}
