package com.cargill.api.sustainit.model;



import java.util.ArrayList;
import java.util.List;


public class SustainITProducts
{
    private List<SustainITProduct> productList;
    
    public List<SustainITProduct> getProductList() {
        if(productList == null) {
            productList = new ArrayList<>();
        }
        return productList;
    }


    public void setProductList(List<SustainITProduct> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "SustainITProducts{" +
                "productList=" + productList +
                '}';
    }
}
