package com.sos.example.salesorderservice.feign;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.sos.example.salesorderservice.model.Item;


//@FeignClient(name="item-service", url="http://localhost:9092")
@FeignClient(name="item-service",fallback = ItemServiceFeign.HystrixClientFallback.class)
@RibbonClient(name="item-service")
public interface ItemServiceFeign {

	@GetMapping("/service2/items")
	public List<Item> getAllItems();
	
	@Component
    class HystrixClientFallback implements ItemServiceFeign{

		@Override
		public List<Item> getAllItems() {
			System.out.println("Inside HystrixClientFallback");
			return null;
		}
		
	}
}
