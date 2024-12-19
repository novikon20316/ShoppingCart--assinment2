package com.example.fragmentapplication.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.Navigation;

import com.example.fragmentapplication.R;
import com.example.fragmentapplication.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mAuth = FirebaseAuth.getInstance();
    }
    public void login(View view) {

        String email = ((EditText) findViewById(R.id.etLoginEmail)).getText().toString();
        String password = ((EditText) findViewById(R.id.etLoginPass)).getText().toString();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivity.this, "Email or Password are empty. Please fill them", Toast.LENGTH_LONG).show();
        } else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login successfull", Toast.LENGTH_LONG).show();
                                Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_fragmentThree);

                            } else {
                                Toast.makeText(MainActivity.this, "login Failed", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
    public void register(View view){
        String email = ((EditText)findViewById(R.id.etEmail)).getText().toString();
        String password = ((EditText)findViewById(R.id.etPass)).getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            writeData();
                            Navigation.findNavController((view)).navigate(R.id.action_fragmentTwo_to_fragmentOne);
                            Toast.makeText(MainActivity.this,"Register successfull",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,"Register Failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void writeData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String Name = ((EditText)findViewById(R.id.etName)).getText().toString();
        String Email = ((EditText)findViewById(R.id.etEmail)).getText().toString();
        String Phone = ((EditText)findViewById(R.id.etPhone)).getText().toString();
        FirebaseUser userbase = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference myRef = database.getReference("users").child(userbase.getUid());
        User user = new User(Name,Email,Phone);

        myRef.setValue(user);
    }

    public void readData(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(currentUser.getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                User value = dataSnapshot.getValue(User.class);
                Toast.makeText(MainActivity.this,value.getName(),Toast.LENGTH_LONG).show();
                TextView tv = findViewById(R.id.tvShowName);
                tv.setText("Hello " + value.getName());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }
}