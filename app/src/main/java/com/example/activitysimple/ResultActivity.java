package com.example.activitysimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.activitysimple.model.LoginInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.txtResultLogin) TextView txtResultLogin;
    @BindView(R.id.txtResultPass) TextView txtResultPass;
    @BindView(R.id.txtResultDevice) TextView txtResultDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        LoginInfo loginInfo = (LoginInfo)intent.getSerializableExtra(MainActivity.LOGIN_INFO);

        txtResultLogin.setText(String.format(txtResultLogin.getText().toString(), loginInfo.getLogin()));
        txtResultPass.setText(String.format(txtResultPass.getText().toString(), loginInfo.getPassword()));
        txtResultDev.setText(String.format(txtResultDev.getText().toString(), loginInfo.getDevice()));
    }
}
