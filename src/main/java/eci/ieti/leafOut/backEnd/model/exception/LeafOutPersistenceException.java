package eci.ieti.leafout.backend.model.Exception;

public class LeafOutPersistenceException extends Exception {
	// TODO exceptions
	public static final String PARK_NOT_FOUND = "Park not found";
	public static final String PLAN_NOT_FOUND = "Plan not found";

	public LeafOutPersistenceException(){
		super();
	}

	public LeafOutPersistenceException(String msg){
		super(msg);
	}
}