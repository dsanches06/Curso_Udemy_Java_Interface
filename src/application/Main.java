package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Main {

	public static void main(String[] args) throws ParseException {

		/**
		 * 
		 * INTERFACE
		 * 
		 * É um tipo que define um conjunto de operações que uma classe deve
		 * implementar, ou seja, interface estabelece um contrato que a clase deve
		 * cumprir.
		 * 
		 * Sintaxe
		 * 
		 * atraves da palavra reservada "interface"
		 * 
		 * 
		 * interface Shape() { double area(); double perimeter(); }
		 * 
		 * basicamente, é para criar sistemas com baixo acomplamento e flexiveis
		 * 
		 */
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();

		System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
		Date start = sdf.parse(sc.nextLine());

		System.out.print("Return (dd/MM/yyyy hh:mm): ");
		Date finish = sdf.parse(sc.nextLine());

		// criar um novo car rental
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();

		System.out.print("Enter price per hour: ");
		double pricePerDay = sc.nextDouble();

		// criar um novo serviço de aluguel
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
		rentalService.processInvoice(carRental);

		System.out.println("INVOICE:");
		System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().totalPayment()));

		sc.close();
	}

}
