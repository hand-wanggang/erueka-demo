/**
 * RibbonRequestController 2017/9/22 13:35
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.demo.servicecustomer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wang.demo.servicecustomer.feign.RequestServerInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author gang.wang
 * @Title: RibbonRequestController
 * @Description: (描述此类的功能)
 * @date 2017/9/22 13:35
 */
@RestController
@RequestMapping("/")
public class RibbonRequestController {

	@Value("${requestUrl}")
	private String requestUrl;

	@Autowired
	private RequestServerInfoClient serverInfoClient;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/request")
	@HystrixCommand(fallbackMethod = "hasError")
	public String reques(){
		return restTemplate.getForObject(requestUrl,String.class);
	}

	public String hasError(){
		return "sorry server error!";
	}

	@RequestMapping("/feign")
	public String feign(){
		return serverInfoClient.info();
	}
}
