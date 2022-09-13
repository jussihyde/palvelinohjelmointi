package palvelinohjelmointi.bookstore.domain;

import java.math.BigDecimal;

public class Book {
	
	//atribuutit
	private String title;
	private String author;
	private Integer year;
	private String isbn;
	private BigDecimal price;
	
	
	//konstruktorit
	public Book(String title, String author, Integer year, String isbn, BigDecimal price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	
	//getterit setterit
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	//toString
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}
	
	
	
	

}
