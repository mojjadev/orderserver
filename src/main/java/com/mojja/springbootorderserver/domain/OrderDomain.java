package com.mojja.springbootorderserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDomain implements Serializable {
    private static final long serialVersionUID = 1725394597127159817L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderCode;
    private String orderObject;
    private String orderStatus;
    private Integer orderPrice;
}