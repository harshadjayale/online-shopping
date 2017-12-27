package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping (value = {"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView("page");
		//mv.addObject("gretting", "Welcome to Spring MVC");
		return mv;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam (value="gretting",required=false)String gretting ){
		if(gretting==null){
			gretting= "Hello User";
		}
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("gretting", gretting);
		return mv;
	}
	
	@RequestMapping(value="/path/{gretting}")
	
	public ModelAndView path(@PathVariable("gretting") String gretting){
		ModelAndView modelAndView=new ModelAndView("page");
		modelAndView.addObject("gretting",gretting);
		return modelAndView;
	}
}
