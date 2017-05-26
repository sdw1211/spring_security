package kr.otawang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.otawang.model.Book;
import kr.otawang.model.User;
import kr.otawang.repository.ReadingListRepository;

@Controller
@RequestMapping("/")
public class ReadingListController {
	
	@Autowired
	private ReadingListRepository readingListRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String readersBooks(User user, Model model) {
		List<Book> readingList = readingListRepository.findByUser(user);
		
		if (readingList != null) {
			model.addAttribute("books", readingList);
			model.addAttribute("user", user);
		} 
		
		return "readingList";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addToReadingList(User user, Book book) {
		book.setUser(user);
		readingListRepository.save(book);
		return "redirect:/";
	}
	
	@RequestMapping("/home")
	public String home(User user, Model model) {
		model.addAttribute("user", user);
		return "home";
	}
}
