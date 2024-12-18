package com.kavindu.land_selling.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @NotNull
    @Column(nullable = false)
    private String password;

    @Email
    private String email;

    private String phone;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @ManyToMany
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Property> properties;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_land_request_id",referencedColumnName = "id")
    private User_Land_Requests user_land_request;


}
