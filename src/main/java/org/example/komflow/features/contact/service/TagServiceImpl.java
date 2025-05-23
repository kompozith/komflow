package org.example.komflow.features.contact.service;

import org.example.komflow.features.contact.dto.TagDto;
import org.example.komflow.features.contact.entity.Tag;
import org.example.komflow.features.contact.mapper.TagMapper;
import org.example.komflow.features.contact.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public TagDto create(TagDto tagDto) {
        Tag tag = TagMapper.INSTANCE.tagDtoToTag(tagDto);
        return TagMapper.INSTANCE.tagToTagDto(
                tagRepository.save(tag)
        );
    }

    @Override
    public List<TagDto> getAll() {
        return tagRepository.findAll().stream().map(
                TagMapper.INSTANCE::tagToTagDto
        ).collect(Collectors.toList());
    }

    @Override
    public TagDto getById(int id) {
        return null;
    }

    @Override
    public TagDto update(TagDto tagDto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
