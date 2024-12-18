package com.kavindu.land_selling.services;

import com.kavindu.land_selling.dto.request.UserReqDto;
import com.kavindu.land_selling.dto.response.UserResDto;
import com.kavindu.land_selling.entities.User;
import com.kavindu.land_selling.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserService(UserRepo userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserResDto createUser(UserReqDto userreqDto) {
        User user=modelMapper.map(userreqDto, User.class);
        user=userRepository.save(user);
        return modelMapper.map(user, UserResDto.class);
    }
}
