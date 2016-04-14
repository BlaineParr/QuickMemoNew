package ca.georgiancollege.quickmemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {

    //instance variables
    Button submitButton;

    EditText titleEditText;
    EditText categoryEditText;
    EditText dateEditText;
    EditText descriptionEditText;

    /*
     * This method...
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //Initialize variables
        titleEditText = (EditText) findViewById(R.id.titleEditText);
        categoryEditText = (EditText) findViewById(R.id.categoryEditText);
        dateEditText = (EditText) findViewById(R.id.dateEditText);
        descriptionEditText = (EditText) findViewById(R.id.descriptionEditText);

        submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();

                i.putExtra("title", titleEditText.getText().toString());
                i.putExtra("category", categoryEditText.getText().toString());
                i.putExtra("date", dateEditText.getText().toString());
                i.putExtra("description", descriptionEditText.getText().toString());

                setResult(100, i);

                finish();
            } //method onClick ends
        });
    } //method onCreate ends
} //class CreateActivity ends
