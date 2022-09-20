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
public class ApiGetShoppingListResponse {
    private List<ApiAisle> aisles;
    private Double cost;
    private Integer startDate;
    private Integer endDate;

}
