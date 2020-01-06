package com.dsappcenter.jun.mytoilet2;

/**
 * Created by Jun on 2017-11-06.
 */

public class map_infoActivity {

    String addrRoad, addrJibun,toiletName,longitude,latitude;
    String mcloset,murinal,wcloset;

  /*  public map_infoActivity(String longitude, String latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public map_infoActivity(String addrRoad,String toiletName, String mcloset, String murinal, String wcloset) {
        this.addrRoad = addrRoad;
        this.toiletName = toiletName;
        this.mcloset = mcloset;
        this.murinal = murinal;
        this.wcloset = wcloset;
    }

    public map_infoActivity(String latitude, String longitude, String addrRoad, String addrJibun, String toiletName, String mcloset, String murinal, String wcloset) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.addrRoad = addrRoad;
        this.addrJibun = addrJibun;
        this.toiletName = toiletName;
        this.mcloset = mcloset;
        this.murinal = murinal;
        this.wcloset = wcloset;
    }
    public map_infoActivity(){
    }

    public map_infoActivity(String toiletName, String addrRoad, String mcloset, String wcloset) {
        this.toiletName = toiletName;
        this.addrRoad = addrRoad;
        this.mcloset = mcloset;
        this.wcloset = wcloset;
    }*/
  public map_infoActivity(){

  }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }






    public String getAddrRoad() {
        return addrRoad;
    }

    public void setAddrRoad(String addrRoad) {
        this.addrRoad = addrRoad;
    }

    public String getAddrJibun() {
        return addrJibun;
    }

    public void setAddrJibun(String addrJibun) {
        this.addrJibun = addrJibun;
    }

    public String getToiletName() {
        return toiletName;
    }

    public void setToiletName(String toiletName) {
        this.toiletName = toiletName;
    }

    public String getMcloset() {
        return mcloset;
    }

    public void setMcloset(String mcloset) {
        this.mcloset = mcloset;
    }

    public String getMurinal() {
        return murinal;
    }

    public void setMurinal(String murinal) {
        this.murinal = murinal;
    }

    public String getWcloset() {
        return wcloset;
    }

    public void setWcloset(String wcloset) {
        this.wcloset = wcloset;
    }

    /*@Override
    public String toString() {
        return "map_infoActivity{" +
                "addrRoad='" + addrRoad + '\'' +
                ", addrJibun='" + addrJibun + '\'' +
                ", toiletName='" + toiletName + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", mcloset='" + mcloset + '\'' +
                ", murinal='" + murinal + '\'' +
                ", wcloset='" + wcloset + '\'' +
                '}';
    }*/
}
