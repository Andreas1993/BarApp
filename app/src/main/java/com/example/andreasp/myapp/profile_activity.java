package com.example.andreasp.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class profile_activity extends AppCompatActivity {

    Button captureProfilePic;
    ImageView profileConfig;
    private static final int CAMERA_PIC_REQUEST = 1337;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        captureProfilePic = (Button) findViewById(R.id.newProfilePic);
        profileConfig = (ImageView) findViewById(R.id.ProfilePic);

        captureProfilePic.setOnClickListener(new captureProfilePicClicker());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_PIC_REQUEST)
        {
            Bitmap ProfileImage = (Bitmap) data.getExtras().get("data");
            profileConfig.setImageBitmap(ProfileImage);
        }
    }

    class captureProfilePicClicker implements Button.OnClickListener{

        @Override
        public void onClick(View picture){

            Intent PictureTaker = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(PictureTaker, CAMERA_PIC_REQUEST);
        }
    }

    public class sharedPrefs extends AppCompatActivity implements Button.OnClickListener {

        // Variables
        EditText FirstNameEdit;
        EditText LastNameEdit;
        EditText EmailEdit;
        TextView FirstName;
        TextView LastName;
        TextView Email;
        String fname = "FNEdit";
        String lname = "LNEdit";
        String E_mail = "EmailEdit";
        SharedPreferences FirstNameData;
        SharedPreferences LastNameData;
        SharedPreferences EmailData;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile_activity);
            setupVariables();
            FirstNameData = getSharedPreferences(fname, 0);
            LastNameData = getSharedPreferences(lname, 0);
            EmailData = getSharedPreferences(E_mail, 0);

        }


        private void setupVariables(){
            Button saveChanges = (Button) findViewById(R.id.saveChanges);
            Button loadChanges = (Button) findViewById(R.id.ProfileButton);

            FirstNameEdit = (EditText) findViewById(R.id.FirstNameEdit);
            LastNameEdit = (EditText) findViewById(R.id.LastNameEdit);
            EmailEdit = (EditText) findViewById(R.id.EmailEdit);

            FirstName = (TextView) findViewById(R.id.FirstName);
            LastName = (TextView) findViewById(R.id.LastName);
            Email = (TextView) findViewById(R.id.Email);

            saveChanges.setOnClickListener(this);
            loadChanges.setOnClickListener(this);
        }

        public void onClick(View v){
            switch (v.getId()){
                case R.id.saveChanges:
                    String FirstNameText = FirstNameEdit.getText().toString();
                    SharedPreferences.Editor FnameEditor = FirstNameData.edit();
                    FnameEditor.putString("FirstNamePut", FirstNameText);
                    FnameEditor.apply();

                    String LastNameText = LastNameEdit.getText().toString();
                    SharedPreferences.Editor LnameEditor = LastNameData.edit();
                    LnameEditor.putString("LastNamePut", LastNameText);
                    LnameEditor.apply();

                    String EmailText = EmailEdit.getText().toString();
                    SharedPreferences.Editor EmailEditor = EmailData.edit();
                    EmailEditor.putString("EmailHolderPut", EmailText);
                    EmailEditor.apply();
                    break;

                case R.id.newProfilePic:
                    FirstNameData = getSharedPreferences(fname, 0);
                    String FirstNameLoad = FirstNameData.getString("FirstNamePut", "Error");
                    FirstName.setText(FirstNameLoad);

                    LastNameData = getSharedPreferences(lname, 0);
                    String LastNameLoad = LastNameData.getString("LastNamePut", "Error");
                    LastName.setText(LastNameLoad);

                    EmailData = getSharedPreferences(E_mail, 0);
                    String EmailLoad = EmailData.getString("EmailHolderPut", "Error");
                    Email.setText(EmailLoad);
                    break;
            }
        }
    }




}
