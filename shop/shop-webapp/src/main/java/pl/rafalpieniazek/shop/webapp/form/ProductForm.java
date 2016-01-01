package pl.rafalpieniazek.shop.webapp.form;

import lombok.Getter;
import lombok.Setter;
import pl.rafalpieniazek.shop.model.category.Category;

/**
 * Created by Rafal on 2016-01-01.
 */
@Getter
@Setter
public class ProductForm {

    public String name;

    private Long categoryId;

    private String description;

    private int quantity;

    private String brand;

    private String model;

}
