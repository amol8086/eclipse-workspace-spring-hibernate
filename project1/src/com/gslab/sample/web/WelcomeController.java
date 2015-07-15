package com.gslab.sample.web;
 
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gslab.sample.service.HelloWorldService;
 
@Controller
@RequestMapping(value="welcome")
public class WelcomeController {
 
	private final Logger logger = Logger.getLogger(WelcomeController.class);
	private final String VIEW = "hello";
	
	@Resource
	private HelloWorldService helloWorldService;
	
	public HelloWorldService getHelloWorldService() {
		return helloWorldService;
	}

	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
 
		logger.debug("index() is executed!");
 
		model.put("title", helloWorldService.getTitle(""));
		model.put("msg", helloWorldService.getDesc());
 
		return VIEW;
	}
 
	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {
 
		logger.debug("hello() is executed - $name {}" + name);
 
		ModelAndView modelAndView = new ModelAndView(VIEW);
 
		modelAndView.addObject("title", helloWorldService.getTitle(name));
		modelAndView.addObject("msg", helloWorldService.getDesc());
 
		return modelAndView;
 
	}
 
}