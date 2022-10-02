package org.example.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiUserConnectResult {
    public String status;
    public String username;
    public String spoonacularPassword;
    public String hash;
}
