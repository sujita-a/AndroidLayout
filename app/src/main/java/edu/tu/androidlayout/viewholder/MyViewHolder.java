package edu.tu.androidlayout.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.tu.androidlayout.R;

public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView tvName, tvSalary, tvPhone, tvEmail, tvAddress;
    public LinearLayout parentLayout;
    //In this constructor, we are accepting a view as a parameter and and making reference of all the view present there
    public MyViewHolder(@NonNull final View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_name);
        tvSalary = itemView.findViewById(R.id.tv_salary);
        tvPhone = itemView.findViewById(R.id.tv_phone);
        tvEmail = itemView.findViewById(R.id.tv_email);
        tvAddress = itemView.findViewById(R.id.tv_address);
        parentLayout = itemView.findViewById(R.id.linear_root);
       /* parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), "Clicked from myViewHolder", Toast.LENGTH_SHORT).show();
            }
        });*/
    }


}
