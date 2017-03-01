package fr.comprehensiveit.java.security.chaintransformer;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;

public class ClassChecker {
	public String classLoaderSecurity(String clazz) {
		
		Transformer checkClassRequest = new Transformer() {
			public Object transform(Object input) {
				String clazz = (String) input;
				switch(clazz) {
					case "Hello" : return HelloWorld.class;
					case "Bye" : return Bye.class;
					default: return new Class[0];
				}
			}
		};
		
		final Transformer[] chainElements = new Transformer[] {
				checkClassRequest,
				new InvokerTransformer("newInstance",new Class[0],new Object[0]),
				new InvokerTransformer("printMessage",new Class[]{String.class}, new Object[]{"John"})
				};
				
		Transformer chain = new ChainedTransformer( chainElements );
		
		String resultOutput = (String) chain.transform(clazz);
		
		return resultOutput;
		
	}
	
}
