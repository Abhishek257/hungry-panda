package com.example.hp.ibm4a;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class fourth extends Activity {
String[] Restoname={"Haldiram's", "hotel ashok", "keventers", "mainland china"
    , "The irish house", "barbeque nation", "Burger King", "Subway"};


    Button b2;
    ImageView i2;
    TextView t4;
    RatingBar r;

    int[] img={R.drawable.haldiram,R.drawable.ashoka,R.drawable.keventers,R.drawable.mainland,R.drawable.irishhouse
    ,R.drawable.bbq,R.drawable.burgerking,R.drawable.subway};
    double[] rating= {5, 4, 3, 3, 4, 5, 4.5, 3.5};
    String[] review={"good","very good","must try","not bad"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        b2= (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(fourth.this,fifth.class);
                startActivity(i);
            }
        });
        t4= (TextView) findViewById(R.id.textView4);
        i2= (ImageView) findViewById(R.id.imageView3);
        r= (RatingBar) findViewById(R.id.ratingBar);
        ListView l1= (ListView) findViewById(R.id.listView);
        String t=getIntent().getStringExtra("cafe");
        String s=getIntent().getStringExtra("restoname");

        for(int i=0;i<Restoname.length;i++)
        {
            if (s.equals(Restoname[i]))
            {
                i2.setImageResource(img[i]);
                t4.setText(Restoname[i]);
                ArrayAdapter<String> ar=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, review);
                l1.setAdapter(ar);
                r.setRating((float) rating[i]);


            }
        }

    }
}
