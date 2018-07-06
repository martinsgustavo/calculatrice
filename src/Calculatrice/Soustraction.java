package Calculatrice;

public class Soustraction implements Expression {
	
	Expression operandeA;
	Expression operandeB;
	
	public Soustraction(Expression operandeA, Expression operandeB) {
		super();
		this.operandeA = operandeA;
		this.operandeB = operandeB;
	}
	@Override
	public double evaluer() {
		return operandeA.evaluer() - operandeB.evaluer();
	}
	@Override
	public String toInfix() {
		return "(" + operandeA.toInfix() + " - " + operandeB.toInfix() + ")";
	}
	@Override
	public String toPolonaise() {
		return operandeA.toPolonaise() + " " + operandeB.toPolonaise() + " -";
	}
}
