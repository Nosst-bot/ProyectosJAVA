package com.test.api.marvelchallenge.persistence.integration.marvel.repository;

import com.test.api.marvelchallenge.dto.MyPageable;
import com.test.api.marvelchallenge.persistence.integration.marvel.dto.CharacterDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterRepository {
    public List<CharacterDto> findAll(MyPageable pageable, String name, int[] comics, int[] series) {
        return null;
    }

    public CharacterDto.CharacterInfoDto findInfoById(Long characterId) {
        return null;
    }
}
