package com.example.hp.ibm4a;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText name,email,phone,usernm,pass;
    Button b;
    SQLiteDatabase db;
    public String nm;
    public String em;
    public String ph;
    public String unm;
    public String ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.Email);
        phone= (EditText) findViewById(R.id.phone);
        usernm= (EditText) findViewById(R.id.usernm);
        pass= (EditText) findViewById(R.id.pass);
        b= (Button) findViewById(R.id.button);
        database obj=new database(getApplicationContext(),"PANDA",null,3);
        db =  obj.getWritableDatabase();//database
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nm=name.getText().toString();
                em=email.getText().toString();
                ph=phone.getText().toString();
                unm=usernm.getText().toString();
                ps=pass.getText().toString();

                if(nm.equals("")||em.equals("")||ph.equals("")||unm.equals("")||ps.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "ENTER ALL VALUES", Toast.LENGTH_SHORT).show();
                }
                else {
                    ContentValues cv=new ContentValues();
                    cv.put("Name",nm);
                    cv.put("Email",em);
                    cv.put("Phone",ph);
                    cv.put("User", unm);
                    cv.put("Pass", ps);

                    Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();
                    long l1= db.insert("Register",null,cv);
                    if(l1>0)
                    {
                        Toast.makeText(getApplicationContext(),"welcome",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),second.class);
                        startActivity(i);
                    }

                }


            }
        });
    }
}
