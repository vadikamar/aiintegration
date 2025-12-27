package com.service.aiintegration.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "aiintegration")
public class Memory {
    @Id
    private String id;
    private String type; // personal_preference, profile, etc.
    private String key;  // favorite_movies
    private String value; // I love Marvel movies
    private Double[] embedding; // vector stored here
}
