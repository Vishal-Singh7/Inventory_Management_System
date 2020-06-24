package com.dxc.swd.service;

import java.time.LocalDate;
import java.util.List;

import com.dxc.swd.entity.Books;

import com.dxc.swd.exception.BookException;

public interface BooksService {

	Books add(Books book) throws BookException;
	Books update(Books book) throws BookException;
	boolean deleteById(int bcode) throws BookException;
	Books getById(int bcode);
	List<Books> getAllBooks();
	
	Books findByTitle(String title);

	List<Books> findAllByPublishDate(LocalDate publishDate);

}
