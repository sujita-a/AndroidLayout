package edu.tu.androidlayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    String TAG=LifeCycleActivity.class.getName();
    String email,password;
    EditText etEmail,etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail=(EditText)findViewById(R.id.login_et_email);
        etPassword=(EditText)findViewById(R.id.login_et_password);
        btnLogin=(Button) findViewById(R.id.login_btn_login);
        TextView tvSignup = (TextView)findViewById(R.id.login_tv_signin);
        Log.d(TAG, "onCreate: Login Created Activity");
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);//I am making an a reference/object from moving one to another activity
                intent.putExtra("name","Sujita");//passing some data through this object
                intent.putExtra("age", 32);
                intent.putExtra("address", "Pashupatinath, Gaushala");

                //startActivity(intent); //Simple call, not expecting anything back from child.
                //finish();//this entire login activity will remove from stack, bcoz I have no role to play.//finishing this LoginActivity page on pressing back button(call from OS) on RegisterActivity, this wont be there.
                startActivityForResult(intent,100);//I am making a call to my child and is expecting data from child.
            }
        });



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=etEmail.getText().toString().trim();
                password=etPassword.getText().toString().trim();

                Log.d(TAG, "onClick:  email "+email);
                Log.d(TAG, "onClick: password "+password);

                Toast.makeText(LoginActivity.this, "Email :"+email+" password "+password, Toast.LENGTH_LONG).show();



            }
        });
    }

    @Override//this code below is receiving data from child i.e.RegisterActivity when we have made a call [startActivityForResult(intent,100)]and is expecting some result.
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode " +requestCode);
        Log.d(TAG, "onActivityResult: resultCode " +resultCode);
        Log.d(TAG, "onActivityResult: value/data " +data.getData());
        Log.d(TAG, "onActivityResult: name " +data.getStringExtra("name"));
        Log.d(TAG, "onActivityResult: age " +data.getIntExtra("age", 0));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Login We started Activity Life Cycle.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Login We stopped Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Login We destroyed Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Login We Resumed activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: Login Activity Restarted");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause:  Login Activity Paused");
    }
}