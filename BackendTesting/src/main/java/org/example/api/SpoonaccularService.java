package org.example.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class SpoonaccularService<API_KEY> {

        private SpoonaccularApi api;
        private static final String API_KEY = "8d11464d68c94e6da7d94e608f0b9e97";

        public SpoonaccularService() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.spoonacular.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            api = retrofit.create(SpoonaccularApi.class);
        }

        public ApiAddShoppingResponse addShoppingList(@Body String request, String orange, boolean b) {
            Call<ApiAddShoppingResponse> call = api.addShoppingList(request, API_KEY);
            return RetrofitUtils.execute(call);
        }

        public ApiGetShoppingListResponse getShoppingListResponse(@Body ApiGetShoppingListRequest request) {
            Call<ApiGetShoppingListResponse> call = api.getShoppingList(request, API_KEY);
            return RetrofitUtils.execute(call);
        }

        public ApiDeleteFromShoppingListRequest deleteFromShoppingList(String apiKey, String username, Integer id, String hash){
            Call<ApiDeleteFromShoppingListRequest> call = api.deleteFromShoppingList(API_KEY, username, id, hash);
            return RetrofitUtils.execute(call);

        }

    }
