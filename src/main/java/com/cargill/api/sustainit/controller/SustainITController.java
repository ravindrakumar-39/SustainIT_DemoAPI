package com.cargill.api.sustainit.controller;

import java.net.URI;

import com.cargill.api.sustainit.dao.SustainITDAO;
import com.cargill.api.sustainit.model.SustainITProduct;
import com.cargill.api.sustainit.model.SustainITProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/sustainit")
public class SustainITController
{
    @Autowired
    private SustainITDAO sustainITDao;
    
    @GetMapping(path="/", produces = "application/json")
    public SustainITProducts getSustainITProducts()
    {
        return sustainITDao.getAllProducts();
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addProduct(
                        @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                        @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
                        @RequestBody SustainITProduct product)
                 throws Exception 
    {       
        //Generate resource id
        Integer id = sustainITDao.getAllProducts().getProductList().size() + 1;
        product.setId(id);
        
        //add resource
        sustainITDao.addProduct(product);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(product.getId())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
