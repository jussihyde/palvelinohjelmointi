package palvelinohjelmointi.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	

}
