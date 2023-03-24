package com.task.task3.dto.mapper;

import com.task.task3.dto.LoginDto;
import com.task.task3.dto.PostingDto;
import com.task.task3.model.entity.Login;
import com.task.task3.model.entity.Posting;
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
public class PostingMapper {
    private ModelMapper modelMapper;

    public Posting toEntity(PostingDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Posting.class);
    }

    public PostingDto toDto(Posting entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, PostingDto.class);
    }

    public List<PostingDto> listToDto(List<Posting> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<PostingDto>>() {
        }.getType());
    }
}
