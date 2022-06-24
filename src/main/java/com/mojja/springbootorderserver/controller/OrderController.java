package com.mojja.springbootorderserver.controller;

import com.mojja.springbootorderserver.domain.OrderDomain;
import com.mojja.springbootorderserver.service.OrderService;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;
    @GetMapping()
    public ResponseEntity getOrder(){
        return ResponseEntity.status(HttpStatus.SC_OK).body(orderService.getOrderList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrder(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.SC_OK).body(orderService.getOrder(id));
    }

    @PostMapping()
    public ResponseEntity createOrder(OrderDomain orderDomain){
        return ResponseEntity.status(HttpStatus.SC_OK).body(orderService.createOrder(orderDomain));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateOrder(OrderDomain orderDomain, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.SC_OK).body(orderService.updaeOrder(orderDomain, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.status(HttpStatus.SC_OK).build();
    }


}
