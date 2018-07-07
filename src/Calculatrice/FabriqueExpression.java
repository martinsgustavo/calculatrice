package Calculatrice;

import java.util.EmptyStackException;
import java.util.Stack;

public class FabriqueExpression {
	
	public Expression batirFromPolonaise(String expression) throws EmptyStackException {
		char[] arrExpression = expression.toCharArray();
		Stack<Expression> chiffres = new Stack<>();
		
		for (int i = 0; i < arrExpression.length; i++) {
			
			if(arrExpression[i]==' ')
				continue;
			
			if(Character.isDigit(arrExpression[i])) {
				StringBuilder sBuilder = new StringBuilder();
				
				while(i < arrExpression.length && (Character.isDigit(arrExpression[i]) || arrExpression[i] == '.'))
					sBuilder.append(arrExpression[i++]);
				
				double chiffre = Double.parseDouble(sBuilder.toString());
				chiffres.push(new Scalaire(chiffre));
			}
			
			if(arrExpression[i] == '+' || arrExpression[i] == '-' || arrExpression[i] == '*' || arrExpression[i] == '/')
				chiffres.push(faireCalcul(chiffres.pop(), chiffres.pop(), arrExpression[i]));
			
		}
		
		return chiffres.pop();
	}

	public Expression batirFromToInfix(String expression) throws EmptyStackException {
		char[] arrExpression = expression.toCharArray();
		
		Stack<Expression> chiffres = new Stack<Expression>();
		Stack<Character> oper = new Stack<Character>();
		
		for (int i = 0; i < arrExpression.length; i++) {
			
			if(arrExpression[i]==' ')
				continue;
			
			if(Character.isDigit(arrExpression[i])) {
				StringBuilder sBuilder = new StringBuilder();
				
				while(i < arrExpression.length && (Character.isDigit(arrExpression[i]) || arrExpression[i] == '.'))
					sBuilder.append(arrExpression[i++]);
				
				double chiffre = Double.parseDouble(sBuilder.toString());
				chiffres.push(new Scalaire(chiffre));
			} 
			
			if (arrExpression[i] == '(') {
				oper.push(arrExpression[i]);
			
			} 
			
			if (arrExpression[i] == ')') {
				while (oper.peek() != '(')
					chiffres.push(faireCalcul(chiffres.pop(), chiffres.pop(), oper.pop()));
				oper.pop();
			
			} 
			
			if (arrExpression[i] == '+' || arrExpression[i] == '-' || arrExpression[i] == '*' || arrExpression[i] == '/') {
				while (!oper.empty() && calculAFaire(arrExpression[i], oper.peek()))
					chiffres.push(faireCalcul(chiffres.pop(), chiffres.pop(), oper.pop()));
				oper.push(arrExpression[i]);
			}
		}
		
		while (!oper.empty())
			chiffres.push(faireCalcul(chiffres.pop(), chiffres.pop(), oper.pop()));
		
		return chiffres.pop();
	}
	
	public Expression faireCalcul(Expression n2, Expression n1, char oper) {
		switch (oper) {
		case '+':
			Expression addition = new Addition(n1, n2);
			return addition;
		
		case '-':
			Expression soustration = new Soustraction(n1, n2);
			return soustration;
			
		case '*':
			Expression multiplication = new Multiplication(n1, n2);
			return multiplication;
			
		case '/':
			if(n2.evaluer() == 0) {
				throw new UnsupportedOperationException("Pas possible de divisé par 0.");
			}
			Expression division = new Division(n1, n2);
			return division;
		}
		
		return new Scalaire(0.0);
	}
	
	public boolean calculAFaire (char a, char b) {
		if (b == '(' || b == ')')
			return false;
		if ((a == '*' || a == '/') && (b == '+' || b == '-'))
			return false;
		else
			return true; 
	}

}
	
