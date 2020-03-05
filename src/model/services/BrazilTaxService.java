package model.services;

public class BrazilTaxService implements TaxService {

	public double tax(double amount) {
		//amount ate 100 é 20% e maior é 15%;
		return (amount <= 100.0) ? (amount * 0.2) : (amount * 0.15);
	}
}
