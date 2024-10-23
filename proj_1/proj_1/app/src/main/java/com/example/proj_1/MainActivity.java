package com.example.proj_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextPhone;
    private EditText editTextEmail;
    private Button buttonSimple;
    private Button buttonFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSimple = findViewById(R.id.buttonSimple);
        buttonFull = findViewById(R.id.buttonFull);

        buttonSimple.setOnClickListener(v -> generateBusinessCard(true));
        buttonFull.setOnClickListener(v -> generateBusinessCard(false));
    }

    private void generateBusinessCard(boolean isSimple) {
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        if (firstName.isEmpty() || lastName.isEmpty()) {
            editTextFirstName.setError("Imię jest wymagane");
            editTextLastName.setError("Nazwisko jest wymagane");
            return;
        }

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("FIRST_NAME", firstName);
        intent.putExtra("LAST_NAME", lastName);
        intent.putExtra("IS_SIMPLE", isSimple);
        if (!isSimple) {
            intent.putExtra("PHONE", phone);
            intent.putExtra("EMAIL", email);
        }
        startActivity(intent);
    }
}