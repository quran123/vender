package com.anushka.vender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText phone;
    Button submit;
    String userPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        phone=(EditText) findViewById(R.id.phone);
        submit=(Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPhone=phone.getText().toString();
                Intent i=new Intent(getApplicationContext(),otp.class);
                i.putExtra("Phone", userPhone);
                startActivity(i);
            }
        });
    }
}
