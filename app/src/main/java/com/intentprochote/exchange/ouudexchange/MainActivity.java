package com.intentprochote.exchange.ouudexchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.intentprochote.exchange.ouudexchange.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Add Fragment to Activity
        //ifcause boolean if (boolean) {True}
        if (savedInstanceState == null){getSupportFragmentManager()
        .beginTransaction()
        .add(R.id.ContentMainFragment, new MainFragment())
        .commit();}//if True

    } //Main Method (onCreate ทำงานก่อนเสมอ)
} //Main Class
