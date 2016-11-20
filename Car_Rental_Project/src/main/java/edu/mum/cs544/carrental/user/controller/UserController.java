package edu.mum.cs544.carrental.user.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.cs544.carrental.user.domain.Customer;
import edu.mum.cs544.carrental.user.domain.Role;

import edu.mum.cs544.carrental.user.service.UserService;



@Controller
@SessionAttributes("userSession")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping(value="/signUp",method=RequestMethod.GET)
	public String signUp(@ModelAttribute("newUser") Customer customer){
		return "signUp";
	}
	@RequestMapping(value="/signUp",method=RequestMethod.POST)
	public String afterSignUp(@ModelAttribute("newUser") @Valid Customer customer,BindingResult result,RedirectAttributes redirectAttributes ){
		customer.getUser().setHasRole(Role.ROLE_CUSTOMER);
		if(result.hasErrors()){
			return "signUp";
		}
		userService.add(customer);
		redirectAttributes.addFlashAttribute("users",customer);
		return "redirect:/vehicles";
	}
	@RequestMapping(value="/users",method=RequestMethod.GET)
public String allUser(Model model){

	model.addAttribute("users",userService.getAll());
	return "users";
}
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
public String delete(@PathVariable("id") Long id){
		//Customer customer=userService.findOne(id);
		userService.delete(id);
	return "redirect:/users";
}
	@RequestMapping(value="/useredit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id") Long id,Model model){
			Customer customer=userService.getCustomerById(id);
			model.addAttribute("user", customer);
			return "edituser";
			
	}
	@RequestMapping(value="/useredit",method=RequestMethod.POST)
	public String afteredit(@ModelAttribute("user") @Valid Customer customer,BindingResult result,RedirectAttributes redirectAttributes ){
		customer.getUser().setHasRole(Role.ROLE_CUSTOMER);
		if(result.hasErrors()){
			return "edituser";
		}
		/*userService.edit(customer);*/
		redirectAttributes.addFlashAttribute("customer",customer);
	
		return "redirect:/index";
	}
	
	/*@RequestMapping(value="/account",method=RequestMethod.GET)
	public String account(Model model,Principal principal){
			String name=principal.getName();
			Customer customer=userService.findOneWithName(name);
			model.addAttribute("user", customer);
			return "myprofile";
			
	}
	*/
}
