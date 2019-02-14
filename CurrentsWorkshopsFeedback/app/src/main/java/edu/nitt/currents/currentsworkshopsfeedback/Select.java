package edu.nitt.currents.currentsworkshopsfeedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Select extends AppCompatActivity {

    Button workshop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        this.setTitle("Welcome!");


        workshop=(Button)findViewById(R.id.workshops);


        workshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Select.this,Workshops.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
