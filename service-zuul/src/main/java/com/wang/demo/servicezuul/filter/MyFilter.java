/**
 * MyFilter 2017/9/25 15:51
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.wang.demo.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author gang.wang
 * @Title: MyFilter
 * @Description: (描述此类的功能)
 * @date 2017/9/25 15:51
 */
@Component
public class MyFilter extends ZuulFilter {

	private static final Logger LOG = LoggerFactory.getLogger(MyFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return Boolean.TRUE;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpServletResponse response = ctx.getResponse();
		String requestUrl =  request.getRequestURI();
		String reg ="/\\w+-\\w+/admin";
		if(requestUrl.matches(reg)){
			try {
				PrintWriter writer = response.getWriter();
				writer.print("must admin can request!");
				writer.flush();
				writer.close();
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return null;
	}
}
