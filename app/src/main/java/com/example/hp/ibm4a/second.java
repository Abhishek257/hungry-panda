package com.example.hp.ibm4a;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class second extends Activity {
ImageButton i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        i2= (ImageButton) findViewById(R.id.cafe);
        i1= (ImageButton) findViewById(R.id.resto);
        i2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),thirda.class);
                startActivity(i);
            }
        });

        i1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i1=new Intent(second.this,third.class);
                startActivity(i1);
            }
        });

    }
}
