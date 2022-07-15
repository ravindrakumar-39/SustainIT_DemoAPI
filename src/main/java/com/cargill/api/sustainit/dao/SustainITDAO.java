package com.cargill.api.sustainit.dao;

import com.cargill.api.sustainit.model.SustainITProduct;
import com.cargill.api.sustainit.model.SustainITProducts;
import org.springframework.stereotype.Repository;

@Repository
public class SustainITDAO
{
    private static SustainITProducts list = new SustainITProducts();
    
    static 
    {
        list.getProductList().add(new SustainITProduct(1, "Tea"));
        list.getProductList().add(new SustainITProduct(2, "Coffee"));
    }
    
    public SustainITProducts getAllProducts()
    {
        return list;
    }
    
    public void addProduct(SustainITProduct product) {
        list.getProductList().add(product);
    }
}
