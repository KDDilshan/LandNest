package com.kavindu.land_selling.contollers;

import com.kavindu.land_selling.common.ErrorResponse;
import com.kavindu.land_selling.dto.request.UserReqDto;
import com.kavindu.land_selling.dto.response.UserResDto;
import com.kavindu.land_selling.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUSer(@Valid @RequestBody UserReqDto userDto, BindingResult result) {
        if (result.hasErrors()) {
            String errorMessages = result.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            return new ResponseEntity<>(new ErrorResponse(errorMessages), HttpStatus.BAD_REQUEST);
        }
        UserResDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
