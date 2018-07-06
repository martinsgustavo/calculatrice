package Calculatrice;

public class Division implements Expression {

	Expression operandeA;
	Expression operandeB;
	
	public Division(Expression operandeA, Expression operandeB) {
		this.operandeA = operandeA;
		this.operandeB = operandeB;
	}

	@Override
	public double evaluer() {
		return operandeA.evaluer() / operandeB.evaluer();
	}

	@Override
	public String toInfix() {
		return "(" + operandeA.toInfix() + " / " + operandeB.toInfix() + ")";
	}

	@Override
	public String toPolonaise() {
		return operandeA.toPolonaise() + " " + operandeB.toPolonaise() + " /";
	}

}
