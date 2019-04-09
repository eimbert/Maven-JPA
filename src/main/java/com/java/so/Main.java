package com.java.so;


import java.util.Date;

import javax.persistence.*;

public class Main {

	public static void main(String[] args) {
	    
	    	 
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoMySQL");
	        EntityManager em = emf.createEntityManager();
	        Book c=new Book("pepe",new Date());
	        c.addAuthor(new Author("Sara", "Barcelona"));
	        em.getTransaction().begin();
	     
	        em.persist(c);
	         
	         
	        em.getTransaction().commit();
	         
	        //System.out.println(c.getNumero());
	 
	  

	}

}
