package palvelinohjelmointi.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;

@Controller
public class BookstoreController {
	
	@RequestMapping(value = "/index")
	public String bookstore() {
		
		return "/index";
	}
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value = "/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		
		return "/booklist";
	}
	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		
		return "redirect:../booklist";
	}
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		
		return "addstudent";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		
		return "redirect:booklist";
	}
	

}
