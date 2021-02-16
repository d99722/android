package org.android.doitmission_07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 1001;
    Button button;

    EditText usernameInput;
    EditText passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);

                startActivityForResult(intent, REQUEST_CODE_MENU);

            }
        });

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU){
            if(data!=null){
                String menu = data.getStringExtra("menu");
                String message = data.getStringExtra("message");

                Toast toast = Toast.makeText(getBaseContext(), "result code : "+resultCode +", menu : "+menu+", message : "+message, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }





}