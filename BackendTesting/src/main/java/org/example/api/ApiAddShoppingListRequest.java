package org.example.api;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiAddShoppingListRequest {

    public String item;
    public String aisle;
    public Boolean parse;


}
