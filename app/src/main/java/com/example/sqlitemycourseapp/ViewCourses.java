package com.example.sqlitemycourseapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewCourses extends AppCompatActivity {
    // creating variables for our array list,
    // dbhandler, adapter and recycler view.

    private ArrayList<CourseModal> courseModalArrayList;
    private DBHandler dbHandler;
    private CourseRVAdapter courseRVAdapter;
    private RecyclerView coursesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);
        // initializing our all variables.
        courseModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewCourses.this);

        // getting our course array
        // list from db handler class.
        courseModalArrayList = dbHandler.readCourses();

        coursesRV = findViewById(R.id.idRVCourses);
        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCourses.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // on below line passing our array lost to our adapter class.
        courseRVAdapter = new CourseRVAdapter(courseModalArrayList, ViewCourses.this);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(courseRVAdapter);
    }
}