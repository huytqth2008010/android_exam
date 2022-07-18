package com.example.android_exam;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert
    long addEmployee(Employee employee);

    @Update
    int updateEmployee(Employee employee);

    @Delete
    int deleteEmployee(Employee employee);

    @Query("Select * from employee where id =:id")
    Employee findEmployee(int id);


    @Query("Select * from employee")
    List<Employee> getAllEmployee();
}
