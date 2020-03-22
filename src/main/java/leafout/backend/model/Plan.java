package leafout.backend.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * This class represents a plan
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */

@Getter
@Setter
public class Plan extends Pay{
	//TODO implement
    /**
     * List of activities of a park
     */
    List<Activity> activitiesList;

}
