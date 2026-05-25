package com.example.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private final Context context;
    private final List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);

        holder.tvName.setText(student.getName());
        holder.tvRollNumber.setText("Roll No: " + student.getRollNumber());
        holder.tvDepartment.setText("Dept: " + student.getDepartment());
        holder.tvGrade.setText(student.getGrade());

        switch (student.getGrade()) {
            case "A":
                holder.tvGrade.setBackgroundResource(R.drawable.grade_badge_green);
                break;
            case "B":
                holder.tvGrade.setBackgroundResource(R.drawable.grade_badge_blue);
                break;
            case "C":
                holder.tvGrade.setBackgroundResource(R.drawable.grade_badge_orange);
                break;
            default:
                holder.tvGrade.setBackgroundResource(R.drawable.grade_badge_red);
                break;
        }

        holder.itemView.setOnClickListener(v -> Toast.makeText(
                context,
                "Selected: " + student.getName(),
                Toast.LENGTH_SHORT
        ).show());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvRollNumber, tvDepartment, tvGrade;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvRollNumber = itemView.findViewById(R.id.tvRollNumber);
            tvDepartment = itemView.findViewById(R.id.tvDepartment);
            tvGrade = itemView.findViewById(R.id.tvGrade);
        }
    }
}
