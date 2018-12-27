package org.paingan.boot.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.paingan.boot.domain.Users;
//import org.paingan.boot.config.GoogleProvider;
import org.paingan.boot.domain.Role;
import org.paingan.boot.repository.RoleRepository;
import org.paingan.boot.repository.UserRepository;
import org.paingan.boot.security.AuthoritiesConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", this.title);
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value={"/registration"}, method = RequestMethod.GET)
	public ModelAndView register(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", this.title);
		Users user = new Users();
		mav.addObject("user", user);
		mav.setViewName("register");
		return mav;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid @ModelAttribute("user")  Users user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", this.title);
		modelAndView.addObject("user", user);
		
		Users userExists = userRepository.findByUsername(user.getUsername());
		if (userExists != null) {
			bindingResult.rejectValue("username", "error.username", "There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("register");
			logger.debug("createNewUser ERROR");
			
			List<ObjectError> errorList = bindingResult.getAllErrors();
			for (ObjectError objectError : errorList) {
				System.out.println(objectError.getObjectName()+" "+objectError.getCode()+" "+objectError.getDefaultMessage());
			}
			
		} else {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			
			Set<Role> roles = new HashSet<Role>();
			user.setRoles(roles);
			user.getRoles().add( roleRepository.findByRole(AuthoritiesConstants.USER.getKey()) );
			
			userRepository.save(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new Users());
			modelAndView.setViewName("register");
		}
		
		
		return modelAndView;
	}
	
	

	 
	private static String authorizationRequestBaseUri = "oauth2/authorization";
	Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;

	@GetMapping("/oauth_login")
	public String getLoginPage(Model model) {
		Iterable<ClientRegistration> clientRegistrations = null;
		ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository).as(Iterable.class);
		if (type != ResolvableType.NONE && ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
			clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
		}

		clientRegistrations.forEach(registration -> oauth2AuthenticationUrls.put(registration.getClientName(),
				authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
		model.addAttribute("urls", oauth2AuthenticationUrls);

		return "oauth_login";
	}
}
