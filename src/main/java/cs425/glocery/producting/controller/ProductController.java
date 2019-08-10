package cs425.glocery.producting.controller;


import cs425.glocery.producting.model.Product;
import cs425.glocery.producting.model.Supplier;
import cs425.glocery.producting.service.IProductService;
import cs425.glocery.producting.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
//@RequestMapping(value = "/producting/secure/Products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ISupplierService supplierService;



    @GetMapping(value = {"/producting/product/list"})
    public ModelAndView listProducts() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("products", productService.getAllProducts());
        //mav.addObject("netliquidity", productService.computeNetLiquidity());
        mav.addObject("now", LocalDate.now());
        mav.setViewName("product/list");
        return mav;
    }

    @GetMapping(value = "/producting/product/new")
    public String newProductForm(Model model) {
//        loadDataToModel(model);
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("product", new Product());
        model.addAttribute("suppliers", suppliers);
//        model.addAttribute("ProductTypes", ProductTypes);
        model.addAttribute("now", LocalDate.now());
        return "product/new";
    }

    @PostMapping(value = "/producting/product/new")
    public String addNewProduct(@Valid @ModelAttribute("product") Product Product,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Supplier> suppliers = supplierService.getAllSuppliers();
//            List<ProductType> ProductTypes = ProductTypeService.getAllProductTypes();
            model.addAttribute("suppliers", suppliers);
//            model.addAttribute("ProductTypes", ProductTypes);
            model.addAttribute("now", LocalDate.now());
//            loadDataToModel(model);
            return "product/new";
        }
        productService.addNewProduct(Product);
        return "redirect:/producting/product/list";
    }

    private void loadDataToModel(Model model) {
//        List<Supplier> Suppliers = SupplierService.getAllSuppliers();
//        List<ProductType> ProductTypes = ProductTypeService.getAllProductTypes();
//        model.addAttribute("Product", new Product());
//        model.addAttribute("Suppliers", Suppliers);
//        model.addAttribute("ProductTypes", ProductTypes);
//        model.addAttribute("now", LocalDate.now());
    }
}
