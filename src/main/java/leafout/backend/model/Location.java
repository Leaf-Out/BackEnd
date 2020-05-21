package leafout.backend.model;

import lombok.*;


/**
 * This class represents a location
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    /**
     *
     */
    Integer longitud;

    /**
     *
     */

    Integer latitud;

    /**
     *
     */
    Region region;

    /**
     *
     */
    String description;

}
