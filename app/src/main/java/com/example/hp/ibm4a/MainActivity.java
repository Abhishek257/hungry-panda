package com.example.hp.ibm4a;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    SQLiteDatabase db;
    EditText id,pass;
    Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login= (Button) findViewById(R.id.button4);
        signup= (Button) findViewById(R.id.button5);
        id= (EditText) findViewById(R.id.login);
        pass= (EditText) findViewById(R.id.pass);
        database obj=new database(getApplicationContext(),"PANDA",null,3);
        db=   obj.getReadableDatabase();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           String a= id.getText().toString();
                String b=pass.getText().toString();
                Cursor c=db.rawQuery("Select Pass from Register where  User='" +a+ "'", null);

                if(c.moveToNext())
                {
                    String pa=c.getString(0);
                    if(pa.equals(b))
                    {
                        Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, second.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Not a valid login Id/Passward",Toast.LENGTH_SHORT).show();
                    }


                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Not a valid login Id/Passward",Toast.LENGTH_SHORT).show();
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Signup.class);
                startActivity(i);
            }
        });

        /*TimerTask task = new TimerTask() {
            @Override
            public void run() {

                Intent i = new Intent(MainActivity.this, second.class);
                startActivity(i);
                finishscreen();

            }
        };
        Timer t = new Timer();
        t.schedule(task, 2500);*/
    }

   /* private void finishscreen() {
        this.finish();
    }*/
}

