package cs425.glocery.producting.service;



import cs425.glocery.producting.model.Product;

import java.util.List;

public interface IProductService {

    public List<Product> getAllProducts();
    public Product addNewProduct(Product Product);
    //public Double computeNetLiquidity();
}
