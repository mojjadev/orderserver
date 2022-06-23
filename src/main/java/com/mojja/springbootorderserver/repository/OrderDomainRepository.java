package com.mojja.springbootorderserver.repository;

import com.mojja.springbootorderserver.domain.OrderDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDomainRepository extends JpaRepository<OrderDomain, Long> {
}