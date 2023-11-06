package com.test.api.marvelchallenge.persistence.integration.marvel.dto;

public record CharacterDto (
         Long id,
         String nombre,
         String description,
         String modified,
         String resourceURI
) {

    public static record CharacterInfoDto (
            String imagePath,
            String description
    ){

    }
}
