package com.task.task3.dto.mapper;

import com.task.task3.dto.LoginDto;
import com.task.task3.model.entity.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
@Data
public class LoginMapper {
    private ModelMapper modelMapper;

    public Login toEntity(LoginDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Login.class);
    }

    public LoginDto toDto(Login entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, LoginDto.class);
    }

    public List<LoginDto> listToDto(List<Login> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<LoginDto>>() {
        }.getType());
    }

}
