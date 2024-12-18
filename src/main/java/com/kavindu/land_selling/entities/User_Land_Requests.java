package com.kavindu.land_selling.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_Land_Requests {
    @Id
    private int id;

    private String description;

    private String location;

    private Double min_price;

    private Double max_price;

    private String size;

    private Date created_at;

}
