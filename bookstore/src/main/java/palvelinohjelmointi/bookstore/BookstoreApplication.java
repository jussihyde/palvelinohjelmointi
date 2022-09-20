package palvelinohjelmointi.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository)
		{return (args) -> {
			Book b1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, "9780747532699", 13.49);
			Book b2 = new Book("Artemis Fowl", "Eoin Colfer", 2001, "9780439344456", 10.70);
			Book b3 = new Book("Paakallokehraaja", "Ilkka Remes", 1997, "9789510221334", 24.90);
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
