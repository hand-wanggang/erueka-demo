/**
 * RequestServerInfoClientImpl 2017/9/22 14:39
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.demo.servicecustomer.feign.impl;

import com.wang.demo.servicecustomer.feign.RequestServerInfoClient;

/**
 * @author gang.wang
 * @Title: RequestServerInfoClientImpl
 * @Description: (描述此类的功能)
 * @date 2017/9/22 14:39
 */
public class RequestServerInfoClientImpl implements RequestServerInfoClient {

	@Override
	public String info() {
		return "Feign Client Is Failed!";
	}
}
