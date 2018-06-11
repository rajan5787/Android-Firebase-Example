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

public class Login extends AppCompatActivity {


    EditText edtUsername, edtPassowrd;
    Button btnLogin;
    TextView txtSignup;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        edtUsername = findViewById(R.id.edt_username);
        edtPassowrd = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        txtSignup = findViewById(R.id.txt_signup);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edtUsername.getText().toString();
                String password = edtPassowrd.getText().toString();


                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this,
                                new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        if (!task.isSuccessful()) {
                                            Toast.makeText(Login.this, "Login Failed",
                                                    Toast.LENGTH_LONG).show();
                                        } else {
                                            Intent intent = new Intent(Login.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                            overridePendingTransition(R.anim.slide_in_main, R.anim.slide_out_main);
                                        }
                                    }
                                });
            }
        });

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_main, R.anim.slide_out_main);

            }
        });

    }
}