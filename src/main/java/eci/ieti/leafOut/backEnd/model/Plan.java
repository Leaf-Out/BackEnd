package eci.ieti.leafOut.backEnd.model;

public class Plan {


    private Integer idPlan;
    private String namePlan;
    private String descriptionPlan;
    private Location locationPlan;
    private String addressPlan;

    public Plan(){

    }
    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public String getNamePlan() {
        return namePlan;
    }

    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }

    public String getDescriptionPlan() {
        return descriptionPlan;
    }

    public void setDescriptionPlan(String descriptionPlan) {
        this.descriptionPlan = descriptionPlan;
    }

    public Location getLocationPlan() {
        return locationPlan;
    }

    public void setLocationPlan(Location locationPlan) {
        this.locationPlan = locationPlan;
    }

    public String getAddressPlan() {
        return addressPlan;
    }

    public void setAddressPlan(String addressPlan) {
        this.addressPlan = addressPlan;
    }
}
