package org.example.api;

import retrofit2.Call;
import retrofit2.http.*;

public interface SpoonaccularApi {


    @POST("/users/connect")
    Call<ApiUserConnectResult> connect(@Body ApiUserConnectRequest request, @Query("apiKey") String apiKey);

    @POST("/mealplanner/:username/shopping-list/items")
    Call<ApiAddShoppingResponse> addShoppingList(@Body String request,
                                                 @Query ("apiKey") String apiKey);

    @GET("mealplanner/{username}/shopping-list")
    Call<ApiGetShoppingListResponse> getShoppingList(@Body ApiGetShoppingListRequest request,
                                                     @Query("apiKey") String apiKey);

    @DELETE("mealplanner/{username}/shopping-list/items/{id}")
    Call<ApiDeleteFromShoppingListRequest> deleteFromShoppingList(@Query("apiKey") String apiKey,
                                                                  @Path("username") String username,
                                                                  @Path("id") Integer id,
                                                                  @Query("hash") String hash);

}

