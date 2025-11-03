package com.example.a2211_levietdat_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static class Student {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

        private List<Student> students;
        private AppCompatActivity activity;

        public StudentAdapter(AppCompatActivity activity, List<Student> students) {
            this.activity = activity;
            this.students = students;
        }

        @Override
        public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_student, parent, false);
            return new StudentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(StudentViewHolder holder, int position) {
            Student s = students.get(position);
            holder.txtName.setText(s.name);
            holder.txtAge.setText("Tuổi: " + s.age);

            holder.itemView.setOnClickListener(v ->
                    Toast.makeText(activity, "Bạn chọn: " + s.name + " (" + s.age + " tuổi)", Toast.LENGTH_SHORT).show());
        }

        @Override
        public int getItemCount() {
            return students.size();
        }

        public static class StudentViewHolder extends RecyclerView.ViewHolder {
            TextView txtName, txtAge;
            ImageView imgAvatar;

            public StudentViewHolder(View itemView) {
                super(itemView);
                txtName = itemView.findViewById(R.id.txtName);
                txtAge = itemView.findViewById(R.id.txtAge);
                imgAvatar = itemView.findViewById(R.id.imgAvatar);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewStudents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Student> students = new ArrayList<>();
        students.add(new Student("Nghuyễn Nho Trường Phát", 20));
        students.add(new Student("Lê Minh Hoàng", 21));
        students.add(new Student("Nguyễn Thị Trang", 22));
        students.add(new Student("Lê Viết Đạt", 23));
        students.add(new Student("Trần Huy", 24));
        students.add(new Student("Hà Thùy Linh", 25));
        students.add(new Student("Lê Viết An", 26));
        students.add(new Student("Lê Thị Thảo", 27));

        StudentAdapter adapter = new StudentAdapter(this, students);
        recyclerView.setAdapter(adapter);
    }
}
