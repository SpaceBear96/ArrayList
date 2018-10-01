package com.tecsup.spacebear.arraylist;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DescriptionActivity extends AppCompatActivity {

    private static final String TAG = "DescriptionActivity";
    public String num="",correo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        TextView incomingData = (TextView) findViewById(R.id.etIncomingData);
        Intent incomingIntent = getIntent();
        String incomingName = incomingIntent.getStringExtra("name");
        Log.d(TAG, "onCreate: Found incoming name: " + incomingName);

        incomingData.setText(incomingName);
    }
}
