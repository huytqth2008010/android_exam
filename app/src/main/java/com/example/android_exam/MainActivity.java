package com.example.android_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView edName, edDes, edSalary;
    Button btAdd, btUpdate, btDelete;
    RecyclerView ListEmployee;
    AppDatabase appDatabase;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.getAppDatabase(this);

        edDes = findViewById(R.id.edDes);
        edName = findViewById(R.id.edName);
        edSalary = findViewById(R.id.edSalary);

        ListEmployee = findViewById(R.id.ListEmployee);

        btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(this);

        btUpdate = findViewById(R.id.btUpdate);
        btDelete = findViewById(R.id.btDelete);

        List<Employee> list = appDatabase.employeeDao().getAllEmployee();
        EmployeeAdapter adapter = new EmployeeAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        ListEmployee.setLayoutManager(layoutManager);
        ListEmployee.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btAdd:
                addEmployee();
                break;
            case R.id.btUpdate:
                updateEmployee();
                break;
            case R.id.btDelete:
                deleteEmployee();
                break;
            default:
                break;
        }
    }

    private void addEmployee() {
        Toast.makeText(this,"Add",Toast.LENGTH_SHORT).show();
        Employee employee = new Employee();
        employee.name = edName.getText().toString();
        employee.designation = edDes.getText().toString();
        employee.salary = Integer.parseInt(edSalary.getText().toString());

        long id = appDatabase.employeeDao().addEmployee(employee);
        if (id > 0 ){
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
        }
    }

    private void updateEmployee() {
        if (employee == null) {
            Toast.makeText(this, "No Employee", Toast.LENGTH_SHORT).show();
        }
        if (appDatabase.employeeDao().updateEmployee(employee) > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            employee = null;
        }
    }

    private void deleteEmployee() {
        if (employee == null) {
            Toast.makeText(this, "No Employee", Toast.LENGTH_SHORT).show();
        }
        if (appDatabase.employeeDao().deleteEmployee(employee) > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            employee = null;
        }
    }
}