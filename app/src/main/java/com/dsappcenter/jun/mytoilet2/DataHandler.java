package com.dsappcenter.jun.mytoilet2;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by Jun on 2017-11-23.
 */

public class DataHandler extends DefaultHandler{
    private String elementValue = null;
    private Boolean elementOn = false;
    private ArrayList<map_infoActivity> dataList = new ArrayList<map_infoActivity>();
    private map_infoActivity data = null;

    public ArrayList<map_infoActivity> getData(){
        return dataList;
    }
    public void startElemnet(String url, String localName, String qName, Attributes attributes)throws SAXException{
        elementOn = true;
        if(localName.equals("item")){
            data = new map_infoActivity();
        }
    }
    @Override
    public void endElement(String url, String localName, String qName) throws SAXException {

        elementOn = false;

        if (localName.equalsIgnoreCase("소재지도로명주소")) {
            data.setAddrRoad(elementValue);
        } else if (localName.equalsIgnoreCase("소재지지번주소")) {
            data.setAddrJibun(elementValue);
        } else if (localName.equalsIgnoreCase("화장실명")) {
            data.setToiletName(elementValue);
        } else if (localName.equalsIgnoreCase("경도")) {
            data.setLongitude(elementValue);
        } else if (localName.equalsIgnoreCase("위도")) {
            data.setLatitude((elementValue));
            Log.i("debuging", "price : " + data.getLatitude());
        } else if (localName.equalsIgnoreCase("남성용-대변기수")) {
            data.setMcloset((elementValue));
        } else if (localName.equalsIgnoreCase("남성용-소변기수")) {
            data.setMcloset((elementValue));
        } else if (localName.equalsIgnoreCase("여성용-대변기수")) {
            data.setWcloset((elementValue));
        } else if (localName.equalsIgnoreCase("com.google.gson.internal.LinkedTreeMap resolves-to="+"linked-hash-map"+"")) {
            dataList.add(data);
            data = null;
        }
    }
        @Override
        public void characters(char[] ch, int start, int length)
            throws SAXException {
            if (elementOn) {
                elementValue = new String(ch, start, length);
                elementOn = false;
            }

        }
    }





