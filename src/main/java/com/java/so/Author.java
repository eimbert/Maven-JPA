package com.java.so;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Author implements Serializable {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private long id;
	private String nameAuthor;
	private String cityResidence;
	
	@ManyToMany(mappedBy = "author")
	private List<Book> books;
	
	public Author(){
		super();
	}
	public Author(String name, String city) {
		super();
		this.nameAuthor = name;
		this.cityResidence = city;
	}
	
	public void addBook(Book b){
		books.add(b);
	}
	public String getNameAuthor() {
		return nameAuthor;
	}
	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getCityResidence() {
		return cityResidence;
	}
	public void setCityResidence(String cityResidence) {
		this.cityResidence = cityResidence;
	}

}
