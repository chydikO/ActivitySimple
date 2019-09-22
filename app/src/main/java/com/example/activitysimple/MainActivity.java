package com.example.activitysimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activitysimple.model.LoginInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.Action;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.ViewCollections;


/**
 * Ссылки из урока:
 *
 *     View – элементы интерфейса (кнопки, поля, виджеты и пр.)  http://developer.android.com/reference/android/view/View.html
 *     ViewGroup – контейнер для других контейнеров или компонентов http://developer.android.com/reference/android/view/ViewGroup.html
 *     Документация с фильтрацией по API Level http://developer.android.com/reference/android/view/ViewGroup.html
 *
 *      Lesson_4
 *      Домашнее задание:
 *     Добавить кнопку «Очистить», которая будет очищать текстовые поля
 *     Под кнопками расположить изображение замка
 *     Изменить цвет фона главного окна
 *
 *     Lesson_5
 *     Домашнее задание:
 * 1. Проверять текстовые поля на пустые значения, в случае ошибки - выводить сообщение
 * 2. Изменить приветственное сообщение с отображением пароля
 * 3. * Добавить выпадающий список (Spinner), который содержит в себе список устройств.
 *      Передавать выбранное устройство в другой Activity
 */

public class MainActivity extends AppCompatActivity {

    public static final String LOGIN_INFO = "com.example.activityMain.login_info";
    private ArrayList<String> devices;
    @BindView(R.id.spinner) Spinner spinner;
    @BindView(R.id.btnLogin) Button btnLogin;
    @BindView(R.id.btnCancel) Button btnCancel;
    @BindView(R.id.textViewLogin) EditText editTextLogin;
    @BindView(R.id.textViewPass) EditText editTextPass;
    @BindView(R.id.textViewResult) TextView resultText;

    private LoginInfo loginInfo;

    @BindViews({ R.id.btnLogin, R.id.btnCancel, R.id.textViewResult }) List<View> buttonList;

    private static final Action<View> ALPHA_FADE = (view, index) -> {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setFillBefore(true);
        alphaAnimation.setDuration(500);
        alphaAnimation.setStartOffset(index * 100);
        view.startAnimation(alphaAnimation);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loginInfo = new LoginInfo();
        showSpinner();
    }

    private void showSpinner() {
        initArrayDevices();
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, devices);
        // Specify the layout to use when the list of choices appears
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(dataAdapter);
    }

    /*static final ButterKnife.Action<View> DISABLE = new ButterKnife.Action<View>() {
        @Override public void apply(View view, int index) {
            view.setEnabled(false);
        }
    };
    static final ButterKnife.Setter<View, Boolean> ENABLED = new ButterKnife.Setter<View, Boolean>() {
        @Override public void set(View view, Boolean value, int index) {
            view.setEnabled(value);
        }
    };*/

    @OnItemSelected(R.id.spinner)
    public void spinnerItemSelected(Spinner spinner, int position) {
        if(spinner.getSelectedItem() != null) {
            loginInfo.setDevice((String) spinner.getSelectedItem());
        }
    }

    @OnClick({ R.id.btnLogin, R.id.btnCancel }) void onClickBtn(Button button) {
        switch (button.getId()) {
            case R.id.btnLogin:
                if (isLoginAndPassNotEmpty()) {
                    btnOkClick();
                    showLoginActivity();
                }
                break;
            case R.id.btnCancel:
                btnCancelClick();
                ViewCollections.run(buttonList, ALPHA_FADE);
                break;
        }
    }

    private void showLoginActivity() {
        loginInfo.setLogin(editTextLogin.getText().toString());
        loginInfo.setPassword(editTextPass.getText().toString());

        Intent resultIntent = new Intent(this, ResultActivity.class);
        resultIntent.putExtra(LOGIN_INFO, loginInfo);
        startActivity(resultIntent);
    }

    private void btnOkClick() {
        resultText.setText(editTextPass.getText());
        changeBgColor(Color.YELLOW);
        if (loginInfo.getDevice().equals(devices.get(0))){
            loginInfo.setDevice(Build.MODEL);
        }
    }

    //TODO need set spinner index 0
    private void btnCancelClick() {
        editTextLogin.setText("");
        editTextPass.setText("");
        resultText.setText("");
        changeBgColor(Color.WHITE);
        editTextLogin.requestFocus();
    }

    private void changeBgColor(Integer color) {
        View mainView = findViewById(R.id.container);
        mainView.setBackgroundColor(color);
    }

    //TODO need refactoring method
    private boolean isLoginAndPassNotEmpty() {
        boolean result = false;
        if (editTextLogin.getText().toString().trim().equals("")) {
            showMassage(getResources().getString(R.string.login_required));
            editTextLogin.setText("");
            editTextLogin.requestFocus();
            return result;
        }
        if (editTextPass.getText().toString().trim().equals("")) {
            showMassage(getResources().getString(R.string.password_required));
            editTextPass.setText("");
            editTextPass.requestFocus();
            return result;
        }
        return true;
    }

    private void showMassage(String text) {
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void initArrayDevices() {
        devices = new ArrayList<String>();
        devices.add("--same--");
        devices.add("IPhone SE");
        devices.add("IPad");
        devices.add("MacBook 15");
        devices.add("MacBook Air");
        devices.add("Nokia");
        devices.add("Asus");
    }
}
