package org.paingan.boot.controller;

import javax.validation.Valid;

import org.paingan.boot.domain.UserAccount;
import org.paingan.boot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", this.title);
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value={"/register","/registration"}, method = RequestMethod.GET)
	public ModelAndView register(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", this.title);
		UserAccount user = new UserAccount();
		mav.addObject("user", user);
		mav.setViewName("register");
		return mav;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid UserAccount user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		UserAccount userExists = userRepository.findByUsername(user.getUsername());
		if (userExists != null) {
			bindingResult.rejectValue("username", "error.user", "There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userRepository.save(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new UserAccount());
			modelAndView.setViewName("registration");
		}
		return modelAndView;
	}
}
