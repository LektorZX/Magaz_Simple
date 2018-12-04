package model;

import lombok.*;

@Builder
@Data
@EqualsAndHashCode(of="rootId")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String rootId;
    private String name;
    private String dimId;
    private String groupId;
    private String postName;
    private String remark;
    private Double price;
    private Double weight;

}
