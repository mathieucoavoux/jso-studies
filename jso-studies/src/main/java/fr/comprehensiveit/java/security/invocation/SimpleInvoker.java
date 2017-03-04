package fr.comprehensiveit.java.security.invocation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SimpleInvoker {
	public Map<String,Object> executeSimpleMethod(String className,String methodName) {
		Map<String, Object> arrObject = new HashMap<String,Object>();
		try {
			//Retourne la classe demandée
			Class<?> myClass = Class.forName(className);
			//Instancie la classe
			Object myClassInstance =  myClass.newInstance();
			//Retourne la méthode demandée sans paramètre
			Method myMethod = myClass.getMethod(methodName);
			Object output = myMethod.invoke(myClassInstance);
			Class<?> paramTypes = myMethod.getReturnType();
			arrObject.put("code", "OK");
			arrObject.put("paramType", paramTypes);
			arrObject.put("value", output);
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
	
	public Map<String,Object> executeMethodWithArgs(String className, String methodName, Object[] args, Class[] argsType) {
		Map<String, Object> arrObject = new HashMap<String,Object>();
		try {
			//Retourne la classe demandée
			Class<?> myClass = Class.forName(className);
			//Instancie la classe
			Object myClassInstance =  myClass.newInstance();
			//Retourne la méthode demandée qui contient la liste des arguments
			Method myNewMeth = myClass.getMethod(methodName,argsType);
			//Retourne le résultat de la méthode avec les arguments
			Object helloNew = myNewMeth.invoke(myClassInstance,args);
			Class<?> paramTypes = myNewMeth.getReturnType();
			arrObject.put("code", "OK");
			arrObject.put("paramType", paramTypes);
			arrObject.put("value", helloNew);
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
