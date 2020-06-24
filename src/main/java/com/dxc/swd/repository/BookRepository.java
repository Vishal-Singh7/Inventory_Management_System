package com.dxc.swd.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dxc.swd.entity.Books;


@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

	Books findByTitle(String title);

	List<Books> findAllByPublishDate(LocalDate publishDate);

}