package com.example.navigationdatabaseproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface EmployeeDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEmployee(employee: Employee)

    @Query("SELECT * FROM employees WHERE employeeId = :empId")
    fun findEmployeeById(empId: String) :Employee

    @Query("SELECT * FROM employees")
    fun getAllEmployees(): List<Employee>

    @Update
    suspend fun updateEmployeeDetails(employee: Employee)

    @Delete
    suspend fun deleteEmployee(employee: Employee)
}