package com.example.cedric.myfirstandroidapp.activity.profile;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cedric.myfirstandroidapp.R;
import com.example.cedric.myfirstandroidapp.controller.ProfilesController;
import com.example.cedric.myfirstandroidapp.database.MySQLiteHelper;
import com.example.cedric.myfirstandroidapp.database.model.Profile;

public class CreateProfileActivity extends ActionBarActivity {
    // Profiles controller
    private ProfilesController profilesController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        // Initialization of the profiles controller
        profilesController = new ProfilesController(CreateProfileActivity.this);



        final Button saveProfileBtn = (Button) findViewById(R.id.save_profile);
        saveProfileBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                // Get the context for Toasts
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                // Get the fields
                EditText nameText = (EditText) findViewById(R.id.new_profile_name);
                EditText ageText = (EditText) findViewById(R.id.new_profile_age);

                // Checks if the name and the age are filled
                String name = nameText.getText().toString();
                String age = ageText.getText().toString();

                // Displays error message if at least one of them is not filled
                if( name.equals("") || age.equals("") ){
                    CharSequence text = "Please fill the name/age!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    // Save the profile
                    MySQLiteHelper db = new MySQLiteHelper(CreateProfileActivity.this);

                    /**
                     * CRUD Operations
                     * */
                    // add Profile
                    Profile profile = new Profile(name, Integer.parseInt(age));

                    profilesController.save(profile);

                    CharSequence text = "Profile created : " + profile.toString();
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_profile, menu);
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
