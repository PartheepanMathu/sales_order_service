package com.sos.example.salesorderservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sos.example.salesorderservice.feign.ItemServiceFeign;
import com.sos.example.salesorderservice.model.Item;
import com.sos.example.salesorderservice.model.Order;
import com.sos.example.salesorderservice.model.OrderLineItem;
import com.sos.example.salesorderservice.model.SalesOrder;
import com.sos.example.salesorderservice.repository.OrderLineItemRepository;
import com.sos.example.salesorderservice.repository.SalesOrderRepository;

@Service
public class SosService {
	
	@Autowired
	ItemServiceFeign itemServiceFeign;
	
	@Autowired
	SalesOrderRepository salesOrderRepository;
	
	@Autowired
	OrderLineItemRepository orderLineItemRepository;
	
	public Order createOrder(Order order){
		SalesOrder salesOrder = null;
		OrderLineItem OrderLineItem = null;
		List<Item> listOfAllItems = itemServiceFeign.getAllItems();
		List<Item> listOfItemsToBill = getListOfItemsForBilling(listOfAllItems,order);
		double totalPrice = getItemsTotalPrice(listOfItemsToBill);
		if(totalPrice > 0){
			salesOrder = saveSalesOrder(order,totalPrice);
			if(null != salesOrder){
				if(null != salesOrder.getOrderId()){
					saveOrderLineItem(salesOrder.getOrderId(),listOfItemsToBill);
				}
			}
		}
		System.out.println("Count"+listOfItemsToBill.size());
		System.out.println("Total Price "+totalPrice);
		return null;
	}


	private List<Item> getListOfItemsForBilling(List<Item> listOfAllItems, Order order) {
		List<Item> listOfOrderedItems = order.getItems();
		List<Item> listOfItemsToBill = new ArrayList<Item>();
		if(null == listOfAllItems){
			System.out.println("No Itemsssss Availble");
		}else{
			System.out.println("Itemsssss-----------"+listOfAllItems.get(0).getName());
			for(Item OrderedItem : listOfOrderedItems){
				for(Item availbleItem : listOfAllItems){
					if(OrderedItem.getName().equalsIgnoreCase(availbleItem.getName()) && OrderedItem.getQuantity() > 0){
						availbleItem.setQuantity(OrderedItem.getQuantity());
						listOfItemsToBill.add(availbleItem);
					}
				}
			}
		}
		return listOfItemsToBill;
	}
	
	private double getItemsTotalPrice(List<Item> listOfItemsToBill) {
		double totalPrice = 0.0;
		double individualPrice = 0.0;
		if(null != listOfItemsToBill){
			for(Item item : listOfItemsToBill){
				individualPrice = item.getPrice() * item.getQuantity();
				totalPrice = totalPrice + individualPrice;
			}
		}
		return totalPrice;
	}
	
	private SalesOrder saveSalesOrder(Order order, double totalPrice) {
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setCustId(order.getCustId());
		salesOrder.setOrderDate(new Date());
		salesOrder.setOrderDesc(order.getOrderDesc());
		salesOrder.setTotalPrice(totalPrice);
		return salesOrderRepository.save(salesOrder);
	}

	private void saveOrderLineItem(Long orderId, List<Item> listOfItemsToBill) {
		for(Item item : listOfItemsToBill){
			OrderLineItem orderLineItem = new OrderLineItem();
			orderLineItem.setItemName(item.getName());
			orderLineItem.setItemQuantity(item.getQuantity());
			orderLineItem.setOrderId(orderId);
			orderLineItemRepository.save(orderLineItem);
		}
		
	}
}
