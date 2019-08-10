package cs425.glocery.producting.service;


import cs425.glocery.producting.model.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISupplierService {
    List<Supplier> getAllSuppliers();
    Page<Supplier> getAllSuppliers(int pageNo);
    Supplier registerNewSupplier(Supplier Supplier);
}
