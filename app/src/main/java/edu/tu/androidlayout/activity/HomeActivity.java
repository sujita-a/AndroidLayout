package edu.tu.androidlayout.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.tu.androidlayout.R;
import edu.tu.androidlayout.fragment.DeleteFragment;

public class HomeActivity extends AppCompatActivity {

    private Button btnAdd, btnDelete, btnUpdate, btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnAdd = (Button) findViewById(R.id.btn_addstudent);
        btnDelete = (Button) findViewById(R.id.btn_deletestudentrecord);
        btnUpdate = (Button) findViewById(R.id.btn_updatestudent);
        btnDisplay= (Button) findViewById(R.id.btn_displaydetails);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudent();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteStudent();
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayStudent();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStudent();
            }
        });


    }

    private void addStudent(){

    }

    private void updateStudent(){

    }

    private void deleteStudent(){
        DeleteFragment dltfragment = DeleteFragment.newInstance(" ", " ");
        dltfragment.show(getSupportFragmentManager(),dltfragment.getTag());
    }

    private void displayStudent(){

    }
}