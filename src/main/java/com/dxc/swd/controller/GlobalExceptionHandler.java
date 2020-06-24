package com.dxc.swd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.swd.exception.BookException;

@ControllerAdvice
public class GlobalExceptionHandler {

	Logger logger = LoggerFactory.getLogger("Lms");

	@ExceptionHandler(BookException.class)
	public ModelAndView handleException(BookException exp) {
		logger.error(exp.getMessage(), exp);
		return new ModelAndView("errorPage", "exception", exp);
	}
}
