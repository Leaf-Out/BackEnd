package eci.ieti.leafout.backend.model;


import lombok.*;

import java.util.Date;

/**
 * This class represents a Plan
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan {
    /**
     * id number of a plan
     */
    private Integer idPlan;
    /**
     * Name of a plan
     */
    private String namePlan;
    /**
     * Description of a plan
     */
    private String descriptionPlan;
    /**
     * Cost of a plan
     */
    private Integer costPlan;
    /**
     * Initial date
     */
    private Date intialDate;
    /**
     * Final date
     */
    private Date finalDate;


}

