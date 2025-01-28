package com.kavindu.land_selling.repositories;

import com.kavindu.land_selling.entities.AppUser;
import com.kavindu.land_selling.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshRepositoty extends JpaRepository<RefreshToken, Integer> {
    RefreshToken findByRefreshToken(String token);
    RefreshToken findByUser(AppUser user);
    RefreshToken findByUserUsername(String username);
    void delete(RefreshToken refreshToken);

}
