package rajan5787.tikuraja.androidfirebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddUser extends AppCompatActivity {


    EditText name, standard, number, email;
    Button btn_add;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        name = findViewById(R.id.edt_name);
        standard = findViewById(R.id.edt_standard);
        number = findViewById(R.id.edt_number);
        email = findViewById(R.id.edt_email);
        btn_add = findViewById(R.id.btn_add);

        mDatabase = FirebaseDatabase.getInstance().getReference("students");

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating new student node, which returns the unique key value
                // new student node would be users => $userid
                String userId = mDatabase.push().getKey();

                // creating new student object
                Student user = new Student(name.getText().toString(),email.getText().toString(),
                        standard.getText().toString(),number.getText().toString());

                // pushing student to 'students' node using the studentId
                mDatabase.child(userId).setValue(user);

                finish();
                overridePendingTransition(R.anim.slide_out, R.anim.slide_in);


            }
        });
    }
}
