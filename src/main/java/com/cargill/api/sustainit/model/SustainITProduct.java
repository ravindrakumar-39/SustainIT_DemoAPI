package com.cargill.api.sustainit.model;


public class SustainITProduct {

    private Integer id;
    private String productName;

    public SustainITProduct(Integer id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "SustainITProduct{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }
}
