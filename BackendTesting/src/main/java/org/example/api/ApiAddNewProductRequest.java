package org.example.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ApiAddNewProductRequest {
    public String title;
    public Integer price;
    public String categoryTitle;

}
