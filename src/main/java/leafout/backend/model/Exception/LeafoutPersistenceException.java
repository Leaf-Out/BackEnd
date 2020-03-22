package leafout.backend.model.Exception;

public class LeafoutPersistenceException extends Exception {

    public static final String PARK_NOT_FOUND = "Park not found";
    public static final String PLAN_NOT_FOUND = "Plan not found";
    public LeafoutPersistenceException(){
        super();
    }
    public LeafoutPersistenceException(String msg){
        super(msg);
    }
}
