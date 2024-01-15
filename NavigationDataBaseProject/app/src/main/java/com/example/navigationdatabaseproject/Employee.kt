package com.example.navigationdatabaseproject

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import javax.annotation.Nonnull


@Parcelize
@Entity(tableName = "employees")
data class Employee(

    @PrimaryKey(autoGenerate = false)
    @Nonnull
    @ColumnInfo(name = "id")
    var id : Int,

    @ColumnInfo(name = "employeeId")
    var employeId:Long,

    @ColumnInfo(name = "employeName")
    var employeeName :String,

    @ColumnInfo(name = "designation")
    var empDesignation :String,

    @ColumnInfo(name = "Experience")
    var empExperience : Float,

    @ColumnInfo(name = "email")
    var empEmail : String,

    @ColumnInfo(name = "phoneNumber")
    var empPhNo :Long

) : Parcelable
