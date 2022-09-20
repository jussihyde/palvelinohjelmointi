package palvelinohjelmointi.bookstore.domain;


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
	private Double price;
	
	
	//konstruktorit
	public Book() {}
	
	public Book(String title, String author, Integer publishing_year, String isbn, Double price) {
		super();
		this.title = title;
		this.author = author;
		this.publishing_year = publishing_year;
		this.isbn = isbn;
		this.price = price;
	}
	
	
	//getterit setterit
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	public Integer getPublishing_year() {
		return publishing_year;
	}


	public void setPublishing_year(Integer publishing_year) {
		this.publishing_year = publishing_year;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}

	//toString
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publishing_year=" + publishing_year + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}
	
	
	
	

}
