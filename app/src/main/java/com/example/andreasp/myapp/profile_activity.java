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

    // Variables
    Button captureProfilePic;
    Button saveChanges;
    Button loadChanges;
    ImageView profileConfig;
    private static final int CAMERA_PIC_REQUEST = 1337;
    EditText FirstNameEdit;
    EditText LastNameEdit;
    EditText EmailEdit;
    String fname;
    SharedPreferences ProfileData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        captureProfilePic = (Button) findViewById(R.id.newProfilePic);
        profileConfig = (ImageView) findViewById(R.id.ProfilePic);
        FirstNameEdit = (EditText) findViewById(R.id.FirstNameEdit);
        LastNameEdit = (EditText) findViewById(R.id.LastNameEdit);
        EmailEdit = (EditText) findViewById(R.id.EmailEdit);
        saveChanges = (Button) findViewById(R.id.saveChanges);
        loadChanges = (Button) findViewById(R.id.loadChanges);

        ProfileData = getSharedPreferences(fname, AppCompatActivity.MODE_PRIVATE);

        captureProfilePic.setOnClickListener(new captureProfilePicClicker());
        saveChanges.setOnClickListener(new sharedPrefs());
        loadChanges.setOnClickListener(new sharedPrefs());

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


        public void onClick(View v){
            switch (v.getId()){
                case R.id.saveChanges:
                    String FirstNameText = FirstNameEdit.getText().toString();
                    String LastNameText = LastNameEdit.getText().toString();
                    String EmailText = EmailEdit.getText().toString();
                    SharedPreferences.Editor ProfileEditor = ProfileData.edit();
                    ProfileEditor.putString("FirstNamePut", FirstNameText);
                    ProfileEditor.putString("LastNamePut", LastNameText);
                    ProfileEditor.putString("EmailHolderPut", EmailText);
                    ProfileEditor.commit();
                    break;

                case R.id.loadChanges:
                    String FirstNameLoad = ProfileData.getString("FirstNamePut", "");
                    String LastNameLoad = ProfileData.getString("LastNamePut", "");
                    String EmailLoad = ProfileData.getString("EmailHolderPut", "");
                    FirstNameEdit.setText(FirstNameLoad);
                    LastNameEdit.setText(LastNameLoad);
                    EmailEdit.setText(EmailLoad);
                    break;
            }
        }

    }





}
