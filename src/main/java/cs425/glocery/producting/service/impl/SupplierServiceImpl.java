package cs425.glocery.producting.service.impl;

import cs425.glocery.producting.model.Supplier;
import cs425.glocery.producting.repository.ISupplierRepository;
import cs425.glocery.producting.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll(Sort.by("name"));
    }

    @Override
    public Page<Supplier> getAllSuppliers(int pageNo) {
        return supplierRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("name")));
    }

    @Override
    public Supplier registerNewSupplier(Supplier Supplier) {
        return supplierRepository.save(Supplier);
    }

}
