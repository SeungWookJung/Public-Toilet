package com.dsappcenter.jun.mytoilet2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dsappcenter.jun.mytoilet2.R;

import java.util.ArrayList;

/**
 * Created by Jun on 2017-11-23.
 */

public class DataListAdapter extends BaseAdapter {
    private ArrayList<map_infoActivity> dataList;
    private Context context;

    public DataListAdapter(Context context, ArrayList<map_infoActivity> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        map_infoActivity data = dataList.get(position);
        LayoutInflater inflater;

  //      if (v == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v = inflater.inflate(R.layout.singer_item, null);
//        }
        //if (data != null) {
            TextView textView = (TextView) v.findViewById(R.id.textView);
            TextView textView2 = (TextView) v.findViewById(R.id.textView2);
            TextView textView3 = (TextView) v.findViewById(R.id.textView3);
            TextView textView4 = (TextView) v.findViewById(R.id.textView4);

            textView.setText(data.getToiletName());
            textView2.setText(data.getAddrRoad());
            textView3.setText("남성용 : ("+data.getMcloset()+"개)");
            textView4.setText("여성용 : ("+data.getWcloset()+"개)");
        //}

            return v;
        }
    }
