package com.example.administrator.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.administrator.R;

public class Activity_eventlist extends ActionBarActivity {
    ImageButton chat;
    ImageButton map;
    ImageButton car;
    Button event1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_event);

    event1 = (Button) findViewById(R.id.Text1);
    event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Activity_eventlist.this, Activity_content_event.class);
                startActivity(it);}
    });



         }





    }

