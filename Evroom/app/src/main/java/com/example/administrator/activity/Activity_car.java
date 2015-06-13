package com.example.administrator.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.R;


public class Activity_car extends ActionBarActivity {

    Button btn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_car);

        btn = (Button) findViewById(R.id.Text1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Activity_car.this, Activity_content_car.class);
                startActivity(it);}
        });





    }




}