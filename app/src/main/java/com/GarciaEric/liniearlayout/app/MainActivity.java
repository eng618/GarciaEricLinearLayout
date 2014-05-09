package com.GarciaEric.liniearlayout.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String LOGTAG = "MainActivity";
    // Variables
    private boolean takesCream;
    private boolean takesSugar;
    private int numSugar;

    // Fields & Buttons
    private Button orderBtn;
    private TextView resultsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Log message
        Log.d(LOGTAG, "onCreate entered");

        completeOrder();

    }

    // When clicking the complete button this method is called
    public void completeOrder(){
        // Log message
        Log.d(LOGTAG, "completeOrder entered" );

        // Define order button
        orderBtn = (Button)findViewById(R.id.orderButton);

        // Set up button event listener
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log message
                Log.d(LOGTAG, "onClick entered");

                // Obtain TextView
                resultsText = (TextView)findViewById(R.id.resultsTextView);
                // Set TextView text
                resultsText.setText("values");
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
