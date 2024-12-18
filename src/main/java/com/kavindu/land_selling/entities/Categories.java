package com.kavindu.land_selling.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {

    @Id
    private int id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Property> properties;

}
