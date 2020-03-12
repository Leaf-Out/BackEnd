package eci.ieti.leafout.backend.model;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private Integer latitude;
    private Integer longitude ;

}
