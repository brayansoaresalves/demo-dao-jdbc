package application;

import java.util.Date;

import model.entities.Departament;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Departament obj = new Departament(1, "Books");
		System.out.println(obj);
		
		Seller seller = new Seller(1, "Brayan", "brayan.iub10@gmail.com", new Date(), 1200.0, obj);
		
		System.out.println(seller);

	}

}
