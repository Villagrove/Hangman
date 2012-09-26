package com.vu.se.hm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/webgame")
public class WebGameController {
	
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String playHangman(ModelMap model) {
		
		logger.debug("entering inside playHangman...");

//		model.addAttribute("message", "Turtles Say... Hello World!");
		return "hangman";

	}

}