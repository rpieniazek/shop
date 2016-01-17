package pl.rafalpieniazek.shop.webapp.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import pl.rafalpieniazek.shop.model.product.Product;

import javax.validation.constraints.Min;
import java.sql.Date;


/**
 * Created by Rafal on 2016-01-01.
 */
@Getter
@Setter
public class ProductForm {

    public ProductForm() {
    }

    public ProductForm(Product product) {

        this.id = product.getId();
        this.name = product.getName();
        this.categoryId = product.getCategory().getId();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
        this.brand = product.getBrand();
        this.model = product.getModel();
    }

    private Long id;

    @NotEmpty(message = "Wprowadź prawidłową nazwę")
    private String name;


    private Long categoryId;

    @NotEmpty(message = "Wprowadź prawidłowy opis")
    private String description;

    @Min(value = 1,
            message = "Ilość powinna być większa niż 0")
    private int quantity;

    @NotEmpty(message = "Wprowadź prawidłową markę")
    private String brand;

    @NotEmpty(message = "Wprowadź prawidłowy model")
    private String model;
}
