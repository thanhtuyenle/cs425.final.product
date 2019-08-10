package cs425.glocery.producting.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotNull(message = "* Product Number is required")
    @Digits(integer = 9, fraction = 0, message = "* Product number must be numeric; and a positive, integral value")
    @Column(name = "productNumber", nullable = false, unique = true)
    private Long productNumber;

    @NotNull(message = "* Name is required")
    @NotBlank(message = "* Name cannot be empty or blank space(s)")
    private String name;

    @NotNull(message = "* Unit Price is required")
    @Digits(integer = 9, fraction = 2, message = "* Unit Price must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'")
    @NumberFormat(pattern = "#,###.##")
    private Double unitPrice;

    @NotNull(message = "* Quantity In Stock is required")
    private Integer quantityInStock;

    @NotNull(message = "* Date Supplied is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSupplied;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplierId", nullable = false)
    @NotNull(message = "* Supplier is required")
    private Supplier supplier;

    public Product(){

    }
    public Product(@NotNull(message = "* Product Number is required") @Digits(integer = 9, fraction = 0, message = "* Product number must be numeric; and a positive, integral value") Long productNumber, @NotNull(message = "* Name is required") @NotBlank(message = "* Name cannot be empty or blank space(s)") String name, @NotNull(message = "* Unit Price is required") @Digits(integer = 9, fraction = 2, message = "* Unit Price must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'") Double unitPrice, @NotNull(message = "* Quantity In Stock is required") Integer quantityInStock, @NotNull(message = "* Date Supplied is required") LocalDate dateSupplied, @NotNull(message = "* Supplier is required") Supplier supplier) {
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.dateSupplied = dateSupplied;
        this.supplier = supplier;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantityInStock=" + quantityInStock +
                ", dateSupplied=" + dateSupplied +
                ", supplier=" + supplier +
                '}';
    }
}
