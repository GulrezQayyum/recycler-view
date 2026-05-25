package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;
    private List<Student> filteredList;
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        etSearch = findViewById(R.id.etSearch);

        studentList = getSampleStudents();
        filteredList = new ArrayList<>(studentList);

        studentAdapter = new StudentAdapter(this, filteredList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterStudents(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void filterStudents(String query) {

        filteredList.clear();

        if (query.isEmpty()) {
            filteredList.addAll(studentList);
        } else {

            String lowerQuery = query.toLowerCase();

            for (Student student : studentList) {

                if (student.getName().toLowerCase().contains(lowerQuery)
                        || student.getDepartment().toLowerCase().contains(lowerQuery)
                        || student.getRollNumber().toLowerCase().contains(lowerQuery)) {

                    filteredList.add(student);
                }
            }
        }

        studentAdapter.notifyDataSetChanged();
    }

    private List<Student> getSampleStudents() {

        List<Student> list = new ArrayList<>();

        list.add(new Student("Ali Hassan", "CS-2021-01", "Computer Science", "A"));
        list.add(new Student("Fatima Zahra", "CS-2021-02", "Computer Science", "A"));
        list.add(new Student("Usman Tariq", "EE-2021-03", "Electrical Eng.", "B"));
        list.add(new Student("Ayesha Malik", "ME-2021-04", "Mechanical Eng.", "A"));
        list.add(new Student("Bilal Ahmed", "CS-2021-05", "Computer Science", "C"));
        list.add(new Student("Sara Khan", "SE-2021-06", "Software Eng.", "B"));
        list.add(new Student("Hamza Iqbal", "EE-2021-07", "Electrical Eng.", "A"));
        list.add(new Student("Zara Hussain", "CS-2021-08", "Computer Science", "B"));
        list.add(new Student("Omar Farooq", "ME-2021-09", "Mechanical Eng.", "C"));
        list.add(new Student("Hina Baig", "SE-2021-10", "Software Eng.", "A"));

        return list;
    }
}
