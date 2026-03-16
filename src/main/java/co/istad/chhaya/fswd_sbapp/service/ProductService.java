package co.istad.chhaya.fswd_sbapp.service;

import co.istad.chhaya.fswd_sbapp.dto.CreateProductRequest;
import co.istad.chhaya.fswd_sbapp.dto.ProductResponse;
import jakarta.validation.Valid;

public interface ProductService {

    //create a new product
    //Return type
    //parameter
    ProductResponse createProduct(CreateProductRequest createProductRequest);

    ProductResponse getProductByCode(String code);

    ProductResponse createNew(@Valid CreateProductRequest createProductRequest);
//    DataResponse getAllProduct(CreateProductRequest createProductRequest);
}