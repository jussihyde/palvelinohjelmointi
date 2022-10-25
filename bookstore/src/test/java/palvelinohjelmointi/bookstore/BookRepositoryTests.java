package palvelinohjelmointi.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;
import palvelinohjelmointi.bookstore.domain.Category;
import palvelinohjelmointi.bookstore.domain.CategoryRepository;
import palvelinohjelmointi.bookstore.domain.Useer;
import palvelinohjelmointi.bookstore.domain.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class BookRepositoryTests {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private UserRepository urepository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Paakallokehraaja");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Ilkka Remes");
	}
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = crepository.findByName("fantasy");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("fantasy");
		}
	
	@Test
	public void findByUsernameShouldReturnUser() {
		Useer user = urepository.findByUsername("user");
		
		assertThat(user.getRole()).isEqualTo("USER");
		
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954, "9780618002221", 16.34, crepository.findByName("fantasy").get(0));
		repository.save(book);
		
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("horror");
		crepository.save(category);
		
		assertThat(category.getCategoryId()).isNotNull();
	}
	
	@Test
	public void createNewUser() {
		Useer user = new Useer("visitor", "$2a$10$QDIdolRvkutvG6O6OkldwO25S/.NJ286IhMtSbX./Oo2zBT/nPX0S", "USER");
		urepository.save(user);
		
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		Long bookId=(long) 04;
		
		repository.deleteById(bookId);
	}

}
