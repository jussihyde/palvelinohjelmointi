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
import palvelinohjelmointi.bookstore.domain.Useer;
import palvelinohjelmointi.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository)
	
		
		{return (args) -> {
			final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
			
			Category c1 = new Category("fantasy");
			Category c2 = new Category("sci-fi");
			Category c3 = new Category("romance");
			
			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);
			
			crepository.findAll().forEach((category) -> {
	            logger.info("{}", category);
	        });
			
			
			Book b1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, "9780747532699", 13.49, crepository.findByName("fantasy").get(0));
			Book b2 = new Book("Artemis Fowl", "Eoin Colfer", 2001, "9780439344456", 10.70, crepository.findByName("fantasy").get(0));
			Book b3 = new Book("Paakallokehraaja", "Ilkka Remes", 1997, "9789510221334", 24.90, crepository.findByName("fantasy").get(0));
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
			
			repository.findAll().forEach((book) -> {
	            logger.info("{}", book);
	        });
			
			Useer user1 = new Useer("user", "$2a$10$CvPzuhUj1PUeuu7NcI39vuzrpmA.kVGbI25fL6H/rjVWiExVdh0w.", "USER");
			Useer user2 = new Useer("admin", "$2a$10$HmtSaFkom..jGjQ2B8ak8Ou.jqY7Y1zOmwGwpV.ZvLYBPXsVlRKJa", "ADMIN");
			
			urepository.save(user1);
			urepository.save(user2);
			
			urepository.findAll().forEach((user) -> {
				logger.info("{}", user);
			});
			
		};
	}

}
