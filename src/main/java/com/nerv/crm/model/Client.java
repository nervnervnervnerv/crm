package com.nerv.crm.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public String firstName;
    public String lastName;
    public String phone;
    public String mobileOperator;
    public String city;
    @Column(nullable = true)
    public ClientAttribute attribute;
//    @ManyToOne()
//    public Manager manager;
}
