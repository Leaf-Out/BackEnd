package leafout.backend.model;

import lombok.*;

import java.util.UUID;


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
     * ID of the payable item
     */
    UUID id;
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

}
