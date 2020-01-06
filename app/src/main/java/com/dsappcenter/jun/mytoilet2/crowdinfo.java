package com.dsappcenter.jun.mytoilet2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Junsik on 2017-12-28.
 */

public class crowdinfo extends Dialog {

    TextView suggest, cancel;
    View.OnClickListener suggestListener;
    View.OnClickListener cancelListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        WindowManager.LayoutParams windows = new WindowManager.LayoutParams();
        windows.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        windows.dimAmount = 0.8f;
        windows.width=1000;
        windows.height=1400;
        getWindow().setAttributes(windows);

        setContentView(R.layout.crowd_dialog);

        suggest = (TextView)findViewById(R.id.suggestion);
        cancel = (TextView)findViewById(R.id.cancel);

        if(suggestListener != null && cancelListener != null){
            suggest.setOnClickListener(suggestListener);
            cancel.setOnClickListener(cancelListener);
        }else if(suggestListener != null && cancelListener == null){
            suggest.setOnClickListener(suggestListener);
        }else{

        }

        }

    public crowdinfo(Context context, View.OnClickListener suggestListener, View.OnClickListener cancelListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.suggestListener = suggestListener;
        this.cancelListener = cancelListener;
    }

    }

