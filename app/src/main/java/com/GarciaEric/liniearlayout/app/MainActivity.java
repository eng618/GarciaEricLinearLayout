package com.GarciaEric.liniearlayout.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final String LOGTAG = "MainActivity";
    // Variables
    private String nameString;
    private String coffeeString;
    private boolean takesCream;
    private boolean takesSugar;
    private boolean singleDouble;
    private int numSugar;
    private ArrayList<String> returnStrings = new ArrayList<String>();
    private String finalString;

    // Fields & Buttons
    private EditText orderName;
    private EditText coffeeName;
    private RadioButton rbSingle;
    private CheckBox creamCheck;
    private CheckBox sugarCheck;
    private EditText numberOfSugars;
    public Button orderBtn;
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

                // Obtain fields
                orderName = (EditText)findViewById(R.id.yourNameTextField);
                coffeeName = (EditText)findViewById(R.id.coffeeNameTextField);
                rbSingle = (RadioButton)findViewById(R.id.singleButton);
                creamCheck = (CheckBox)findViewById(R.id.creamerCheck);
                sugarCheck = (CheckBox)findViewById(R.id.sugarCheck);
                numberOfSugars = (EditText)findViewById(R.id.numSugarTextField);

                resultsText = (TextView)findViewById(R.id.resultsTextView);

                // Log message
                Log.d(LOGTAG, "Fields obtained");

                // Clear arrayList
                returnStrings.clear();

                // Set values
                nameString = orderName.getText().toString();
                coffeeString = coffeeName.getText().toString();
                numSugar = Integer.parseInt(numberOfSugars.getText().toString());

                // Log message
                Log.d(LOGTAG, "Set values");

                //Start appending strings to string array
                returnStrings.add("Order ready for: ");
                returnStrings.add(nameString);
                returnStrings.add(". Your ");
                returnStrings.add(coffeeString);
                returnStrings.add(" is ready. ");

                // Log message
                Log.d(LOGTAG, "Started to append strings");

                // Check radio buttons
                // Is a single shoot
                singleDouble = rbSingle.isSelected();

                // Log message
                Log.d(LOGTAG, "Checked radial buttons");

                // Check checkboxes
                if (creamCheck.isChecked() && sugarCheck.isChecked()){
                    // Set bool's to true
                    takesCream = true;
                    takesSugar = true;
                    displayOrder();
                    return;
                }else if (creamCheck.isChecked()){
                    // Set bool to true
                    takesCream = true;
                    takesSugar = false;
                    displayOrder();
                    return;
                }else if (sugarCheck.isChecked()){
                    // Set bool to true
                    takesSugar = true;
                    takesCream = false;
                    displayOrder();
                    return;
                }

                // Log message
                Log.d(LOGTAG, "Checked checkboxes");

                displayOrder();
            }
        });



    }

    public void displayOrder(){
        // Log message
        Log.d(LOGTAG, "displayOrder entered");

        // Clear previous orders
        resultsText.setText("");

        if (singleDouble){
            returnStrings.add("It is a single shot");
        }else {
            returnStrings.add("It is a double shot");
        }

        if (takesCream && takesSugar){
            returnStrings.add(" and has cream with " + numSugar + " scoops of sugar. Enjoy!!");
        }else if (takesCream){
            returnStrings.add(" and only has cream. Enjoy!!");
        }else if (takesSugar){
            returnStrings.add(" and is black with " + numSugar + " scoops of sugar. Enjoy!!");
        }else {
            returnStrings.add(" ENJOY!!");
        }

        // Loop through ArrayList to for finalString
        for (int i=0; i < returnStrings.size(); i++){
            finalString = finalString + returnStrings.get(i);
        }


        // Set TextView text to display
        resultsText.setText(finalString);
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
