package org.android.doitmission_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button sendButton;
    Button closeButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.inputMessage);
        sendButton = findViewById(R.id.sendButton);
        closeButton = findViewById(R.id.closeButton);
        textView = findViewById(R.id.inputCount);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                updateInputText(count);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                byte[] bytes = null;
                bytes = s.toString().getBytes();
                int strCount = bytes.length;
                textView.setText(strCount+" / 80 바이트");
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();
                byte[] strBytes = str.getBytes();
                if(strBytes.length>80){
                    s.delete(s.length()-2, s.length()-1);
                }

            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editText.getText().toString();
                Toast.makeText(getApplicationContext(), "전송할 메세지\n\n" + msg, Toast.LENGTH_SHORT).show();
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}