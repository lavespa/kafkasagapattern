package com.intrieri.kafkasagapattern.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.intrieri.kafkasagapattern.model.dto.OrderRequestDTO;
import com.intrieri.kafkasagapattern.model.dto.OrderResponseDTO;
import com.intrieri.kafkasagapattern.orderservice.entity.PurchaseOrder;
import com.intrieri.kafkasagapattern.orderservice.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public PurchaseOrder createOrder(@RequestBody OrderRequestDTO dto){
        return this.orderService.createOrder(dto);
    }

    @GetMapping("/all")
    public List<OrderResponseDTO> getOrders(){
        return this.orderService.getAll();
    }

}
