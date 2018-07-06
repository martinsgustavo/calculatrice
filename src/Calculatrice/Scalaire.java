package Calculatrice;

public class Scalaire implements Expression{
	
	double scalaire;

	public Scalaire(double scalaire) {
		this.scalaire = scalaire;
	}

	@Override
	public double evaluer() {
		return scalaire;
	}

	@Override
	public String toInfix() {
		return Double.toString(scalaire);
	}

	@Override
	public String toPolonaise() {
		return Double.toString(scalaire);
	}
}
