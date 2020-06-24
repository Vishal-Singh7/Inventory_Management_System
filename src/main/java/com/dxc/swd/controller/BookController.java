package com.dxc.swd.controller;

import java.time.LocalDate;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.swd.entity.Books;

import com.dxc.swd.exception.BookException;

import com.dxc.swd.service.BooksService;

@Controller
public class BookController {

	@Autowired
	private BooksService bookService;

	@GetMapping({ "", "/", "/home" })
	public ModelAndView bookList() {
		return new ModelAndView("booksListPage", "books", bookService.getAllBooks());
	}

	@GetMapping("/newBook")
	public ModelAndView newBooks() {
		return new ModelAndView("booksFormPage", "books", new Books());
	}

	@PostMapping("/newBook")
	public ModelAndView doNewItem(@Valid @ModelAttribute("books") Books books, BindingResult result)
			throws BookException {
		ModelAndView mv = new ModelAndView();
		mv = null;

		if (result.hasErrors()) {
			mv = new ModelAndView("booksFormPage", "books", books);
		} else {
			bookService.add(books);
			mv = new ModelAndView("redirect:/home");
		}

		return mv;
	}

	@GetMapping("/deleteBook")
	public ModelAndView deleteItem(@RequestParam(name = "bcode") int bcode) {
		return new ModelAndView("deletePage", "books", bookService.getById(bcode));
	}

	@PostMapping("/deleteBook")
	public String confirmDeleteItem(@RequestParam(name = "bcode") int bcode,
			@RequestParam(name = "confirm") boolean confirm) throws BookException {
		if (confirm) {
			bookService.deleteById(bcode);
		}
		return "redirect:/home";
	}

	@GetMapping("/editBook")
	public ModelAndView editItem(@RequestParam(name = "bcode") int bcode) {
		return new ModelAndView("booksFormPage", "books", bookService.getById(bcode));
	}

	@PostMapping("/editBook")
	public ModelAndView doUpdateBook(@Valid @ModelAttribute("books") Books books, BindingResult result)
			throws BookException {
		ModelAndView mv = null;

		if (result.hasErrors()) {
			mv = new ModelAndView("booksFormPage", "books", books);
		} else {
			bookService.update(books);
			mv = new ModelAndView("redirect:/home");
		}

		return mv;
	}

	@GetMapping("/findByTitle")
	public ModelAndView findByTitle(@RequestParam("title") String title) {
		return new ModelAndView("booksListPage", "books", Collections.singletonList(bookService.findByTitle(title)));
	}

	@GetMapping("/findByPublishDate")
	public ModelAndView findAllByPublishDate(
			@DateTimeFormat(iso = ISO.DATE) @RequestParam("publishDate") LocalDate publishDate) {
		return new ModelAndView("booksListPage", "books", bookService.findAllByPublishDate(publishDate));
	}
}
