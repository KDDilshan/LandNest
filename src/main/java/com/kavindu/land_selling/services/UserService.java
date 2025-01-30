package com.kavindu.land_selling.services;

import com.kavindu.land_selling.entities.AppUser;
import com.kavindu.land_selling.repositories.RefreshRepositoty;
import com.kavindu.land_selling.repositories.UserRepository;
import com.kavindu.land_selling.security.JwtGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RefreshRepositoty refreshRepositoty;
    private final JwtGenerator jwtGenerator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();


    public UserService(UserRepository userRepository, RefreshRepositoty refreshRepositoty, JwtGenerator jwtGenerator) {
        this.userRepository = userRepository;
        this.refreshRepositoty = refreshRepositoty;
        this.jwtGenerator = jwtGenerator;
    }

    public String register(String username, String password,String email,String phoneNo) {
        if(userRepository.findByUsername(username)!=null) {
            return "Username is already in use";
        }
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setEmail(email);
        appUser.setPhone(phoneNo);
        userRepository.save(appUser);

        return "User Registerd Successfully";

    }
}
