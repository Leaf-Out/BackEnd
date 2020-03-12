package eci.ieti.leafout.backEnd.model;


import lombok.*;

import java.util.List;

/**
 * This class represents a park
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Park {
    /**
     *  id number of a park
     */
    private Integer idPark;
    /**
     * Name of a park
     */
    private String namePark;
    /**
     * Description of a park
     */
    private String descriptionPark;
    /**
     *  Loacation of a park
     */
    private Location locationPark;
    /**
     * public address of a park
     */
    private String addressPark;
    /**
     * List of plans that belong to a park
     */
    private List<Plan> plans;
    /**
     * Cost of the ticket of a park
     */
    private Integer costTicket;


}


