package edu.tu.androidlayout.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.tu.androidlayout.Helper;
import edu.tu.androidlayout.R;
import edu.tu.androidlayout.activity.HomeActivity;
import edu.tu.androidlayout.activity.LifeCycleActivity;
import edu.tu.androidlayout.activity.LoginActivity;
import edu.tu.androidlayout.activity.RegisterActivity;
import edu.tu.androidlayout.model.Database;
import edu.tu.androidlayout.model.Student;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddStudentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddStudentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String TAG = LifeCycleActivity.class.getName();
    private EditText etName, etAddress, etMobile, etEmail, etSalary;
    private Button btnAdd;

    public AddStudentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddStudentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddStudentFragment newInstance(String param1, String param2) {
        AddStudentFragment fragment = new AddStudentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);
        etName = view.findViewById(R.id.et_name);
        etAddress =view.findViewById(R.id.et_address);
        etMobile = view.findViewById(R.id.et_phone);
        etEmail = view.findViewById(R.id.et_email);
        etSalary = view.findViewById(R.id.et_salary);
        btnAdd = view.findViewById(R.id.btn_fr_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });
        return view;
    }
    private void validation() {
        Helper.hideKeyPad(getActivity());
        String name = etName.getText().toString();
        String address = etAddress.getText().toString();
        String mobile = etMobile.getText().toString();
        String email = etEmail.getText().toString();
        String salary = etSalary.getText().toString();


        if (TextUtils.isEmpty(name)) {
            showToast("Enter your Name");
            etName.requestFocus();
        } else if (TextUtils.isEmpty(address)) {
            showToast("Enter address");
            etAddress.requestFocus();
        } else if (TextUtils.isEmpty(mobile)) {
            showToast("Enter Mobile");
            etMobile.requestFocus();
        } else if (TextUtils.isEmpty(email)) {
            showToast("Enter Email");
            etEmail.requestFocus();
        } else if (TextUtils.isEmpty(salary)) {
            showToast("Enter Salary");
            etSalary.requestFocus();
        } else {
            Student student = new Student();
            student.setName(name);
            student.setAddress(address);
            student.setMobile(mobile);
            student.setEmail(email);
            student.setSalary(salary);


            Database db = new Database(getContext());
            int i = db.addValue(student);
            if (i == -1) {
                showToast("Error Occured ");

            }
            else if(i == -2){
                showToast("Mobile Number already exists ");
            }
            else{
                showToast("Successfully Added ");
                etName.setText("");
                etAddress.setText("");
                etMobile.setText("");
                etSalary.setText("");
                etEmail.setText("");
            }

        }
    }
    private void showToast(String msg){
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}