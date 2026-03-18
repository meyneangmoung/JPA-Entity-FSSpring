package co.istad.chhaya.fswd_sbapp.service;

import co.istad.chhaya.fswd_sbapp.dto.CreateProductRequest;
import co.istad.chhaya.fswd_sbapp.dto.IsAvailableRequest;
import co.istad.chhaya.fswd_sbapp.dto.ProductResponse;
import co.istad.chhaya.fswd_sbapp.dto.UpdateProductRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

public interface ProductService {

    ProductResponse updateProductPartiallyByCode(
            String code,
            UpdateProductRequest updateProductRequest
    );
    ProductResponse updateIsAvailableByCode(String code, IsAvailableRequest isAvailableRequest);

    //create a new product
    //Return type
    //parameter
    Page<ProductResponse>getAllProducts(int pageNumber, int pageSize);
    ProductResponse createProduct(CreateProductRequest createProductRequest);
    void deleteProductByCode(String code);

    ProductResponse getProductByCode(String code);

    ProductResponse createNew(@Valid CreateProductRequest createProductRequest);
//    DataResponse getAllProduct(CreateProductRequest createProductRequest);
}