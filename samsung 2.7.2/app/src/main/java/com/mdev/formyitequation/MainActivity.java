package com.mdev.formyitequation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String positiveAnswer,
            negativeAnswer,
            loginText,
            passwordText;
    EditText loginEdit, passwordEdit;
    Button button;
    TextView txt;
    final private int ind = 0;
    List<String> loginList = new ArrayList<>();
    List<String> passwordList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        loginEdit = (EditText)findViewById(R.id.login);
        passwordEdit = (EditText)findViewById(R.id.password);
        txt = (TextView)findViewById(R.id.textResult);
        txt.setText("");
        loginList.add(getApplicationContext().getString(R.string.login));
        passwordList.add(getApplicationContext().getString(R.string.password));
        positiveAnswer = getApplicationContext().getString(R.string.positiveAnswer);
        negativeAnswer = getApplicationContext().getString(R.string.negativeAnswer);

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginText = loginEdit.getText().toString();
                passwordText = passwordEdit.getText().toString();
                if (loginEdit.getText().toString().equals("") || passwordEdit.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), getApplicationContext().getText(R.string.missingField), Toast.LENGTH_SHORT).show();
                    return;
                }
                Boolean check = false;
                for (int i = 0; i < loginList.size(); i++) {
                    if (loginText.equals(loginList.get(i)) && passwordText.equals(passwordList.get(i))) {
                        check = true;
                        break;
                    }
                }
                if (check) {
                    txt.setTextColor(Color.GREEN);
                    txt.setText(positiveAnswer);
                }
                else {
                    txt.setTextColor(Color.RED);
                    txt.setText(negativeAnswer);
                    loginEdit.setText("");
                    passwordEdit.setText("");

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(getApplicationContext().getString(R.string.registerAsk));
                    builder.setPositiveButton(getApplicationContext().getString(R.string.yes), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
                            startActivityForResult(i, ind);
                        }
                    });
                    builder.setNegativeButton(getApplicationContext().getString(R.string.no), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                loginEdit.setText(data.getStringExtra("loginValue"));
                loginList.add(data.getStringExtra("loginValue"));
                passwordList.add(data.getStringExtra("passwordValue"));
        }
    }
}