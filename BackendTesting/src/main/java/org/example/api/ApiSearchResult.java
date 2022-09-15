package org.example.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiSearchResult {
    public List<ApiSearchResultItem> results;
    public Integer offset;
    public Integer number;
    public Integer totalResults;
}
