package com.example.hp.ibm4a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class fifth extends Activity {
    SQLiteDatabase db;
    Button b3;
    int r1,r2,a;
    String s,m;
    EditText nm;
    EditText em,ph,persn,dat;
    String name,email,phone,person,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        persn= (EditText) findViewById(R.id.person);
       dat= (EditText) findViewById(R.id.date);
        b3= (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person =persn.getText().toString();
                date=dat.getText().toString();
                if ( person.equals("") || date.equals("")) {
                    Toast.makeText(fifth.this, "ENTER ALL VALUES", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"no. of persons ::"+"\n"+person+"\n"+"date  ::"+date,Toast.LENGTH_SHORT).show();
                    BookId();
                    TableId();
                   /* Intent i1=new Intent(getApplicationContext(),sixth.class);
                    PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,i1,0);
                    SmsManager sms=SmsManager.getDefault();
                    sms.sendTextMessage(phone, null, "Dear " + name + "\nThanks For booking through YummyFy. Your Booking Id is: " + r1 + ". Your Table Number is: " + r2 + " Date is " + date , pi, null);
                    */
                    Toast.makeText(getApplicationContext(),"Dear User \nThanks For booking. Your Booking Id is: "+r1+". Your Table Number is: "+r2+" Date is "+date,Toast.LENGTH_LONG).show();


                                          Toast.makeText(getApplicationContext(), "Ticket Booked", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), sixth.class);
                        startActivity(i);

                }
            }


        });
    }
    public void BookId()
    {
        Random r=new Random();
        r1=r.nextInt(1000-5)+12;

    }
    public void TableId()
    {
        Random r=new Random();
        r2=r.nextInt(10-5)+2;

    }
}
