package com.ccarlos.order.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccarlos.store.service.api.HelloServiceApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Reference(version = "1.0.0",
			application = "${dubbo.application.id}",
			interfaceName = "com.ccarlos.store.service.api.HelloServiceApi",
			check = false,
			timeout = 3000,
			retries = 0
	)
	private HelloServiceApi helloService;

	@RequestMapping("/hello")
	public String hello(@RequestParam String name) {
		return helloService.sayHello(name);
	}
}
