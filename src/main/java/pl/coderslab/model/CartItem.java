package pl.coderslab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CartItem {

    private Integer quantity;
    private Product product;
}
