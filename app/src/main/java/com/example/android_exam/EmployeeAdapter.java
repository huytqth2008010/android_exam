package com.example.android_exam;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter{
    Activity activity;
    List<Employee> employeeList;

    public EmployeeAdapter(Activity activity, List<Employee> employeeList) {
        this.activity = activity;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_list, parent, false);
        EmployeeHolder holder = new EmployeeHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHolder vh = (EmployeeHolder) holder;
        Employee model = employeeList.get(position);
        vh.item_name.setText(model.name);
        vh.item_des.setText(model.designation);
        vh.item_salary.setText(model.salary);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    private class EmployeeHolder extends RecyclerView.ViewHolder {
        TextView item_name, item_des, item_salary;
        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_des = itemView.findViewById(R.id.item_des);
            item_salary = itemView.findViewById(R.id.item_salary);
        }
    }
}
