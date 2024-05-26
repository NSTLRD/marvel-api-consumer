package com.marvel.marvelapiconsumer;

import com.marvel.marvelapiconsumer.model.CharacterDataWrapper;
import com.marvel.marvelapiconsumer.service.MarvelApiServiceConsumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class MarvelApiConsumerApplicationTests {

	@Autowired
	private MarvelApiServiceConsumer marvelApiServiceConsumer;

	@MockBean
	private RestTemplate restTemplate;

	@BeforeEach
	public void setup() {
		CharacterDataWrapper mockResponse = new CharacterDataWrapper();
		when(restTemplate.getForObject(anyString(), Mockito.eq(CharacterDataWrapper.class))).thenReturn(mockResponse);
	}

	@Test
	public void testGetAllCharacters() {
		CharacterDataWrapper result = marvelApiServiceConsumer.getAllCharacters();
		assertNotNull(result);
	}

	@Test
	public void testGetCharacterById() {
		CharacterDataWrapper result = marvelApiServiceConsumer.getCharacterById(1);
		assertNotNull(result);
	}

}
