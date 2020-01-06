package com.dsappcenter.jun.mytoilet2;

/**
 * Created by Jun on 2017-11-07.
 */

public class gpsInfo {
    private String toiletName;
    private String latitude;
    private String longitude;

    public gpsInfo(String toiletName, String latitude, String longitude) {
        this.toiletName = toiletName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public gpsInfo() {

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

    public String getToiletName() {
        return toiletName;
    }

    public void setToiletName(String toiletName) {
        this.toiletName = toiletName;
    }
}
