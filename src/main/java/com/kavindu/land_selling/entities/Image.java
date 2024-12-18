package com.kavindu.land_selling.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    private int id;

    private String url;

    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name = "property_id",nullable = false)
    private Property property;
}
