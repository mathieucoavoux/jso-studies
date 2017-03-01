package fr.comprehensiveit.java.security.runtime;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ScriptLauncherError {
	public static void launcherFailed() throws IOException, InterruptedException   {
		String[] cmdScript = new String[]{"/bin/bash", "/tmp/myscript.sh" }; 
		Process procScript = Runtime.getRuntime().exec(cmdScript);
		procScript.waitFor();
		//Runtime myRunTime = Runtime.getRuntime();
		//myRunTime.exec("echo hello > /tmp/hello.log");
		/*
		Class<?> myRunTimeClass = Class.forName("Runtime");
		Object myRuntimeInstance = myRunTimeClass.newInstance();
		Method myMethod = myRunTimeClass.getMethod("exec");
		Object output = myMethod.invoke(myRuntimeInstance);
		Class<?> paramTypes = myMethod.getReturnType();
		*/
		
	}
	public static void main(String[] args) throws IOException, InterruptedException   {
		
		launcherFailed();
		
		
	}
}
