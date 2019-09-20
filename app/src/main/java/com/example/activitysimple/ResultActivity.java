package com.example.activitysimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.activitysimple.model.LoginInfo;

import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        LoginInfo loginInfo = (LoginInfo)intent.getSerializableExtra(MainActivity.LOGIN_INFO);
        txtResult = findViewById(R.id.txtResult);
        txtResult.setText(String.format(txtResult.getText().toString(), loginInfo.getPassword()));
    }
}
