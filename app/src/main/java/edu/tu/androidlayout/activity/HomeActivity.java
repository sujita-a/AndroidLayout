package edu.tu.androidlayout.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.admin.FactoryResetProtectionPolicy;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import edu.tu.androidlayout.R;
import edu.tu.androidlayout.fragment.AddStudentFragment;
import edu.tu.androidlayout.fragment.DeleteFragment;
import edu.tu.androidlayout.fragment.DisplayFragment;

public class HomeActivity extends AppCompatActivity {

    private Button btnAdd, btnDelete, btnUpdate, btnDisplay;
    private LinearLayout fragmentlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Home");
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
        /*AddStudentFragment addstudentfragment = new AddStudentFragment();
        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_layout,addstudentfragment);
        ft.commit();*/
        addFragment(new AddStudentFragment());
    }

    private void updateStudent(){

    }

    private void deleteStudent(){
        DeleteFragment dltfragment = DeleteFragment.newInstance(" ", " ");
        dltfragment.show(getSupportFragmentManager(),dltfragment.getTag());
    }

    private void displayStudent(){
        DisplayFragment displayfragment = new DisplayFragment();
        /*FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_layout,displayfragmant);
        ft.commit();*/
        addFragment(displayfragment);
    }

     private void addFragment(Fragment fr){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,fr).commit();
    }
}