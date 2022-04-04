package com.demo.hibernate.output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.demo.hibernate.dao.BankDao;
import com.demo.hibernate.dao.CustomerDao;
import com.demo.hibernate.dao.MapingDao;
import com.demo.hibernate.entity.Address;
import com.demo.hibernate.entity.Car;
import com.demo.hibernate.entity.CreditCard;
import com.demo.hibernate.entity.Customer;
import com.demo.hibernate.entity.IssueBank;
import com.demo.hibernate.entity.Pancard;
import com.demo.hibernate.entity.Pen;
import com.demo.hibernate.entity.Person;
import com.demo.hibernate.entity.Product;
import com.demo.hibernate.utility.HibernateUtil;

public class Main {
	

	public static void main(String[] args) {
	
		Session session = HibernateUtil.getSession(); 
        Transaction tx = session.beginTransaction();
        
        
        Pen pen1 = session.get(Pen.class, 11);
        System.out.println(pen1);
        
        
        tx.commit();
        session.close();
        
        Session session2 = HibernateUtil.getSession(); 
        Transaction tx2 = session2.beginTransaction();
        

        Pen pen2 = session2.get(Pen.class, 11);
        System.out.println(pen2);
        
        tx2.commit();
        session2.close();
        
        
     
   
	}

	private static void pendata() {
		Session session = HibernateUtil.getSession(); 
        Transaction tx = session.beginTransaction();
        
        Pen cello = new Pen("ballpen","cello");
        Pen renalce = new Pen("montex","renalce");
        Pen gmr = new Pen("faster","GMR");
        Pen src = new Pen("superFaster","SRC");
        
        session.save(cello);
        session.save(renalce);
        session.save(gmr);
        session.save(src);
        
        tx.commit();
        
        session.close();
	}

	private static void extractedProjections() {
		Session session = HibernateUtil.getSession(); 
        Transaction tx = session.beginTransaction();
      
       
        
        Map<String,Object> maplIst = new HashMap<String,Object>();
        
        Criteria max = session.createCriteria(Person.class);
        max.setProjection(Projections.max("prsonId"));
        
        Criteria min = session.createCriteria(Person.class);
        min.setProjection(Projections.min("prsonId"));
        
        Criteria sum = session.createCriteria(Person.class);
        sum.setProjection(Projections.sum("prsonId"));
        
        List<Integer> maxLs =max.list();
        
        List<Integer> minLs =min.list();
        
        maplIst.put("Max", maxLs);
        maplIst.put("Min", minLs);
        maplIst.put("Sum", sum);
        System.out.println(maplIst);
	}

	private static void restictionsTest() {
		Session session = HibernateUtil.getSession(); 
        Transaction tx = session.beginTransaction();
      
        String sql = "select * from Empoyee";
        
        Criteria cr = session.createCriteria(Person.class);
        
        List<String> names = new ArrayList<>();
        names.add("Ramana");
        names.add("Siva");
        cr.add(Restrictions.in("name",names));
        
       
        
        List<Person> results = cr.list();
        
        for(Person p:results) {
        	System.out.println(p);
        }
        
        tx.commit();
        session.close();
	}

	private static void test30() {
		Session session = HibernateUtil.getSession(); 
        Transaction tx = session.beginTransaction();
       // test();
       Query query = session.createQuery("select p.name, "
       		+ "p.pancard.number , a.city from Person p "
				+ "LEFT JOIN p.addressList a where p.name ='siva'" );
		List<Object[]> list = query.list();
		for(Object[] arr : list){
			System.out.println(Arrays.toString(arr));
		}
        
		Person person = (Person) session.get(Person.class, 100);
        
		System.out.println(person);
        tx.commit();
        session.close();
	}

	private static void tesr8() {
		BankDao dao = new BankDao();
		List<IssueBank> bankList = dao.getAllBank();
		
		for(IssueBank bank:bankList) {
			System.out.println(bank);
		}
	}

	private static void test35() {
		List<IssueBank> bankList = new ArrayList<IssueBank>();

		List<CreditCard> cardList = new ArrayList<CreditCard>();

		IssueBank uobBank = new IssueBank();

		uobBank.setBankName("UOB Bank");
		uobBank.setBaranch("Hyderabad");
		
		bankList.add(uobBank);

		CreditCard paltinum = new CreditCard();

		paltinum.setName("Platinum");
		paltinum.setBalance(70000);

		paltinum.setBankList(bankList);

		CreditCard rupay = new CreditCard();
		
		rupay.setName("Rupay");
		rupay.setBalance(15000);
		rupay.setBankList(bankList);
		
		cardList.add(paltinum);
		cardList.add(rupay);
		//uobBank.setCreditCardList(cardList);

	

		BankDao bankDao = new BankDao();
		bankDao.saveBank(uobBank);
	}

	private static void test2() {
		Customer customer = new Customer();

		customer.setCsName("Rahul");

		Product product1 = new Product();

		product1.setProductName("Apple 13 pro");
		product1.setProductType("eletronics");
		product1.setCustomer(customer);

		Product product2 = new Product();

		product2.setProductName("Ogeneral");
		product2.setProductType("eletronics");
		product2.setCustomer(customer);
		Product product3 = new Product();

		product3.setProductName("PepejeneShirt");
		product3.setProductType("cloths");
		product3.setCustomer(customer);
		List<Product> productList = new ArrayList<Product>();

		productList.add(product1);
		productList.add(product2);
		productList.add(product3);

		customer.setProductList(productList);

		CustomerDao customerDao = new CustomerDao();
		customerDao.saveCustomer(customer);
	}

	private static void test() {
		MapingDao dao = new MapingDao();

		Person p = new Person();

		p.setName("Ramana");

		Pancard pc = new Pancard();
		pc.setNumber("RMN87436A");

		List<Address> addressList = new ArrayList<Address>();

		Address ad1 = new Address();
		ad1.setDist("VZM");
		ad1.setCity("Vishakapatanam");
		ad1.setState("A.P");
		ad1.setPerson(p);

		Address ad2 = new Address();
		ad2.setDist("HYD");
		ad2.setCity("Hyderabad");
		ad2.setState("TG");
		ad2.setPerson(p);

		Address ad3 = new Address();
		ad3.setDist("BNG");
		ad3.setCity("Bangulur");
		ad3.setState("KA");
		ad3.setPerson(p);

		addressList.add(ad1);
		addressList.add(ad2);
		addressList.add(ad3);

		p.setAddressList(addressList);

		p.setPancard(pc);

		dao.savePerson(p);
	}
	
	public static void projections() {
		Session session = HibernateUtil.getSession(); 
        Transaction tx = session.beginTransaction();
      
        Example ex = Example.create(tx);
        
        Criteria criteria = session.createCriteria(Person.class);
        criteria.setProjection(null);
        		
       
        tx.commit();
        session.close();
		
		
	}
	
	public void seconDtest() {
		Session session = HibernateUtil.getSession(); 
        Transaction tx = session.beginTransaction();
	
       Person person =(Person) session.get(Person.class,100);
       System.out.println(person);
        
       
        session.close();
        
        Session session2 = HibernateUtil.getSession(); 
         session2.beginTransaction();
        
         Person person2 =(Person) session2.get(Person.class,100);
         session2.close();
         tx.commit();
	}

}
