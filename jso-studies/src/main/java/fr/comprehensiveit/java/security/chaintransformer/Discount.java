package fr.comprehensiveit.java.security.chaintransformer;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;

public class Discount {
	
	public Double twoDiscounts(Double price, final Double firstDiscount, final Double secondDiscount) {
		Transformer substract1 = new Transformer( ) {
		    public Object transform(Object input) {
		                Double number = (Double) input;
		         return( number * firstDiscount );
		        }
		};
		Transformer substract2 = new Transformer( ) {
		    public Object transform(Object input) {
		                Double number = (Double) input;
		         return( number * secondDiscount  );
		        }
		};
		Transformer[] chainElements = new Transformer[] { substract1, substract2 };
		Transformer chain = new ChainedTransformer( chainElements );

		Double result = (Double) chain.transform( price );
		
		return result;
	}
	
}
