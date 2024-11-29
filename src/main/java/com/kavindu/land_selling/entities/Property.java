package com.kavindu.land_selling.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String description;

    private String location;

    private int price;

    private String size;

    private String status;

    @
    private User seller_id;
}
