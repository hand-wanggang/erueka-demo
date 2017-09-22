/**
 * ServerInfoController 2017/9/22 12:42
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.demo.serviceprovide.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gang.wang
 * @Title: ServerInfoController
 * @Description: (描述此类的功能)
 * @date 2017/9/22 12:42
 */
@RestController
@RequestMapping("/")
public class ServerInfoController {
	@Value("${server.port}")
	private String port;
	@Value("${spring.application.name}")
	private String serverName;

	@RequestMapping("/info")
	public String info(){
		return "Server Name:"+serverName+"; port: "+port;
	}
}
