package com.java.te;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.java.so.*;

public class bookTest extends JPAUnitTest {
	
	@Test
	public void entityManagerFactoryOK() {
		assertNotNull(emf);
	}
	
	@Test
	public void entityManagerOK() {
		assertNotNull(em);
	}
	
	@Test
	public void findBookAndAddAuthor(){
		Book book= em.find(Book.class, "War and Peace");
		book.addAuthor(new Author("Sara", "Barcelona"));
		book.addAuthor(new Author("Mónica", "Paris"));
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
	}
	
	@Test
	public void findBookAndAddPages(){
		Book book= em.find(Book.class, "War and Peace");
		book.addPage(new Page("Happy families are all alike; every unhappy family is unhappy in its own way.","nunito",book));
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
	}
	@Test
	public void findAuthor(){
		Author author= em.find(Author.class, "Sara");
		
	}
	@Test
	public void newBookAndAuthor() { 
		Book newBook= new Book("Lighthouse",new Date());
		Author author= em.find(Author.class, "Sara");
		if(author==null)
			newBook.addAuthor(new Author("Sara", "Barcelona"));
		else
			newBook.addAuthor(author);
		em.getTransaction().begin();
		em.persist(newBook);
		em.getTransaction().commit();
		Book insertBook = em.find(Book.class,"Lighthouse");
        assertNotNull(insertBook);   
	}
	
	@Test
	public void deleteBook() {
		Book book= em.find(Book.class, "Lighthouse");
		em.getTransaction().begin();
		em.remove(book);
		em.getTransaction().commit();
		Book noBook= em.find(Book.class,"Lighthouse");
		assertNull(noBook);
	}
}
