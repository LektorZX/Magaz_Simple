package model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@EqualsAndHashCode(of="idOrder")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer idOrder;
    private Set<Product> products = new HashSet<>();

    public void setProducts(Set<Product> products1) {
        this.products.addAll(products1);
    }
}
