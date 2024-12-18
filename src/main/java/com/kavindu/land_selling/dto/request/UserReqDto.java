package com.kavindu.land_selling.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {
    private String username;
    private String password;
    private String email;
    private String phone;
}
