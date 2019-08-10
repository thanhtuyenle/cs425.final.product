package cs425.glocery.producting.repository;

import cs425.glocery.producting.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier, Integer> {
}
