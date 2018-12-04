package model;

import lombok.*;

@Builder
@Data
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String name;
    private String mail;
    private Integer id;
    private Status status;
}
