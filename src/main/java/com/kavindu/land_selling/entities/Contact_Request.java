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
public class Contact_Request {
    @Id
    private int id;

    private String message;

    private Date contact_date;

    //cheak wherther this is best or a comment in a property
}
