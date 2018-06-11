package rajan5787.tikuraja.androidfirebaseexample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText edtUsername, edtPassowrd;
    Button btnSignup;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        edtUsername = findViewById(R.id.edt_username);
        edtPassowrd = findViewById(R.id.edt_password);
        btnSignup = findViewById(R.id.btn_signup);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edtUsername.getText().toString();
                String password = edtPassowrd.getText().toString();


                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUp.this,
                                new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        if (!task.isSuccessful()) {
                                            Toast.makeText(SignUp.this, "Authentication failed." ,
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            Toast.makeText(SignUp.this, "create User With Email",
                                                    Toast.LENGTH_SHORT).show();
                                            finish();
                                            overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
                                        }
                                    }
                                });
            }
        });

    }
}
