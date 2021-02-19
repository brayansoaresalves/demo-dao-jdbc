package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

	public class Program{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
	
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println("=== TEST 2: seller findByIdDepartament =====");
		Departament departament = new Departament(2, null);
		List<Seller> list = sellerDao.findByDepartament(departament);
		
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.println("=== TEST 3: seller findAll  =====");

		list = sellerDao.findAll();
		
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.println("=== TEST 4: seller insert  =====");
		
		Seller newSeller = new Seller(null, "Brenda", "brenda.iub12@gmail.com", new Date(), 4000.0, departament);
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted new Id = " + newSeller.getId());
		
		System.out.println();
		
		System.out.println("=== TEST 5: seller update  =====");
		
		seller = sellerDao.findById(1);
		seller.setName("Marta Ueine");
		sellerDao.update(seller);
		System.out.println("Updated Completed! ");
		
		System.out.println();
		
		System.out.println("=== TEST 6: seller delete  =====");
		
		System.out.println("Enter id for test delete: ");
		int id = sc.nextInt();
		
		sellerDao.deleteById(id);
		
		System.out.println("Delete completed!");
		
		
		sc.close();

	}

}
