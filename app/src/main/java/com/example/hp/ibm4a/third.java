package com.example.hp.ibm4a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class third extends Activity implements AdapterView.OnItemSelectedListener {
    String[] city = {"Select city", "Delhi", "Noida"};
    String[] Areadelhi = {"Select area", "kaushambi", "vaishali"};
    String[] Areanoida = {"Select area", "sec-62", "sec-15"};
    String[] reskaushambi = {"Select Restaurant", "Haldiram's", "hotel ashok"};
    String[] resvaishali = {"Select Restaurant", "keventers", "mainland china"};
    String[] res62 = {"Select Restaurant", "The irish house", "barbeque nation"};
    String[] res15 = {"Select Restaurant", "Burger King", "Subway"};
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        final Spinner s = (Spinner) findViewById(R.id.spinner);
        final Spinner s1 = (Spinner) findViewById(R.id.spinner2);
        final Spinner s2 = (Spinner) findViewById(R.id.spinner3);
        b= (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), fourth.class);
                String restoname = s2.getSelectedItem().toString();
                i.putExtra("restoname", restoname);
                startActivity(i);
            }
        });
        s.setOnItemSelectedListener(this);
        s1.setOnItemSelectedListener(this);
        s2.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, city);
        s.setAdapter(dataAdapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectcity = city[i];
                if (selectcity.equals("Delhi")) {
                    ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_singlechoice, Areadelhi);
                    s1.setAdapter(dataAdapter1);
                    s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String selectareadelhi = Areadelhi[i];
                            if (selectareadelhi.equals("kaushambi")) {
                                ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_singlechoice, reskaushambi);
                                s2.setAdapter(dataAdapter1);


                            } else if (selectareadelhi.equals("vaishali")) {
                                ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_singlechoice, resvaishali);
                                s2.setAdapter(dataAdapter2);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (selectcity.equals("Noida")) {
                    ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_singlechoice, Areanoida);
                    s1.setAdapter(dataAdapter1);
                    s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String selectareanoida = Areanoida[i];
                            if (selectareanoida.equals("sec-62")) {
                                ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_singlechoice, res62);
                                s2.setAdapter(dataAdapter4);


                            } else if (selectareanoida.equals("sec-15")) {
                                ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_singlechoice, res15);
                                s2.setAdapter(dataAdapter5);

                            }
                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

