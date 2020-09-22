package edu.tu.androidlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifeCycleActivity extends AppCompatActivity {

    String TAG = LifeCycleActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d(TAG, "onCreate: A We created our activity");
        Button activityLogin = (Button)findViewById(R.id.activitylogin);
        activityLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LifeCycleActivity.this,LoginActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: A We started Activity Life Cycle.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: A We stopped Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: A We destroyed Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: A We Resumed activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: A Activity Restarted");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: A Activity Paused");
    }
}