package Calculatrice;

import java.util.EmptyStackException;

public class MainActivity {
	
	static String result;
	
	public static void main(String[] args) {
		
		String expression;
		
		try {
			expression = "(2+2)/10";
			
			FabriqueExpression exp = new FabriqueExpression();
			
			System.out.println(exp.batirFromToInfix(expression).evaluer());
			System.out.println(exp.batirFromToInfix(expression).toPolonaise());
			System.out.println(exp.batirFromToInfix(expression).toInfix());
		
		} catch (UnsupportedOperationException e) {
			System.out.println("Pas possible de divisé par 0.");
		} catch (EmptyStackException e) {
			System.out.println("Expression mal formée.");
		}
		
		
		
	}

}
