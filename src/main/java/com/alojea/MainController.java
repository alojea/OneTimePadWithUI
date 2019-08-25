package com.alojea;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alojea.model.CryptoForm;

@Controller
public class MainController {
	
	CryptoController cryptoController = new CryptoController();
	
	/**
	 * 
	 * Redirection to home page
	 * 
	 * @param model
	 * @return main Screen
	 */
	@RequestMapping(value = "/" , method = RequestMethod.GET)
 	public String initialForm(Model model) {
 		model.addAttribute("cryptoForm", new CryptoForm());
 		return "cryptoMain";
 	}
 	
	/**
	 * Return Encrypt or Decrypt results
	 * 
	 * @param cryptoForm
	 * @param model
	 * @return Encrypt or Decrypt results
	 */
 	@RequestMapping(value = "/" , method = RequestMethod.POST)
 	public String processSubmit(@ModelAttribute CryptoForm cryptoForm, Model model) {
 		
 		if(cryptoForm.getEncryption()) {
 			cryptoForm.setWord(cryptoController.encrypt(cryptoForm.getWord().toUpperCase(),cryptoForm.getKeystream().toUpperCase()));
 		} else {
 			cryptoForm.setWord(cryptoController.decrypt(cryptoForm.getWord().toUpperCase(),cryptoForm.getKeystream().toUpperCase()));
 		}
 		
 		return "cryptoResults";
 	}
 	
 	/**
 	 * 
 	 * Redirection to Help Page
 	 * 
 	 * @param model
 	 * @return help page
 	 */
 	@RequestMapping(value = "/help" , method = RequestMethod.GET)
 	public String help(Model model) {
 		return "help";
 	}
 	
 	/**
 	 * 
 	 * Redirection to about page
 	 * 
 	 * @param model
 	 * @return Redirection to about page
 	 */
 	@RequestMapping(value = "/about" , method = RequestMethod.GET)
 	public String about(Model model) {
 		return "about";
 	}
 	

}
