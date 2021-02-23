package com.jflex.jflexexample.web.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jflex.jflexexample.entity.User;


@RestController
public class FirstController {
	
	@Autowired
	private FirstService firstService;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	@GetMapping("/first")
	public String first(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/user/{id}")
	public String name(@PathVariable("id")int  id ) {
		
		String name = firstService.getNameById(id);
	
		return String.format("Hello %s!", name);
	}
	
	@GetMapping("/userinfo/{id}")
	@ResponseBody
	public User userInfo(@PathVariable("id")int  id ) {
		
		User user = firstService.getUserById(id);
	
		return user;
	}
}
