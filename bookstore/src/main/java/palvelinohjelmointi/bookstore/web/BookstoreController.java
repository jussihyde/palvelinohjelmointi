package palvelinohjelmointi.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;
import palvelinohjelmointi.bookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	
	@RequestMapping(value = "/index")
	public String bookstore() {
		
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		
		return "booklist";
	}
	@RequestMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		
		return "redirect:../booklist";
	}
	@RequestMapping(value = "/editbook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		
		Book book = repository.findById(bookId).get();
		model.addAttribute("book", book);
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	@RequestMapping(value = "/editready", method = RequestMethod.POST)
	public String editReadyBook(Book book) {
		repository.save(book);
		
		return "redirect:booklist";
	}
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		
		
		return "addbook";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		
		return "redirect:booklist";
	}
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("id") Long id) {
		Optional<Book> bookEntity = repository.findById(id);
		Book bookFix = bookEntity.get();
		return bookFix;
	}
	
	

}
