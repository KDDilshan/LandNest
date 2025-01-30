package com.kavindu.land_selling.contollers;

import com.kavindu.land_selling.dto.request.UserReqDto;
import com.kavindu.land_selling.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth/api/")
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody UserReqDto userReqDto) {
        try{
            String Response= userService.register(userReqDto.getUsername(),userReqDto.getPassword(),userReqDto.getEmail(),userReqDto.getPhone());
            return new ResponseEntity<>(Response,HttpStatus.CREATED);
        }catch (Exception e){
            Map<String,String> map = new HashMap<>();
            map.put("error",e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }
    }
}
