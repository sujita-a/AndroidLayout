package edu.tu.androidlayout.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.tu.androidlayout.model.Database;
import edu.tu.androidlayout.R;
import edu.tu.androidlayout.model.Student;

public class RegisterActivity extends AppCompatActivity {

    String TAG = LifeCycleActivity.class.getName();
    private EditText etName, etAddress, etMobile, etEmail, etSalary, etPassword, etRePassword;
    private Button btnRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final String name = getIntent().getStringExtra("name");//getting the value from another activity i.e. LoginActivity with a key "name".
        Log.d(TAG, "onCreate: " + name);//displaying it through Log
        int age =getIntent().getIntExtra("age",0);
        Log.d(TAG, "onCreate: "+ age );



        etName = (EditText) findViewById(R.id.reg_et_name);
        etAddress = (EditText) findViewById(R.id.reg_et_address);
        etMobile = (EditText) findViewById(R.id.reg_et_mobile);
        etEmail = (EditText) findViewById(R.id.reg_et_email);
        etSalary = (EditText) findViewById(R.id.reg_et_salary);
        etPassword = (EditText) findViewById(R.id.reg_et_password);
        etRePassword = (EditText) findViewById(R.id.reg_et_repassword);
        btnRegister = (Button) findViewById(R.id.reg_btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
                /*Intent intent =new Intent();
                intent.putExtra("name", "Paul");
                intent.putExtra("age", 25);
                setResult(RESULT_OK, intent);
                finish();*/

            }
        });

    }

    private void showToast(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void validation() {
        String name = etName.getText().toString();
        String address = etAddress.getText().toString();
        String mobile = etMobile.getText().toString();
        String email = etEmail.getText().toString();
        String salary = etSalary.getText().toString();
        String password = etPassword.getText().toString();
        String repassword = etRePassword.getText().toString();

        if(TextUtils.isEmpty(name)){
            showToast("Enter your Name");
            etName.requestFocus();
        }
        else if(TextUtils.isEmpty(address)){
            showToast("Enter address");
            etAddress.requestFocus();
        }
        else if(TextUtils.isEmpty(mobile)){
            showToast("Enter Mobile");
            etMobile.requestFocus();
        }
        else if(TextUtils.isEmpty(email)){
            showToast("Enter Email");
            etEmail.requestFocus();
        }
        else if(TextUtils.isEmpty(salary)){
            showToast("Enter Salary");
            etSalary.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            showToast("Enter Password");
            etPassword.requestFocus();
        }
        else if(TextUtils.isEmpty(repassword)){
            showToast("Enter Repassword");
            etRePassword.requestFocus();
        }
        else if (!password.equals(repassword)){
            showToast("Password MissMatch");
        }
        else {
            Student student = new Student();
            student.setName(name);
            student.setAddress(address);
            student.setMobile(mobile);
            student.setEmail(email);
            student.setSalary(salary);
            student.setPassword(password);

            Database db =new Database(RegisterActivity.this);
            int i = db.addValue(student);
            if (i != -1){
                showToast("Successfully Registered");
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

        }



    }


}