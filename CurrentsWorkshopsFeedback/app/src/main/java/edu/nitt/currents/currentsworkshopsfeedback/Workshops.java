package edu.nitt.currents.currentsworkshopsfeedback;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

public class Workshops extends AppCompatActivity {

    MaterialBetterSpinner workshop_select;
    Button submit;

    TextInputLayout id_input;
    EditText id,q7,q8,q9;
    RatingBar q1,q2,q3,q4,q5,q6;

    Feedback feedback;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops);

        this.setTitle("Workshops");

        context=this;

        workshop_select=(MaterialBetterSpinner)findViewById(R.id.select_workshop);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Workshops.this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.workshops));
        workshop_select.setAdapter(arrayAdapter);


        id=(EditText)findViewById(R.id.currents_id_workshop);
        id_input=(TextInputLayout)findViewById(R.id.currents_id_input_workshop);

        q7=(EditText)findViewById(R.id.editText1);
        q8=(EditText)findViewById(R.id.editText2);
        q9=(EditText)findViewById(R.id.editText3);

        q1=(RatingBar)findViewById(R.id.ratingBar1);
        q2=(RatingBar)findViewById(R.id.ratingBar2);
        q3=(RatingBar)findViewById(R.id.ratingBar3);
        q4=(RatingBar)findViewById(R.id.ratingBar4);
        q5=(RatingBar)findViewById(R.id.ratingBar5);
        q6=(RatingBar)findViewById(R.id.ratingBar6);



        submit=(Button)findViewById(R.id.submit_workshop);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkInput()) {
                    Intent intent = new Intent(Workshops.this, Thanks.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }

    public boolean checkInput(){
        if(id.getText().toString().trim().isEmpty()){

            id_input.setError("Enter a currents id");
            id.requestFocus();
        }
        else{
            id_input.setErrorEnabled(false);

                if(!workshop_select.getText().toString().trim().isEmpty()){
                    if(q7.getText().toString().trim().isEmpty()||q8.getText().toString().trim().isEmpty()||q9.getText().toString().trim().isEmpty()){
                        Toast.makeText(this, "Please fill the questionniare", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(this, "Feedback recorded!", Toast.LENGTH_SHORT).show();
                        store();
                        return true;
                    }    
                }
            else {
                    Toast.makeText(this, "Select a workshop", Toast.LENGTH_SHORT).show();
                    workshop_select.requestFocus();
                }

                
            }




        return false;
    }

    public void store(){
        feedback=new Feedback();
        feedback.setCurrents_id(id.getText().toString());
        feedback.setWorkshop(workshop_select.getText().toString());
        feedback.setQ1(String.valueOf(q1.getRating()));
        feedback.setQ2(String.valueOf(q2.getRating()));
        feedback.setQ3(String.valueOf(q3.getRating()));
        feedback.setQ4(String.valueOf(q4.getRating()));
        feedback.setQ5(String.valueOf(q5.getRating()));
        feedback.setQ6(String.valueOf(q6.getRating()));
        feedback.setQ7(q7.getText().toString());
        feedback.setQ8(q8.getText().toString());
        feedback.setQ9(q9.getText().toString());

        FeedbackStorage newFeedback=new FeedbackStorage(context,null,null,1);
        newFeedback.addRow(feedback);

    }
}
