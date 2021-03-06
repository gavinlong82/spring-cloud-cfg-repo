package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.IHelloWorldService;

@RestController
public class HelloWorldController {
	@Autowired
	@Qualifier("helloWorldService")
	private IHelloWorldService helloWorldService;

	@RequestMapping(value = "hi")
	public String hi(@RequestParam String name) {
		return helloWorldService.getHelloWorld(name);
	}
	
	/**
	 * 
	 * 使用Hystrix断路器
	 * @param name
	 * @return
	 * @author hui.long
	 */
	@RequestMapping(value = "hiHystrix")
	public String helloW(@RequestParam String name) {
		return helloWorldService.getHelloWorldForHystrix(name);
	}
}
