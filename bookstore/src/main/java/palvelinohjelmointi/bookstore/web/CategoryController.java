package palvelinohjelmointi.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.bookstore.domain.Category;
import palvelinohjelmointi.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository repository;
	
	@RequestMapping(value = "/categorylist")
	public String categorylist(Model model) {
		model.addAttribute("categories", repository.findAll());
		
		return "/categorylist";
	}
	@RequestMapping(value = "/newcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		
		return "newcategory";
	}
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		repository.save(category);
		
		return "redirect:categorylist";
	}
}
