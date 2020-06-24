package com.dxc.swd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/header")
	public String header() {
		return "header";
	}
	
	@RequestMapping("/footer")
	public String footer() {
		return "footer";
	}
}
