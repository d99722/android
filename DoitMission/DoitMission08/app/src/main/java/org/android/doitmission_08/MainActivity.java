package org.android.doitmission_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_OK = 101;
    EditText usernameInput;
    EditText passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                if(username.equals("") && password.equals("")){
                    Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 입력해주세요.",Toast.LENGTH_LONG).show();
                } else if (username.equals("")){
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요.",Toast.LENGTH_LONG).show();
                } else if (password.equals("")){
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요.",Toast.LENGTH_LONG).show();
                } else {
                    intent.putExtra("username", username);
                    intent.putExtra("password",password);
                    startActivityForResult(intent, REQUEST_OK);
                }

            }
        });
    }
}