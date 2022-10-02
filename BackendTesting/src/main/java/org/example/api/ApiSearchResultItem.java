package org.example.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiSearchResultItem {
    public Long id;
    public  String title;
    public  String image;
    public  String imageType;
}
