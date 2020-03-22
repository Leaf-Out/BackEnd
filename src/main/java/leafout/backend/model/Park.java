package leafout.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * This class represents a park
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Getter
@Setter
public class Park extends Pay {

    /**
     * List of plans of a park
     */
    List<Plan> planList;

    /**
     * List of activities of a park
     */
    List<Activity> activitiesList;


}
