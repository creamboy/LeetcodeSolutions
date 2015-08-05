package com.example.zf.leetcodesolutions;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.*;


public class problemDetails extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_sum);

        TextView text=(TextView)findViewById(R.id.twoSumSolution);
        text.setMovementMethod(new ScrollingMovementMethod());
        Intent intent = getIntent();
        String message = intent.getStringExtra(problemList.EXTRA_MESSAGE);
        String[] s=message.toLowerCase().split(" ");
        String filename="";
        for(int i=1; i<s.length; i++){
            filename+=s[i];
        }
        InputStream is = getResources().openRawResource(getResources().getIdentifier("raw/"+filename,
                        "raw", getPackageName()));
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        String entireFile = "";
        try {
            while((line = br.readLine()) != null) { // <--------- place readLine() inside loop
                entireFile += (line + "\n"); // <---------- add each line to entireFile
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        text.setText(entireFile); // <------- assign entireFile to TextView
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_sum, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
