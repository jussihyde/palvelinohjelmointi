package palvelinohjelmointi.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import palvelinohjelmointi.bookstore.web.BookstoreController;
import palvelinohjelmointi.bookstore.web.CategoryController;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookstoreController bookstoreController;
	
	@Test
	void contextLoads() {
		assertThat(bookstoreController).isNotNull();
	}
	
	@Autowired
	private CategoryController categoryController;
	
	@Test
	void contextLoads2() {
		assertThat(categoryController).isNotNull();
	}

}
