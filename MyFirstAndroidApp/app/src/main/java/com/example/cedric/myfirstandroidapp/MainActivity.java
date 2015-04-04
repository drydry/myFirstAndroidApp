package com.example.cedric.myfirstandroidapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cedric.myfirstandroidapp.myprofile.MyProfile;

import static android.widget.TextView.*;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        MyProfile profile = new MyProfile( "Cedric", 29 );

        EditText nameText = (EditText) findViewById(R.id.profileName);
        EditText ageText = (EditText) findViewById(R.id.profileAge);

        if( null != nameText  ) nameText.setText(profile.getName(), BufferType.EDITABLE);

        if( null != ageText ) ageText.setText( String.valueOf(profile.getAge()) , BufferType.EDITABLE);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
