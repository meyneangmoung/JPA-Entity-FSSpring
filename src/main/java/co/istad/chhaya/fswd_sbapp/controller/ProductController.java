package co.istad.chhaya.fswd_sbapp.controller;


import co.istad.chhaya.fswd_sbapp.dto.CreateProductRequest;
import co.istad.chhaya.fswd_sbapp.dto.IsAvailableRequest;
import co.istad.chhaya.fswd_sbapp.dto.ProductResponse;
import co.istad.chhaya.fswd_sbapp.dto.UpdateProductRequest;

import co.istad.chhaya.fswd_sbapp.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductResponse> getAllProducts(
            @RequestParam(required = false,defaultValue = "0") int pageNumber,
            @RequestParam(required = false,defaultValue = "20") int pageSize
    ){
        log.info("pageNumber : {}, pageSize : {}",pageNumber,pageSize);
        return productService.getAllProducts(pageNumber,pageSize);
    }
    @GetMapping("/{code}")
    public ProductResponse getProductByCode(@PathVariable String code) {
        log.info("getProductByCode: {}", code);

        return productService.getProductByCode(code);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductResponse createNewProduct(
           @Valid @RequestBody CreateProductRequest createProductRequest){
        log.info("createProductRequest : {}",createProductRequest);
        return productService.createNew(createProductRequest);
    }

    @PutMapping("/{code}")
        public ProductResponse updateIsAvailableByCode(@PathVariable String code,
                @Valid @RequestBody IsAvailableRequest isAvailableRequest){
            log.info("updateProductByCode: {}, with new data: {}", code, isAvailableRequest);
            return productService.updateIsAvailableByCode(code, isAvailableRequest);
        }
    @PatchMapping("/{code}")
    public ProductResponse updateProductPartiallyByCode(@PathVariable String code,
                                                        @Valid @RequestBody UpdateProductRequest updateProductRequest) {
        log.info("updateProductPartiallyByCode: {}, with new data: {}", code, updateProductRequest);
        return productService.updateProductPartiallyByCode(code, updateProductRequest);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void deleteProductByCode(@PathVariable String code){
        log.info("deleteProductByCode: {}",code);
        productService.deleteProductByCode(code);
    }
    }

