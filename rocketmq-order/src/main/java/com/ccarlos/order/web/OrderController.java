package com.ccarlos.order.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	//	超时降级
	@HystrixCommand(
			commandKey = "createOrder",
			commandProperties = {
					@HystrixProperty
							(name = "execution.timeout.enabled", value = "true"),
					@HystrixProperty
							(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
			},
			fallbackMethod = "createOrderFallbackMethod4Timeout"
	)

	// http://localhost:8001/createOrder?cityId=123&platformId=123&userId=123&suppliedId=123&goodsId=213&supplierId=2311
	@RequestMapping("/createOrder")
	public String createOrder(@RequestParam("cityId") String cityId,
							  @RequestParam("platformId") String platformId,
							  @RequestParam("userId") String userId,
							  @RequestParam("supplierId") String supplierId,
							  @RequestParam("goodsId") String goodsId) throws Exception {

		Thread.sleep(5000);
		return "下单成功!";

	}

	public String createOrderFallbackMethod4Timeout(@RequestParam("cityId") String cityId,
													@RequestParam("platformId") String platformId,
													@RequestParam("userId") String userId,
													@RequestParam("suppliedId") String suppliedId,
													@RequestParam("goodsId") String goodsId) throws Exception {
		System.err.println("-------超时降级策略执行------------");
		return "hysrtix timeout !";
	}

}
