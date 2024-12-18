package com.kavindu.land_selling.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResDto {
    private String username;
    private String email;
    private String phone;
}
