package palvelinohjelmointi.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Category {
	
	//jpa id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;
	
	//atribuutti
	private String name;
	
	//parametritön konstruktori
	public Category() {}
	
	//konstruktori
	public Category(String name) {
		super();
		this.name = name;
	}
	
	//getterit setterit

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}
	
	

	
	
	
	

}
