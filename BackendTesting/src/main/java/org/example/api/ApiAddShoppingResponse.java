package org.example.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiAddShoppingResponse {

    private Integer id;
    private String name;
    private Original measures;
    private List usages;
    private List usageRecipeIds;
    private boolean pantryItem;
    private String aisle;
    private double cost;
    private Integer ingredientID;

}
