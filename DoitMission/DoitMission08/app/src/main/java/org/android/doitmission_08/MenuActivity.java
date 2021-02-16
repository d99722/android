package org.android.doitmission_08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_CUSTOMER = 201;
    public static final int REQUEST_CODE_REVENUE = 202;
    public static final int REQUEST_CODE_PRODUCT = 203;

    Button button1;
    Button button2;
    Button button3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                String menuname = button1.getText().toString();
                intent.putExtra("menuname",menuname);

                startActivityForResult(intent, REQUEST_CODE_CUSTOMER);
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                String menuname = button2.getText().toString();
                intent.putExtra("menuname",menuname);

                startActivityForResult(intent, REQUEST_CODE_REVENUE);
                finish();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                String menuname = button3.getText().toString();
                intent.putExtra("menuname",menuname);

                startActivityForResult(intent, REQUEST_CODE_CUSTOMER);
//                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data!=null){
            if(requestCode == REQUEST_CODE_CUSTOMER){
                Toast.makeText(getBaseContext(), "고객관리 요청 / 코드 : "+requestCode,Toast.LENGTH_LONG).show();
            } else if (requestCode == REQUEST_CODE_PRODUCT){
                Toast.makeText(getBaseContext(), "물품관리 요청 / 코드 : "+requestCode,Toast.LENGTH_LONG).show();
            } else if (requestCode == REQUEST_CODE_REVENUE){
                Toast.makeText(getBaseContext(), "수익관리 요청 / 코드 : "+requestCode,Toast.LENGTH_LONG).show();
            }
        }
    }


}