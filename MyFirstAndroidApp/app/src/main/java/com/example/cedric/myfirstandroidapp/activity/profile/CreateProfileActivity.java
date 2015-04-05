package com.example.cedric.myfirstandroidapp.activity.profile;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.cedric.myfirstandroidapp.R;
import com.example.cedric.myfirstandroidapp.controller.ProfilesController;
import com.example.cedric.myfirstandroidapp.database.model.Gender;
import com.example.cedric.myfirstandroidapp.database.model.Profile;

import java.util.HashMap;
import java.util.List;

public class CreateProfileActivity extends ActionBarActivity {
    // Context
    private Context context;
    // Profiles controller
    private ProfilesController profilesController;
    // Name field
    private EditText nameField;
    // Age field
    private EditText ageField;
    // Gender list
    private RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        // Initialization of the profiles controller
        profilesController = new ProfilesController(CreateProfileActivity.this);

        // Get the context for Toasts
        context = getApplicationContext();

        // Get the fields
        nameField = (EditText) findViewById(R.id.new_profile_name);
        ageField = (EditText) findViewById(R.id.new_profile_age);
        genderGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);


        final Button saveProfileBtn = (Button) findViewById(R.id.save_profile);
        saveProfileBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                int duration = Toast.LENGTH_SHORT;

                // Checks if the name and the age are filled
                String name = nameField.getText().toString();
                String age = ageField.getText().toString();
                String gender = "";

                int checkedId = genderGroup.getCheckedRadioButtonId();

                if(checkedId != -1){
                    RadioButton selectedGender = (RadioButton) genderGroup.findViewById(checkedId);
                    gender = selectedGender.getText().toString();
                }

                // Displays error message if at least one of them is not filled
                if( gender.equals("") || name.equals("") || age.equals("") ){
                    CharSequence text = "Please define all fields";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    // Save the profile
                    Profile profile = new Profile(name, Integer.parseInt(age), gender);

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
