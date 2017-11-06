package my.edu.taruc.lab22userprofile;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String USER_ID="my.edu.tarc.lac22userprofile.ID";
    public static final String USER_EMAIL="my.edu.tarc.lac22userprofile.Email";
    public static final int REQUEST_PROFILE_UPDATE = 1;
    private TextView textViewID,textViewEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewID=(TextView) findViewById(R.id.textView);
        textViewEmail=(TextView)findViewById(R.id.textView2);
    }

    public void editProfile(View view){
        //As explicit Intent
        Intent intent= new Intent(this,ProfileActivity.class);
        startActivityForResult(intent,REQUEST_PROFILE_UPDATE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // request code = unique code that activity sent with an intent
        //result code = Store either OK or Cancel
        super.onActivityResult(requestCode, resultCode, data);
        //if(requestCode == REQUEST_PROFILE_UPDATE && resultCode == RESULT_OK){
        if(requestCode == REQUEST_PROFILE_UPDATE){
            String id,email;
            id=data.getStringExtra(USER_ID);
            email=data.getStringExtra(USER_EMAIL);

            //Display Data
            textViewID.setText(getString(R.string.id)+ " " + id);
            textViewEmail.setText(getString(R.string.email)+ " " + email);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main Activity","onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main Activity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main Activity","onResume");
    }
}
