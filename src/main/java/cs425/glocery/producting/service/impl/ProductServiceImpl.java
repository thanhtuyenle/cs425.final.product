package cs425.glocery.producting.service.impl;


import cs425.glocery.producting.model.Product;
import cs425.glocery.producting.repository.IProductRepository;
import cs425.glocery.producting.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll(Sort.by("productNumber"));
    }

    @Override
    public Product addNewProduct(Product Product) {
        return productRepository.save(Product);
    }

//    @Override
//    public Double computeNetLiquidity() {
//        Double netLiquidity = 0.0;
//        List<Product> Products = productRepository.findAll();
//        for(Product Product : Products) {
//            if(!Product.getProductType().getProductTypeName().equalsIgnoreCase("loan")) {
//                netLiquidity += Product.getBalance();
//            } else {
//                netLiquidity -= Product.getBalance();
//            }
//        }
//        return netLiquidity;
//    }
}
