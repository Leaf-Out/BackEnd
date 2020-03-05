package eci.ieti.leafOut.backEnd.model;

import java.util.List;

public class Park {

    private Integer idPark;
    private String namePark;
    private String descriptionPark;
    private Location locationPark;
    private String addressPark;
    private List<Plan> plans;

    public Park(){

    }

    public Integer getIdPark() {
        return idPark;
    }

    public void setIdPark(Integer idPark) {
        this.idPark = idPark;
    }

    public String getNamePark() {
        return namePark;
    }

    public void setNamePark(String namePark) {
        this.namePark = namePark;
    }

    public String getDescriptionPark() {
        return descriptionPark;
    }

    public void setDescriptionPark(String descriptionPark) {
        this.descriptionPark = descriptionPark;
    }

    public Location getLocationPark() {
        return locationPark;
    }

    public void setLocationPark(Location locationPark) {
        this.locationPark = locationPark;
    }

    public String getAddressPark() {
        return addressPark;
    }

    public void setAddressPark(String addressPark) {
        this.addressPark = addressPark;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }



}

