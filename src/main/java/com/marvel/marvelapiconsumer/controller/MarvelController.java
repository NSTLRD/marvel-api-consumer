/**
 * @author Starling Diaz on 5/24/2024.
 * @Academy mentorly
 * @version marvel-api-consumer 1.0
 * @since 5/24/2024.
 */

package com.marvel.marvelapiconsumer.controller;

import com.marvel.marvelapiconsumer.model.CharacterDataWrapper;
import com.marvel.marvelapiconsumer.service.MarvelApiServiceConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarvelController {

    private final MarvelApiServiceConsumer marvelApiServiceConsumer;

    public MarvelController(MarvelApiServiceConsumer marvelApiServiceConsumer) {
        this.marvelApiServiceConsumer = marvelApiServiceConsumer;
    }

    @GetMapping("/characters")
    public CharacterDataWrapper getAllCharacters() {
        return marvelApiServiceConsumer.getAllCharacters();
    }

    @GetMapping("/characters/{characterId}")
    public CharacterDataWrapper getCharacterById(@PathVariable int characterId) {
        return marvelApiServiceConsumer.getCharacterById(characterId);
    }
}