package eci.ieti.leafout.backEnd.model;


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
