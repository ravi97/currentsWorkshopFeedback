package edu.nitt.currents.currentsworkshopsfeedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Thanks extends AppCompatActivity {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);

        this.setTitle("Thanks!");

        next=(Button)findViewById(R.id.another_response);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Thanks.this,Select.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
