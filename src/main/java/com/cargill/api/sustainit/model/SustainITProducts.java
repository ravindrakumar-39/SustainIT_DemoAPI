package com.cargill.api.sustainit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SustainITProducts
{
    private List<SustainITProduct> productList;
    
    public List<SustainITProduct> getProductList() {
        if(productList == null) {
            productList = new ArrayList<>();
        }
        return productList;
    }

}
