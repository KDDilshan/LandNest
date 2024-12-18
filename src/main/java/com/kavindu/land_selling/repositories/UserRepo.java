package com.kavindu.land_selling.repositories;

import com.kavindu.land_selling.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
