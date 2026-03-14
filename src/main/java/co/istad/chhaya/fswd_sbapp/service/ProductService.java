package co.istad.chhaya.fswd_sbapp.service;

import co.istad.chhaya.fswd_sbapp.dto.CreateProductRequest;
import co.istad.chhaya.fswd_sbapp.dto.ProductResponse;

public interface ProductService {
    //Return type
    //Parameter
    //Create a new Product
    ProductResponse createNew(CreateProductRequest createProductRequest);

}
