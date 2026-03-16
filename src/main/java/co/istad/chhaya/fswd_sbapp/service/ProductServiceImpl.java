package co.istad.chhaya.fswd_sbapp.service;

import co.istad.chhaya.fswd_sbapp.domain.Category;
import co.istad.chhaya.fswd_sbapp.domain.Product;
import co.istad.chhaya.fswd_sbapp.dto.CreateProductRequest;
import co.istad.chhaya.fswd_sbapp.dto.ProductResponse;
import co.istad.chhaya.fswd_sbapp.mapper.ProductMapper;
import co.istad.chhaya.fswd_sbapp.repository.CategoryRepository;
import co.istad.chhaya.fswd_sbapp.repository.ProductRepository;
import co.istad.chhaya.fswd_sbapp.utill.DataGenerateUtil;
import lombok.extern.slf4j.Slf4j;
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
