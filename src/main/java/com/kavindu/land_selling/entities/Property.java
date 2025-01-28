package com.kavindu.land_selling.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

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

    private Date created_at;

    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable=false)
    private Categories category;

    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToMany
    @JoinTable(
            name="property_tag",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    private Set<Tag> tags;
}
