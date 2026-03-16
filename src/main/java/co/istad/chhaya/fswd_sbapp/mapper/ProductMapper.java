package co.istad.chhaya.fswd_sbapp.mapper;

import co.istad.chhaya.fswd_sbapp.domain.Product;
import co.istad.chhaya.fswd_sbapp.dto.CreateProductRequest;
import co.istad.chhaya.fswd_sbapp.dto.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    //Source data => Parameter
    //Target data => Return Type
    ProductResponse productToProductResponse(Product product);
    Product createProductRequestToProduct(
            CreateProductRequest createProductRequest
    );
}
