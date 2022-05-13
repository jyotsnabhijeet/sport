package com.sportyshoes.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.sportyshoes.dao.AdminLogin;
import com.sportyshoes.dao.Product;
import com.sportyshoes.entities.Admin;
import com.sportyshoes.entities.Item;

@Controller
public class AdminController {
	
	@Autowired
	private AdminLogin adminlogin;
	@Autowired
	private Product product;
	
	@GetMapping("/admin")
	public String adminLogin()
	{
		
		return "admin/login";
	}
	
	@PostMapping("/LoginInfo")
	public String adminValidate(@RequestParam("username") String username,@RequestParam("password") String password)
	{	
		
		Optional<Admin> optional=adminlogin.findById(1);
		Admin user=optional.get();
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		if(user.getUsername().equals(username) && user.getPassword().equals(password))
		{
			return "admin/home";
		}
		
		System.out.println(username+" "+password);
		
		return "redirect:/admin";
		
	}
	
	@GetMapping("/additem")
	public String additems()
	{
		
		return "admin/add";
	}
	
	@GetMapping("/edititem")
	public String edititem()
	{
		
		return "admin/edit";
	}
	
	@GetMapping("/displayorder")
	public String displayorder()
	{
		
		return "admin/display";
	}
	
	
	//adding items
	@PostMapping(value="/addinput", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String additem(@ModelAttribute Item item,
							@RequestParam("imag") MultipartFile file,
							HttpSession s,Model m) throws Exception, IOException {
		
		item.setImage(file.getOriginalFilename());
		
		product.save(item);
		
		System.out.println(file.getOriginalFilename());
		
		byte[] data=file.getBytes();
		
		String path=new ClassPathResource("static/images/").getFile().getAbsolutePath()+ File.separator+file.getOriginalFilename();
		System.out.println(path);
		
		FileOutputStream fos=new FileOutputStream(path);
		fos.write(data);
		fos.close();
		
		m.addAttribute("filename",file.getOriginalFilename());
		
		return "admin/success";
		
	}
	
	//edit item
	@GetMapping("/update")
	public String edit(@RequestParam("itemId") Integer itemId,Model m)
	{
		Optional<Item> optional=product.findById(itemId);
		Item item=optional.get();
		System.out.println(item);
		m.addAttribute("itemId",item.getItemId());
		m.addAttribute("itemName", item.getItemName());
		m.addAttribute("forGender",item.getForGender());
		m.addAttribute("price",item.getPrice());
		m.addAttribute("image",item.getImage());
		
		return "admin/updateitem";
	}
	
	//edit success
	@GetMapping("/editsuccess")
	public String editsuccess(@RequestParam ("itemId") Integer itemId,
							@RequestParam ("itemName") String itemName,
							@RequestParam ("forGender") String forGender,
							@RequestParam ("price") Integer price)
	{
		
		Optional<Item> optional=product.findById(itemId);
		Item item=optional.get();
		System.out.println(item);
		item.setItemName(itemName);
		item.setForGender(forGender);
		item.setPrice(price);
		
		Item result= product.save(item);
		
		System.out.println(result);
		
		return "admin/successedit";
	}
	
	//delete items
	@GetMapping("/delete")
	public String delete()
	{
		return "admin/deleteitem";
	}
	
	@GetMapping("/deleteId")
	public String deleteId(@RequestParam ("ItemId") Integer itemId)
	{
		product.deleteById(itemId);
		return "admin/deletesuccess";
	}
	
	//display all items
	@GetMapping("/display")
	public String display(Model m)
	{
		
		List<Item> itr=(List<Item>)product.findAll();
		
		m.addAttribute("display",itr);
		
		
		return "admin/displayitems";
	}
}
