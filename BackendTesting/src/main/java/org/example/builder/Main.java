package org.example.builder;

import org.example.api.ApiAddShoppingResponse;
import org.example.api.SpoonaccularService;

public class Main {
    public static void main(String[] args) {


        SpoonaccularService spoonaccularService = new SpoonaccularService();
        ApiAddShoppingResponse addItems = spoonaccularService.addShoppingList(
                "1 bag oranges", "orange", true);
        System.out.println(addItems);

    }

}

