package com.itwillbs.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// http://localhost:8088/controller/
	// http://localhost:8088/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		myHashing("SHA-256", "admin123");
		
		return "home";
	}
	
	//해쉬 알고리즘 구현(암호화-sha-256)
	public void myHashing(String hashAlgorithm, String data) {
		
		try {
			MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
			//암호화 데이터를 바이트 배열의 형태로 변경
			byte[] byteData = data.getBytes();
			
			md.update(byteData);
			
			byte[] digest = md.digest();
			
			String hashData = "";
			//암호화 데이터를 16진수 형태로 변경
			for(int i=0;i<digest.length;i++) {
				hashData += Integer.toHexString(digest[i]&0xFF).toUpperCase();
				
			}
			
			System.out.println("암호화 성공 : " + hashData);
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
}
