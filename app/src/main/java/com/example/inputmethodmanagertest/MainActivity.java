package com.example.inputmethodmanagertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Switch keypadSwitch;

    static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.Name);
        keypadSwitch = findViewById(R.id.keypadSwitch);

        keypadSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG,"switch change event is Checked : "+isChecked);
                //keyboard display
                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(INPUT_METHOD_SERVICE);
                if(isChecked){
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                }else{
                    inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getRootView().getWindowToken(), 0);

                }
            }
        });


    }
}