package edu.tu.androidlayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.tu.androidlayout.R;
import edu.tu.androidlayout.model.Student;
import edu.tu.androidlayout.viewholder.MyViewHolder;

public class StudentAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Student> myStudentList;
    private Context myContext;

    public StudentAdapter(Context myContext, List<Student> myStudentList) {
        this.myStudentList = myStudentList;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This method is used to create a view and pass as a parameter to viewholder(Your own defined viewholder)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_display_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        //Take an object based on a position and bind the data to the view.
        final Student student = myStudentList.get(position);
        holder.tvName.setText(student.getName());
        holder.tvSalary.setText(student.getSalary());
        holder.tvPhone.setText(student.getMobile());
        holder.tvEmail.setText(student.getEmail());
        holder.tvAddress.setText(student.getAddress());
        /*holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(myContext, "Clicked " + (position+1), Toast.LENGTH_SHORT).show();
            }
        });*/
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(myContext, student.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //This method will return the size of the data available in adapter
        return myStudentList.size();
    }
}


