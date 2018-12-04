package model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
public class Basket {
    private Integer idOrder;
    private Integer idUser;
}
