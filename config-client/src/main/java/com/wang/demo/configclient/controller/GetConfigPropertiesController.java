/**
 * GetConfigPropertiesController 2017/9/25 18:26
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.demo.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gang.wang
 * @Title: GetConfigPropertiesController
 * @Description: (描述此类的功能)
 * @date 2017/9/25 18:26
 */
@RestController
@RequestMapping("/")
public class GetConfigPropertiesController {

	@Value("${foo.version}")
	private String version;

	@RequestMapping("/version")
	public String version(){
		return version;
	}
}
