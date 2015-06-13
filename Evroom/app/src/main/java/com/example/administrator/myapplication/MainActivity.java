package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends FragmentActivity implements TabHost.OnTabChangeListener {
    private TabHost tabHost;
    private int lastPosition;
    private boolean isExit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lastPosition = -1;
        setContentView(R.layout.activity_main);
        tabsInit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        if (getIntent() != null) {
            super.onRestoreInstanceState(savedInstanceState);
        } else {
            Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage
                    (getBaseContext().getPackageName());
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }
    }

    public void tabsInit() {
        View tab1 = getLayoutInflater().inflate(R.layout.tab_view, null);
        ImageView icon = (ImageView) tab1.findViewById(R.id.icon);
        icon.setImageResource(R.drawable.icon_main_menu1);
        TextView text = (TextView) tab1.findViewById(R.id.text);
        text.setText(R.string.label_main_menu1);
        View tab2 = getLayoutInflater().inflate(R.layout.tab_view, null);
        icon = (ImageView) tab2.findViewById(R.id.icon);
        icon.setImageResource(R.drawable.icon_main_menu2);
        text = (TextView) tab2.findViewById(R.id.text);
        text.setText(R.string.label_main_menu2);
        View tab3 = getLayoutInflater().inflate(R.layout.tab_view, null);
        icon = (ImageView) tab3.findViewById(R.id.icon);
        icon.setImageResource(R.drawable.icon_main_menu3);
        text = (TextView) tab3.findViewById(R.id.text);
        text.setText(R.string.label_main_menu3);
        View tab4 = getLayoutInflater().inflate(R.layout.tab_view, null);
        icon = (ImageView) tab4.findViewById(R.id.icon);
        icon.setImageResource(R.drawable.icon_main_menu4);
        text = (TextView) tab4.findViewById(R.id.text);
        text.setText(R.string.label_main_menu4);
            tabHost = (TabHost) findViewById(android.R.id.tabhost);
            tabHost.setOnTabChangedListener(this);
            tabHost.setup();
            tabHost.addTab(tabHost.newTabSpec("eventFragment").setIndicator(tab1)
                    .setContent(R.id.tab1));
            tabHost.addTab(tabHost.newTabSpec("mapFragment").setIndicator(tab2)
                    .setContent(R.id.tab2));
            tabHost.addTab(tabHost.newTabSpec("messageFragment").setIndicator(tab3)
                    .setContent(R.id.tab3));
            tabHost.addTab(tabHost.newTabSpec("carFragment").setIndicator(tab4)
                    .setContent(R.id.tab4));
    }

    public void seleteChange(int position) {
        if (lastPosition != position) {
            lastPosition = position;
        } else {
            return;
        }
        FragmentManager fm = getSupportFragmentManager();
        EventFragment eventFragment = (EventFragment) fm
                .findFragmentByTag("eventFragment");
        MapFragment mapFragment = (MapFragment) fm
                .findFragmentByTag("mapFragment");
        MessageFragment messageFragment = (MessageFragment) fm
                .findFragmentByTag("messageFragment");
        CarFragment carFragment = (CarFragment) fm
                .findFragmentByTag("carFragment");
        FragmentTransaction ft = fm.beginTransaction();
        if (eventFragment != null && !eventFragment.isHidden())
            ft.hide(eventFragment);
        if (mapFragment != null && !mapFragment.isHidden())
            ft.hide(mapFragment);
        if (messageFragment != null && !messageFragment.isHidden())
            ft.hide(messageFragment);
        if (carFragment != null && !carFragment.isHidden())
            ft.hide(carFragment);
        switch (position) {
            case 0:
                if (eventFragment == null) {
                    ft.add(R.id.realtabcontent, EventFragment.newInstance(),
                            "eventFragment");
                } else {
                    ft.show(eventFragment);
                }
                break;
            case 1:
                if (mapFragment == null) {
                    ft.add(R.id.realtabcontent, MapFragment.newInstance(),
                            "mapFragment");
                } else {
                    ft.show(mapFragment);
                }
                break;
               case 2:
                if (messageFragment == null) {
                    ft.add(R.id.realtabcontent, MessageFragment.newInstance(),
                            "messageFragment");
                } else {
                    ft.show(messageFragment);
                }
                break;
            case 3:
                if (carFragment == null) {
                    ft.add(R.id.realtabcontent, CarFragment.newInstance(),
                            "carFragment");
                } else {
                    ft.show(carFragment);
                }
                break;
            default:
                break;
        }
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        exitBy2Click();
    }

    private void exitBy2Click() {
        Timer tExit;
        if (!isExit) {
            isExit = true;
            Toast.makeText(this, R.string.label_quit, Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);

        } else {
            finish();
        }
    }

    @Override
    public void onTabChanged(String tabId) {
        if (!JSONUtil.isEmpty(tabId)) {
            switch (tabId) {
                case "eventFragment":
                    seleteChange(0);
                    break;
                case "mapFragment":
                    seleteChange(1);
                    break;
                case "messageFragment":
                    seleteChange(2);
                    break;
                case "carFragment":
                    seleteChange(3);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
