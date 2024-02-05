package com.nerv.crm.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Table(name = "unchecked_clients")
public class UncheckedClient extends Client {

    public UncheckedClient(Long id, String firstName, String lastname, String phone, String mobileOperator, String city, ClientAttribute attribute) {
        super(id,firstName,lastname,phone,mobileOperator,city,attribute);
    }

}
