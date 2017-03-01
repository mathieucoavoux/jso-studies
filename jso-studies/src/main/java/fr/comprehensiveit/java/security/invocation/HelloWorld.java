package fr.comprehensiveit.java.security.invocation;

import java.util.Locale;

public class HelloWorld {
	public String printHelloWorld() {
		return "Hello World";
	}
	public static String printNewWorld() {
		return "Welcome to this new World ";
	}
	public static String printNewWorld(String name) {
		return "Welcome to this new World "+name;
	}
	
	public String goodBye(Locale l ) {
		return "Bye";
	}
}
