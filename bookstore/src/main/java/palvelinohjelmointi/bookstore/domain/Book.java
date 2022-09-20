package palvelinohjelmointi.bookstore.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Book {
	
	//jpa 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	//atribuutit
	private String title;
	private String author;
	private Integer publishing_year;
	private String isbn;
	private BigDecimal price;
	
	
	//konstruktorit
	public Book(String title, String author, Integer publishing_year, String isbn, BigDecimal price) {
		super();
		this.title = title;
		this.author = author;
		this.publishing_year = publishing_year;
		this.isbn = isbn;
		this.price = price;
	}
	
	
	//getterit setterit
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	
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


	public Integer getpublishing_year() {
		return publishing_year;
	}


	public void setpublishing_year(Integer publishing_year) {
		this.publishing_year = publishing_year;
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
		return "Book [title=" + title + ", author=" + author + ", publishing_year=" + publishing_year + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}
	
	
	
	

}
