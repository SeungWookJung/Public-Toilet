package com.dsappcenter.jun.mytoilet2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.dsappcenter.jun.mytoilet2.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Jun on 2017-11-06.
 */




public class listActivty extends Activity {

    private ArrayList<map_infoActivity> dataList = new ArrayList<map_infoActivity>();
    public map_infoActivity data = null;
    private DataListAdapter adapter;
    private ListView listView;
    private double longi1;
    private double lati1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        Intent intent = getIntent();
        if (intent != null) {
            longi1 = intent.getExtras().getDouble("longi1");
            lati1 = intent.getExtras().getDouble("lati1");
        }
        if(lati1 ==0){
            Toast.makeText(this,"현재위치를 확인하세요(뒤로가기)",Toast.LENGTH_SHORT).show();
        }
        listView = (ListView) findViewById(R.id.listView);
        try {
            URL url;
            String uri = "http://api.data.go.kr/openapi/pblic-toilet-std?serviceKey=YaDzaB8gQG%2Fm0Ti9Zxchhb5zwi8Uunpi9wNvlugUhir3ADrIvWNkmAfYyQEhZxwpOR9zDxonEmM9IK5UEyYjbA%3D%3D&s_page=1&s_list=200&type=xml";;
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            url = new URL(uri);
            InputStream in = url.openStream();
            parser.setInput(in,"euc-kr");
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    String tagName = parser.getName();


                    if (tagName.equals("com.google.gson.internal.LinkedTreeMap resolves-to="+"linked-hash-map"+"")) {
                        data = new map_infoActivity();
                    }
                    else if (tagName.equals("소재지도로명주소")) {
                        data.setAddrRoad(parser.nextText());
                        //Log.d("addrRoad 정보 : ",data.getAddrRoad());
                    }
                    else if (tagName.equals("소재지지번주소")) {
                        data.setAddrJibun(parser.nextText());
                        //Log.d("addrRoad 정보 : ",data.getAddrJibun());
                    }
                    else if (tagName.equals("화장실명")) {
                        data.setToiletName(parser.nextText());
                    }
                    else if (tagName.equals("경도")) {
                        data.setLongitude(parser.nextText());
                   /*     Intent intent1 = new Intent(listActivty.this, MapActivity.class);
                        intent1.putExtra("markerlongi",data.longitude);
                        startActivity(intent1);*/
                    }
                    else if (tagName.equals("위도")) {
                        data.setLatitude(parser.nextText());
                    }
                    else if (tagName.equals("남성용-대변기수")) {
                        data.setMcloset(parser.nextText());
                    }
                    else if (tagName.equals("여성용-대변기수")) {
                        data.setWcloset(parser.nextText());
                    }
                    else if (tagName.equals("남성용-소변기수")) {
                        data.setMurinal(parser.nextText());
                    }
                    String endTag = parser.getName();
                    if ("com.google.gson.internal.LinkedTreeMap".equals(endTag)) {
                        dataList.add(data);
                }
                }
                eventType = parser.next();

            }
            adapter = new DataListAdapter(this,dataList);
            listView.setAdapter(adapter);


        }catch (XmlPullParserException e){
            e.printStackTrace();
        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

            /*      try {

            SAXParserFactory saxPF = SAXParserFactory.newInstance();
            SAXParser saxP = saxPF.newSAXParser();
            XMLReader xmlR = saxP.getXMLReader();
            URL url = new URL("http://10.1.69.50:8080/crowd/xmltest.jsp?longitude="+longi1+"&latitude="+lati1);
            Log.d("lsitview's longitude : ", "" + longi1);
            Log.d("lsitview's latitude : ", "" + lati1);
            DataHandler mydataHandler = new DataHandler();
            xmlR.setContentHandler(mydataHandler);
            InputSource inputSource = new InputSource(url.openStream());
            inputSource.setEncoding("euc-kr");
            xmlR.parse(inputSource);
            dataList = mydataHandler.getData();
            adapter = new DataListAdapter(this, dataList);
            listView.setAdapter(adapter);
        } catch (Exception e) {
            Log.d("parser exception : ", " value = " + e);
        }
*/
    }

}