package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.dao.Product;
import com.sportyshoes.dao.UserLogin;
import com.sportyshoes.entities.Item;
import com.sportyshoes.entities.User;

@Controller
public class HomeController {
	
	@Autowired
	private Product product;
	
	@Autowired
	private UserLogin userLogin;
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	
	@GetMapping("/account")
	public String account()
	{
		return "account";
	}
	
	@GetMapping("/products")
	public String products(Model m)
	{
		List<Item> itr=(List<Item>)product.findAll();
		
		m.addAttribute("display",itr);
		
		
		return "products";
	}
	
	@GetMapping("/about")
	public String about()
	{
		return "about";
	}
	
	@GetMapping("/login")
	public String login()
	{
		
		return "login";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@PostMapping("/checklogin")
	public String checkLogin(@RequestParam ("username") String username,@RequestParam("password") String pasword)
	{
		List<User> alluser=(List<User>)userLogin.findAll();
		int i=0;
		System.out.println(alluser.get(0).getUsername());
		while(alluser.isEmpty()==false)
		{
			if(alluser.get(i).getUsername().equals(username) && alluser.get(i).getPassword().equals(pasword))
			{
				System.out.println(alluser.get(i).getUsername());
				return "loginsuccess";
			}
			i++;
		}
		
		
		return "redirect:/login";
	}
	
	@PostMapping("/registerform")
	public String registerform(@ModelAttribute User user)
	{
		userLogin.save(user);
		
		return "registersuccess";
	}
	
	@GetMapping("/cart")
	public String cart()
	{
		return "cart";
	}
	
	
	
	
	
}
