/*
 * Quick Memo
 * By: Blaine Parr, Richard Estrada and Cody Hutchinson
 * Date Last Edited: April 12, 2016
 * Last Edited By: Blaine Parr
 * Description: This application displays tasks/memos entered by the user. The user can view tasks
 * for today, completed tasks and all tasks.
 */
package ca.georgiancollege.quickmemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //constants
    final int ALL = 0;
    final int TODAY = 1;
    final int DONE = 2;

    //instance variables
    private Button todayButton;
    private Button allButton;
    private Button doneButton;
    private Button newButton;
    private LinearLayout contentLayout;

    private ArrayList<Memo> memos;
    private ArrayList<Memo> shownMemos;

    /*
     * This method runs when the app is started. It sets up the app and all of its components.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialize the arrayLists and the buttons
        this.memos = new ArrayList<Memo>(0);
        this.shownMemos = new ArrayList<Memo>(0);

        this.todayButton = (Button) findViewById(R.id.todayButton);
        this.allButton = (Button) findViewById(R.id.allButton);
        this.doneButton = (Button) findViewById(R.id.doneButton);
        this.newButton = (Button) findViewById(R.id.newButton);
        this.contentLayout = (LinearLayout) findViewById(R.id.contentLayout);

        /*
         * This function displays the memos for today.
         */
        this.todayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMemos(TODAY);
            } //method onClick ends
        });

        /*
         * This function displays all memos.
         */
        this.allButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMemos(ALL);
            } //method onClick ends
        });

        /*
         * This function displays finished memos.
         */
        this.doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMemos(DONE);
            } //method onClick ends
        });

        /*
         * When the new button is clicked, launch the create activity, and prepare to receive
         * memo data as a result.
         */
        this.newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create a new CreateActivity
                Intent i = new Intent(getApplicationContext(), CreateActivity.class);

                //start the activity, and prepare for result code 100
                startActivityForResult(i, 100);
            } //method onClick ends
        });
    } //method onCreate ends

    /*
     * This method handles the returned information from the CreateActivity.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //prepare to receive a requestCode, resultCode and data.
        super.onActivityResult(requestCode, resultCode, data);

        //if the result code is 100, we were successfully returned data
        //get the memo information from data and add it as a new Memo
        if(resultCode == 100) {
            this.memos.add(new Memo(data.getExtras().get("title").toString(), data.getExtras().get("category").toString(), data.getExtras().get("date").toString(), data.getExtras().get("description").toString()));
        } //if ends

        this.displayMemos(ALL);
    } //method onActivityResult ends

    /*
     * This method displays the users' entered memos
     */
    private void displayMemos(int sort) {
        Log.d("QuickMemo", "Made it here");
        //clear contentLayout
        this.contentLayout.removeAllViews();
        this.shownMemos.clear();

        //get today's date as a String
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        //create an ArrayList to hold the memos to be displayed
        //this.shownMemos = new ArrayList<Memo>(0);

        //if ALL memos are to be displayed, directly copy the memos ArrayList
        //if TODAY's memos are to be displayed, use a for loop to find ones with the correct date
        //if DONE memos are to be displayed, use a for loop to find which ones are done
        switch(sort) {
            case ALL: this.shownMemos = new ArrayList<Memo>(this.memos);
                Log.d("QuickMemo", "Made it here 2");
                break;
            case TODAY:
                Log.d("QuickMemo", "Made it here 3");
                for(int i = 0; i < this.memos.size(); i++) {
                    if(this.memos.get(i).getDate().equals(today)) {
                        this.shownMemos.add(this.memos.get(i));
                    } //if ends
                } //for ends
                break;
            case DONE:
                for(int i = 0; i < this.memos.size(); i++) {
                    if(this.memos.get(i).getIsDone()) {
                        shownMemos.add(this.memos.get(i));
                    } //if ends
                } //for ends
        } //switch ends

        //for loop set up to display the information from each memo
        for(int i = 0; i < this.shownMemos.size(); i++) {
            final int j = i;

            //make a new linear layout
            LinearLayout l = new LinearLayout(this);

            //set up linear layout
            l.setOrientation(LinearLayout.HORIZONTAL);
            l.setBackgroundColor(Color.DKGRAY);
            LayoutParams lParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            l.setLayoutParams(lParams);

            //set up the title text view
            TextView titleTextView = new TextView(this);
            titleTextView.setTextColor(Color.WHITE);
            titleTextView.setText(this.shownMemos.get(i).getTitle());
            titleTextView.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f));

            //set up the date textView
            TextView dateTextView = new TextView(this);
            dateTextView.setTextColor(Color.WHITE);
            dateTextView.setText(this.shownMemos.get(i).getDate());
            dateTextView.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f));

            //add the textViews
            l.addView(titleTextView);
            l.addView(dateTextView);

            //create another LinearLayout
            LinearLayout l2 = new LinearLayout(this);

            //set up the LinearLayout
            l2.setOrientation(LinearLayout.HORIZONTAL);
            l2.setBackgroundColor(Color.WHITE);
            l2.setLayoutParams(lParams);

            //set up the categoryTextView
            TextView categoryTextView = new TextView(this);
            categoryTextView.setTextColor(Color.BLACK);
            categoryTextView.setText(this.shownMemos.get(i).getCategory());
            categoryTextView.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f));

            //set up the descriptionTextView
            TextView descriptionTextView = new TextView(this);
            descriptionTextView.setTextColor(Color.BLACK);
            descriptionTextView.setText(this.shownMemos.get(i).getDescription());
            descriptionTextView.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f));

            //add the textViews
            l2.addView(categoryTextView);
            l2.addView(descriptionTextView);

            //create a third LinearLayout
            LinearLayout l3 = new LinearLayout(this);

            //set up the LinearLayout
            l3.setOrientation(LinearLayout.HORIZONTAL);
            l3.setBackgroundColor(Color.WHITE);
            l3.setLayoutParams(lParams);

            if(!shownMemos.get(i).getIsDone()) {
                Button finishMemoButton = new Button(this);
                finishMemoButton.setText("Finish");

                finishMemoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        memos.get(memos.indexOf(shownMemos.get(j))).setIsDone(true);
                        displayMemos(ALL);
                    } //method onClick ends
                });

                l3.addView(finishMemoButton);
            } //if ends

            Button deleteMemoButton = new Button(this);
            deleteMemoButton.setText("Delete");

            deleteMemoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    memos.remove(memos.indexOf(shownMemos.get(j)));
                    displayMemos(ALL);
                } //method onClick ends
            });

            l3.addView(deleteMemoButton);

            //add the LinearLayouts to contentLayout
            this.contentLayout.addView(l);
            this.contentLayout.addView(l2);
            this.contentLayout.addView(l3);
        } //for ends
    } //method displayMemos ends
} //class MainActivity ends
