/**
 * @author Starling Diaz on 5/24/2024.
 * @Academy mentorly
 * @version marvel-api-consumer 1.0
 * @since 5/24/2024.
 */

package com.marvel.marvelapiconsumer.service;

import com.marvel.marvelapiconsumer.model.CharacterDataWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class MarvelApiServiceConsumer {

    @Value("${marvel.api.baseurl}")
    private String baseUrl;

    @Value("${marvel.api.publickey}")
    private String publicKey;

    @Value("${marvel.api.privatekey}")
    private String privateKey;

    private final RestTemplate restTemplate;

    public MarvelApiServiceConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CharacterDataWrapper getAllCharacters() {
        String url = String.format("%s/characters?apikey=%s&ts=%d&hash=%s", baseUrl, publicKey, getTimeStamp(), getHash());
        return restTemplate.getForObject(url, CharacterDataWrapper.class);
    }

    public CharacterDataWrapper getCharacterById(int characterId) {
        String url = String.format("%s/characters/%d?apikey=%s&ts=%d&hash=%s", baseUrl, characterId, publicKey, getTimeStamp(), getHash());
        return restTemplate.getForObject(url, CharacterDataWrapper.class);
    }

    private long getTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    private String getHash() {
        String toHash = getTimeStamp() + privateKey + publicKey;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hashBytes = digest.digest(toHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}