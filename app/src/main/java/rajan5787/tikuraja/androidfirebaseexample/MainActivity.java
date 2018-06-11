package rajan5787.tikuraja.androidfirebaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private ArrayList<Student> studentArrayList;
    private RecyclerView recyclerView;
    private StudentAdapter mAdapter;
    private Button btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        studentArrayList = new ArrayList<>();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        btnPlus = findViewById(R.id.btn_plus);

        mAdapter = new StudentAdapter(studentArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        getStudentData();

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),AddUser.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_main, R.anim.slide_out_main);

            }
        });

    }

    private void getStudentData() {

        Query query = mDatabase.child("students");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue()!=null) {

                    HashMap<String, Object> studentList = (HashMap<String, Object>) dataSnapshot.getValue();

                    Log.d("rfrf",dataSnapshot.toString());

                    for (String key : studentList.keySet()) {
                        Object object = studentList.get(key);
                        HashMap<String, Object> studentMap = (HashMap<String, Object>) object;
                        Log.d("rfrf",object.toString());

                        Student item_student = new Student();
                        item_student.setName(String.valueOf(studentMap.get("name")));
                        item_student.setEmail(String.valueOf(studentMap.get("email")));
                        item_student.setNumber(String.valueOf(studentMap.get("number")));
                        item_student.setStandard(String.valueOf(studentMap.get("standard")));
                        studentArrayList.add(item_student);
                    }

                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
