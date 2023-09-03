package com.fdmgroup.flexdronepodq42022.Service;


import com.fdmgroup.flexdronepodq42022.DTO.LoginDto;
import com.fdmgroup.flexdronepodq42022.DTO.RegisterDto;
import com.fdmgroup.flexdronepodq42022.DTO.UpdateDto;
import org.springframework.validation.BindingResult;

public interface AuthService {
    String login(LoginDto loginDto, BindingResult bindingResult);

    String register(RegisterDto registerDto);
    String registerAdmin(RegisterDto registerDto);

    String updateUserById(Long id, UpdateDto updateDto);

    String updateUser(UpdateDto updateDto);
    String updateCurrentUser(UpdateDto updateDto);
}
