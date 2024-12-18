package com.kavindu.land_selling.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    @Id
    private int id;

    private String name;

    private Date created_at;

    @ManyToMany(mappedBy = "tags")
    private Set<Property> properties;
}
