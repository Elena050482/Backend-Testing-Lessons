package org.example.api;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiDeleteFromShoppingListRequest {
    private String apiKey;
    private String username;
    private Integer id;
    private String hash;
}
