package palvelinohjelmointi.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;
import palvelinohjelmointi.bookstore.domain.Category;
import palvelinohjelmointi.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository)
	
		
		{return (args) -> {
			final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
			
			
			Book b1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, "9780747532699", 13.49);
			Book b2 = new Book("Artemis Fowl", "Eoin Colfer", 2001, "9780439344456", 10.70);
			Book b3 = new Book("Paakallokehraaja", "Ilkka Remes", 1997, "9789510221334", 24.90);
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
			
			repository.findAll().forEach((book) -> {
	            logger.info("{}", book);
	        });
		};
	}
	
	@Bean
	public CommandLineRunner demo2(CategoryRepository repository)
	
		
		{return (args) -> {
			final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
			
			
			Category c1 = new Category("fantasy");
			Category c2 = new Category("sci-fi");
			Category c3 = new Category("romance");
			
			repository.save(c1);
			repository.save(c2);
			repository.save(c3);
			
			repository.findAll().forEach((category) -> {
	            logger.info("{}", category);
	        });
		};
	}

}
