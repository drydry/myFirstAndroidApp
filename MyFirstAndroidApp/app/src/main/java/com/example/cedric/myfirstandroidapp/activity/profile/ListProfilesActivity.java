package com.example.cedric.myfirstandroidapp.activity.profile;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cedric.myfirstandroidapp.R;
import com.example.cedric.myfirstandroidapp.controller.ProfilesController;
import com.example.cedric.myfirstandroidapp.database.MySQLiteHelper;
import com.example.cedric.myfirstandroidapp.database.model.Profile;

import java.util.Iterator;
import java.util.List;

public class ListProfilesActivity extends ActionBarActivity {
    // Profiles controller
    private ProfilesController profilesController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_profiles);

        // Initialization of the profiles controller
        this.profilesController = new ProfilesController(ListProfilesActivity.this);

        List<Profile> profiles = profilesController.index();

        String newline = System.getProperty("line.separator");
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        String text = "Profiles: " + newline ;

        for(Iterator<Profile> i = profiles.iterator(); i.hasNext(); ) {
            Profile profile = i.next();
            text += profile.toString() + newline;
        }

        profiles.toString();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_profiles, menu);
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
