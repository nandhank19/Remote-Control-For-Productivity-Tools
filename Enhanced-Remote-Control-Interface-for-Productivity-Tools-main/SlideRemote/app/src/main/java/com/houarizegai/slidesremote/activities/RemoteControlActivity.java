package com.houarizegai.slidesremote.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.houarizegai.slidesremote.R;
import com.houarizegai.slidesremote.network.SocketClient;

public class RemoteControlActivity extends AppCompatActivity {

    private CardView  cardStart, cardStop, cardNext, cardPrevious, cardZoomIn, cardZoomOut, cardUpArrow, cardDownArrow;

    private String serverIP;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_control);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        if (intent != null) {
            serverIP = intent.getStringExtra("serverIP");
            Log.d("SERVER_IP", serverIP);
        }

        initViews();
    }

    private void initViews() {

        cardStart = findViewById(R.id.cardStart);
        cardStop = findViewById(R.id.cardStop);
        cardNext = findViewById(R.id.cardNext);
        cardPrevious = findViewById(R.id.cardPrevious);
        cardZoomIn = findViewById(R.id.cardZoomIn);
        cardZoomOut = findViewById(R.id.cardZoomOut);
        cardUpArrow = findViewById(R.id.cardUpArrow);
        cardDownArrow = findViewById(R.id.cardDownArrow);




        cardStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SocketClient(serverIP).execute("START");
            }
        });

        cardStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SocketClient(serverIP).execute("STOP");
            }
        });

        cardNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SocketClient(serverIP).execute("NEXT");
            }
        });

        cardPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SocketClient(serverIP).execute("PREVIOUS");
            }
        });

        cardUpArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add action for the up arrow
                new SocketClient(serverIP).execute("UP_ARROW");
            }
        });

        cardDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add action for the down arrow
                new SocketClient(serverIP).execute("DOWN_ARROW");
            }
        });

        cardZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SocketClient(serverIP).execute("ZOOM_IN");

            }
        });

        cardZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SocketClient(serverIP).execute("ZOOM_OUT");

            }
        });
    }
}
