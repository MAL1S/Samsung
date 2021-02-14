package com.mdev.formyitequation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {
    EditText loginEdit, passwordEdit;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        button = (Button)findViewById(R.id.button1);
        loginEdit = (EditText)findViewById(R.id.login1);
        passwordEdit = (EditText)findViewById(R.id.password1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!loginEdit.getText().toString().equals("") && !passwordEdit.getText().toString().equals("")) {
                    Intent i = new Intent();
                    i.putExtra("loginValue", loginEdit.getText().toString());
                    i.putExtra("passwordValue", passwordEdit.getText().toString());
                    setResult(RESULT_OK, i);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), getApplicationContext().getText(R.string.missingField), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
