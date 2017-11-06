package my.edu.taruc.lab22userprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static my.edu.taruc.lab22userprofile.MainActivity.REQUEST_PROFILE_UPDATE;
import static my.edu.taruc.lab22userprofile.MainActivity.USER_EMAIL;
import static my.edu.taruc.lab22userprofile.MainActivity.USER_ID;

public class ProfileActivity extends AppCompatActivity {
    private EditText editTextID,editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Linking
        editTextID=(EditText)findViewById(R.id.editText3);
        editTextEmail=(EditText)findViewById(R.id.editText4);

    }

    public void sendMessage (View view){
        Intent intent=new Intent(this,MainActivity.class);

        String id,email;
        id=editTextID.getText().toString();
        email=editTextEmail.getText().toString();

        intent.putExtra(USER_ID,id);
        intent.putExtra(USER_EMAIL,email);

        setResult(MainActivity.REQUEST_PROFILE_UPDATE,intent);
        finish();
    }

}
