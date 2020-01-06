package com.dsappcenter.jun.mytoilet2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dsappcenter.jun.mytoilet2.R;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
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

public class MapActivity extends AppCompatActivity implements MapView.CurrentLocationEventListener, MapReverseGeoCoder.ReverseGeoCodingResultListener, MapView.POIItemEventListener, MapView.MapViewEventListener {

    LocationListener mLocationListener;
    ImageButton crowdbtn;
    ImageButton gpsbtn;
    MapView mapView;
    ImageButton listbtn;
    double longitude;
    double latitude;
    private MapReverseGeoCoder mReverseGeoCoder = null;
    private boolean isUsingCustomLocationMarker = false;
    crowdinfo crowdDialog;


    // 온크리에이터 시작부분
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); //GPS정보를 데이터로 전송하기위한 Thread policy추가
        StrictMode.setThreadPolicy(policy); //

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //map2와 map 겹치기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map2);

        Window win = getWindow();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout linear = (LinearLayout) inflater.inflate(R.layout.map, null);

        LinearLayout.LayoutParams paramslinear = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT
        );
        win.addContentView(linear, paramslinear); //xml두개 겹치기 완료

        ///////////////////////////////////////////////////////////////////////////

        //지도 시작
        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE); //GPS정보 가져오기

        mapView = new MapView(this);

        mapView.setCurrentLocationEventListener(this);

        mapView.setPOIItemEventListener(this);
        //mapView.setMapType(MapView.MapType.Hybrid); //하이브리드 맵 출력


        RelativeLayout container = (RelativeLayout) findViewById(R.id.map_view);
        container.addView(mapView);



        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
                Log.d("test", "longitude : " + longitude + ", " + "latitude : " + latitude);

                String long1 = Double.toString(longitude);
                String lati1 = Double.toString(latitude);

                String url = "192.168.114.24:8081";
                HttpClient http = new DefaultHttpClient();
                try {
                    ArrayList<NameValuePair> postData = new ArrayList<NameValuePair>();
                    postData.add(new BasicNameValuePair("longitude", long1));
                    postData.add(new BasicNameValuePair("latitude", lati1));
                    Log.d("gps to jsp : ", "longitude : " + longitude + ", " + "latitude : " + latitude);

                    HttpParams params = http.getParams();
                    HttpConnectionParams.setConnectionTimeout(params, 5000);
                    HttpConnectionParams.setSoTimeout(params, 5000);

                    HttpPost httpPost = new HttpPost(url);
                    UrlEncodedFormEntity entityRequest = new UrlEncodedFormEntity(postData, "EUC-KR");

                    httpPost.setEntity(entityRequest);
                    HttpResponse responsePost = http.execute(httpPost);
                    HttpEntity resEntity = responsePost.getEntity();


                } catch (Exception e) {
                    e.printStackTrace();
                }
                markerAndParsing();

            }


            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };


        //좌표를 가져오기위한 LocationListner활용
        //poiItem.setMarkerType(MapPOIItem.MarkerType.CustomImage); //커스텀이미지로 변환
        // poiItem.setCustomImageResourceId(R.drawable.currentpin2);
        //  poiItem.setCustomImageAnchorPointOffset(new MapPOIItem.ImageOffset(22,0));
        //mapView.setCustomCurrentLocationMarkerTrackingImage(R.drawable.currentpin2,new MapPOIItem.ImageOffset(58,0));
        //mapView.setCustomCurrentLocationMarkerImage(R.drawable.currentpin2,new MapPOIItem.ImageOffset(58,0));
        //Oncreate 안에서 객체화 버튼두개(gps, list이동 버튼)

        gpsbtn = (ImageButton) findViewById(R.id.gps); //gps버튼
        gpsbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
                //mapView.setShowCurrentLocationMarker(false); 안됨.
                //mapView.setCurrentLocationRadiusFillColor(R.color.colorPrimaryDark);
                mapView.setCurrentLocationRadius(150);
                mapView.setCurrentLocationRadiusStrokeColor(R.color.colorPrimaryDark);
                mapView.setCustomCurrentLocationMarkerDirectionImage(R.drawable.currentpin2, new MapPOIItem.ImageOffset(58, 0));




                try {
                    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1, mLocationListener);

                    lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 100, 1, mLocationListener);
                } catch (SecurityException e) {
                    e.printStackTrace();
                }

            }
        });

        Geocoder geocoder = new Geocoder(this);

//        mapView.setMapViewEventListener(mapView.MapViewEventListener);

        //리스트로 이동시키는 인텐트
        listbtn = (ImageButton) findViewById(R.id.surround);
        listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapActivity.this, listActivty.class);
                intent.putExtra("longi1", longitude);
                intent.putExtra("lati1", latitude);
                startActivity(intent);

            }
        }); // 리스트버튼 OnclickListner
        crowdDialog = new crowdinfo(this, suggestionListener ,cancelListener);
        crowdbtn = (ImageButton) findViewById(R.id.crowd);
        crowdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crowdDialog.show();
            }
        });


    } // oncreate 끝나는 지점


    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float v) {
        MapPoint.GeoCoordinate mapPointGeo = mapPoint.getMapPointGeoCoord();

    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {

    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {

    }

    @Override
    public void onReverseGeoCoderFoundAddress(MapReverseGeoCoder mapReverseGeoCoder, String s) {

    }

    @Override
    public void onReverseGeoCoderFailedToFindAddress(MapReverseGeoCoder mapReverseGeoCoder) {

    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }

    public void markerAndParsing() {
        ArrayList<gpsInfo> dataList = new ArrayList<gpsInfo>();
        gpsInfo data = null;
        MapPOIItem poiItem;

        String parsingX;
        String parsingY;
        double convertX = 0;
        double convertY = 0;
                        try {
                            URL url;
                            String uri = "http://api.data.go.kr/openapi/pblic-toilet-std?serviceKey=YaDzaB8gQG%2Fm0Ti9Zxchhb5zwi8Uunpi9wNvlugUhir3ADrIvWNkmAfYyQEhZxwpOR9zDxonEmM9IK5UEyYjbA%3D%3D&s_page=1&s_list=200&type=xml";
                            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                            XmlPullParser parser = factory.newPullParser();
                            url = new URL(uri);
                            InputStream in = url.openStream();
                            parser.setInput(in, "euc-kr");
                            int eventType = parser.getEventType();
                            while (eventType != XmlPullParser.END_DOCUMENT) {
                                if (eventType == XmlPullParser.START_TAG) {
                                    String tagName = parser.getName();
                                    if (tagName.equals("com.google.gson.internal.LinkedTreeMap resolves-to="+"linked-hash-map"+"")) {
                                        data = new gpsInfo();
                                    } else if (tagName.equals("화장실명")) {
                                        data.setToiletName(parser.nextText());
                                    } else if (tagName.equals("경도")) {
                                        data.setLongitude(parser.nextText());
                    } else if (tagName.equals("위도")) {
                        data.setLatitude(parser.nextText());
                    }
                    String endTag = parser.getName();
                    if ("com.google.gson.internal.LinkedTreeMap".equals(endTag)) {
                        dataList.add(data);
                    }

                }
                eventType = parser.next();

            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < dataList.size(); i++) {
            poiItem = new MapPOIItem();
            //poiItem.setItemName(data.getToiletName());
            poiItem.setItemName(dataList.get(i).getToiletName());
            parsingX = dataList.get(i).getLatitude();
            convertX = Double.parseDouble(parsingX);
            parsingY = dataList.get(i).getLongitude();
            convertY = Double.parseDouble(parsingY);

            poiItem.setMapPoint(MapPoint.mapPointWithGeoCoord(convertX, convertY));
            Log.d("x,y 제대로? : ", "" + convertX);
            poiItem.setMarkerType(MapPOIItem.MarkerType.BluePin);
            poiItem.setShowAnimationType(MapPOIItem.ShowAnimationType.SpringFromGround);
            poiItem.setCustomImageResourceId(R.mipmap.markerpin);
            //poiItem.setCustomImageAnchorPointOffset(new MapPOIItem.ImageOffset(22, 0));
            poiItem.setShowCalloutBalloonOnTouch(true);
            mapView.addPOIItem(poiItem);
            }
        }

    View.OnClickListener suggestionListener = new View.OnClickListener() {
        public void onClick(View v) {
            String name, addr, etc;
                EditText editName = (EditText)crowdDialog.findViewById(R.id.crowdToiletName);
                EditText editAddr = (EditText)crowdDialog.findViewById(R.id.crowdaddress);
                EditText editEtc = (EditText)crowdDialog.findViewById(R.id.crowdetc);
                name = editName.getText().toString();
                addr = editAddr.getText().toString();
                etc = editEtc.getText().toString();
                Toast.makeText(getApplicationContext(),"입력받은 이름 정보 : "+name+" 입력받은 주소 정보 : "+addr+" 기타정보 : "+etc,Toast.LENGTH_LONG).show();

            crowdDialog.dismiss();
        }
    };
    View.OnClickListener cancelListener = new View.OnClickListener() {

        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"취소되었습니다",Toast.LENGTH_LONG).show();
            crowdDialog.dismiss();
        }
    };

    @Override
    public void onMapViewInitialized(MapView mapView) {

    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }
}
















