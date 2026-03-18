package co.istad.chhaya.fswd_sbapp.service;

import co.istad.chhaya.fswd_sbapp.domain.Category;
import co.istad.chhaya.fswd_sbapp.domain.Product;
import co.istad.chhaya.fswd_sbapp.dto.CreateProductRequest;
import co.istad.chhaya.fswd_sbapp.dto.IsAvailableRequest;
import co.istad.chhaya.fswd_sbapp.dto.ProductResponse;
import co.istad.chhaya.fswd_sbapp.dto.UpdateProductRequest;
import co.istad.chhaya.fswd_sbapp.mapper.ProductMapper;
import co.istad.chhaya.fswd_sbapp.repository.CategoryRepository;
import co.istad.chhaya.fswd_sbapp.repository.ProductRepository;
import co.istad.chhaya.fswd_sbapp.utill.DataGenerateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;


    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;

    }

    @Override
    public ProductResponse updateIsAvailableByCode(String code, IsAvailableRequest isAvailableRequest) {
        log.info("updateIsAvailableByCode:{} and Status:{}", code, isAvailableRequest);
        // 1. validate
        Product product = productRepository.findById(code)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product code not found"
                ));
        productMapper.isAvailableRequestToProduct(isAvailableRequest, product);

        productRepository.save(product);

        return productMapper.productToProductResponse(product);
    }


    @Override
    public ProductResponse updateProductPartiallyByCode(String code, UpdateProductRequest updateProductRequest) {

     log.info("updateProductPartiallyByCode : {} and new data :{}",
             code , updateProductRequest);

     Product product = productRepository.findById(code)
             .orElseThrow(()-> new ResponseStatusException(
                     HttpStatus.NOT_FOUND,
                     "Product code not found"
             ));
      productMapper.updateProductRequestToProductPartially(
              updateProductRequest,
              product
      );
      product = productRepository.save(product);
      return productMapper.productToProductResponse(product);
    }

    @Override
    public void deleteProductByCode(String code) {
        log.info("deleteProductsBycode:{}", code);
        Product product = productRepository.findById(code)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product code not found "
                ));
        productRepository.delete(product);
    }
     @Override
     public Page<ProductResponse>getAllProducts(int pageNumber, int pageSize){
        log.info("getAllProducts with pageNumber: {}, pageSize:{}",
                pageNumber,pageSize);
//1. Set up page request

         Pageable pageable = PageRequest.of(pageNumber, pageSize);
//2.Finad data from database with request

         Page<Product> prodouctResponsePage = productRepository.findAll(pageable);
         return prodouctResponsePage.map(productMapper::productToProductResponse);
     }
    @Override
    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        return null;
    }
   // Get Product By Code
    @Override
    public ProductResponse getProductByCode(String code) {
        Product product = productRepository.findByCode(code);

        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }

        return productMapper.productToProductResponse(product);
    }

    @Override
    public ProductResponse createNew(CreateProductRequest createProductRequest) {
        // TODO
        // TODO: Validate section
        // 1. Validate category id
        Category existingCategory = categoryRepository
                .findById(createProductRequest.categoryId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category ID doesn't exist!"
                ));
        log.info("existingCategory: {}", existingCategory.getId());

        // 2. Transfer dto (request) to entity
        Product product = productMapper
                .createProductRequestToProduct(createProductRequest);

        product.setCategory(existingCategory);

        product.setCode(DataGenerateUtil.generateProductCode());
        product.setIsAvailable(true);

        // 3. Save entity into database using repository
        product = productRepository.save(product);

        // 4. Transfer entity to dto (response)
        return productMapper.productToProductResponse(product);
    }

}
