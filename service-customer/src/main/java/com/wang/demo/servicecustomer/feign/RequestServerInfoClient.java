package com.wang.demo.servicecustomer.feign;

import com.wang.demo.servicecustomer.feign.impl.RequestServerInfoClientImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-provide",fallback = RequestServerInfoClientImpl.class)
public interface RequestServerInfoClient {

	@RequestMapping("/info")
	public String info();
}
