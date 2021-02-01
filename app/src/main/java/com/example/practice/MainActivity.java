package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

    }


    public void setActivityBackgroundColor(String color) {
        ConstraintLayout rootLayout = findViewById(R.id.rootLayout);
        rootLayout.setBackgroundColor(Color.parseColor(color));
    }


    public void Call(View view) {
        String getNum = editText.getText().toString();

        if (getNum.isEmpty()) {
            editText.setError("Fill ");
        }
        else if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "You have not allowed Permission", Toast.LENGTH_SHORT).show();
            requestPermission();
        }
        else {
            Uri uriObj = Uri.parse("tel: " + getNum.trim());
            startActivity(new Intent(Intent.ACTION_CALL).setData(uriObj));
        }

    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new
                String[]{Manifest.permission.CALL_PHONE}, 1);
    }
}