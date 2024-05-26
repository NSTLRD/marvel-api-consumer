/**
 * @author Starling Diaz on 5/24/2024.
 * @Academy mentorly
 * @version marvel-api-consumer 1.0
 * @since 5/24/2024.
 */

package com.marvel.marvelapiconsumer.model;

import lombok.Data;

import java.util.List;

@Data
public class CharacterDataWrapper {
    private int code;
    private String status;
    private CharacterDataContainer data;

    @Data
    public static class CharacterDataContainer {
        private int offset;
        private int limit;
        private int total;
        private int count;
        private List<Character> results;

        @Data
        public static class Character {
            private int id;
            private String name;
            private String description;
            private Thumbnail thumbnail;

            @Data
            public static class Thumbnail {
                private String path;
                private String extension;
            }
        }
    }
}