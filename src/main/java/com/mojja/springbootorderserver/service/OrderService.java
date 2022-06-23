package com.mojja.springbootorderserver.service;

import com.mojja.springbootorderserver.domain.OrderDomain;
import com.mojja.springbootorderserver.repository.OrderDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private OrderDomainRepository orderDomainRepository;

    @Transactional
    public OrderDomain createOrder(OrderDomain orderDomain){
        return orderDomainRepository.save(orderDomain);
    }

    @Transactional(readOnly = true)
    public OrderDomain getOrder(Long id){
        return orderDomainRepository.findById(id).orElse(null);
    }

    @Transactional
    public OrderDomain updaeOrder(OrderDomain orderDomain, Long id) throws Exception {
        OrderDomain orderDomain1 = orderDomainRepository.findById(id).orElseThrow(() -> new Exception("오류 발생"));
        orderDomain1.setOrderCode(orderDomain.getOrderCode());
        orderDomain1.setOrderObject(orderDomain.getOrderObject());
        orderDomain1.setOrderPrice(orderDomain.getOrderPrice());
        orderDomain1.setOrderStatus(orderDomain.getOrderStatus());
        return orderDomain1;
    }
    @Transactional
    public void deleteOrder(Long id) {
//        orderDomainRepository.delete(orderDomainRepository.findById(id).orElse(() -> throw new Exception("오류 발생")));
//        orderDomainRepository.delete(orderDomainRepository.findById(id).orElseThrow(Exception::new));
//        orderDomainRepository.delete(orderDomainRepository.findById(id).orElseThrow(IllegalArgumentException::new));
        orderDomainRepository.delete(orderDomainRepository.findById(id).orElseThrow(()-> new NullPointerException()));


    }

    public List<OrderDomain> getOrderList(){
        return orderDomainRepository.findAll();
    }
}
