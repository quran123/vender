package com.anushka.vender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    TextView t;
    EditText name,phone;
    Button submit;
    TextView textview;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView)findViewById(R.id.textView);
        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phone);
        submit=(Button)findViewById(R.id.submit);
        textview=(TextView)findViewById(R.id.textView);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),login.class);
                startActivity(i);
            }});
        mDatabase = FirebaseDatabase.getInstance().getReference("user");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = mDatabase.push().getKey();
                String userName= name.getText().toString();
                String userPhone=phone.getText().toString();
                registergetset user = new registergetset(userName,userPhone);
                mDatabase.child(userId).setValue(user);
                Intent i=new Intent(getApplicationContext(),otp.class);
                i.putExtra("Phone", userPhone);
                startActivity(i);
            }
        });
        //t.setOnClickListener(this);
    }
    public void register(View view) {
        Intent i=new Intent(getApplicationContext(),login.class);
        startActivity(i);
    }

//    @Override
//    public void onClick(View v) {
//        Intent i=new Intent(getApplicationContext(),otp.class);
//        startActivity(i);
//    }
}
