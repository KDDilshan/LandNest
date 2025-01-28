package com.kavindu.land_selling.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true, nullable=false)
    private String refreshToken;

    @Column(nullable=false, unique=true)
    private Long expiresIn;

    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private AppUser user;
}
