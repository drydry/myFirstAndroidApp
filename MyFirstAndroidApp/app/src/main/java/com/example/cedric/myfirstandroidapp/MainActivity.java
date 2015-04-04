package com.example.cedric.myfirstandroidapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cedric.myfirstandroidapp.database.model.Profile;
import com.example.cedric.myfirstandroidapp.myprofile.CreateProfileActivity;
import com.example.cedric.myfirstandroidapp.myprofile.ListProfilesActivity;

import static android.widget.TextView.BufferType;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button gotoCreateProfileBtn = (Button) findViewById(R.id.goto_create_profile_btn);
        gotoCreateProfileBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(MainActivity.this, CreateProfileActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        final Button gotoProfilesListBtn = (Button) findViewById(R.id.button_goto_profiles_list);
        gotoProfilesListBtn .setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(MainActivity.this, ListProfilesActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        // Set a new profile
        /*Profile profile = new Profile( "Cedric", 29 );

        // Get the editText fields
        EditText nameText = (EditText) findViewById(R.id.profileName);
        EditText ageText = (EditText) findViewById(R.id.profileAge);

        // Set profile values into the editText fields
        nameText.setText(profile.getName(), BufferType.EDITABLE);
        ageText.setText( String.valueOf(profile.getAge()) , BufferType.EDITABLE);
        */
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
