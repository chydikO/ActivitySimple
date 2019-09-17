package com.example.activitysimple;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Ссылки из урока:
 *
 *     View – элементы интерфейса (кнопки, поля, виджеты и пр.)  http://developer.android.com/reference/android/view/View.html
 *     ViewGroup – контейнер для других контейнеров или компонентов http://developer.android.com/reference/android/view/ViewGroup.html
 *     Документация с фильтрацией по API Level http://developer.android.com/reference/android/view/ViewGroup.html
 *
 *
 *
 * Домашнее задание:
 *
 *     Добавить кнопку «Очистить», которая будет очищать текстовые поля
 *     Под кнопками расположить изображение замка
 *     Изменить цвет фона главного окна
 */

public class MainActivity extends AppCompatActivity {

    Button btnOk;
    Button btnCancel;
    EditText editTextLogin;
    EditText getEditTextPass;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);
        editTextLogin = findViewById(R.id.textViewLogin);
        getEditTextPass = findViewById(R.id.textViewPass);
        resultText = findViewById(R.id.textViewResult);

        btnOk.setOnClickListener(clickListener);
        btnCancel.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            if(v.getId() == R.id.btnOk) {
                btnOkClick();
            } else if(v.getId() == R.id.btnCancel) {
                btnCancelClick();
            }
        }
    };

    private void btnOkClick() {
        resultText.setText(getEditTextPass.getText());
        changeBgColor(Color.BLUE);
    }

    private void btnCancelClick() {
        editTextLogin.setText("");
        getEditTextPass.setText("");
        resultText.setText("");
        changeBgColor(Color.WHITE);
    }

    private void changeBgColor(Integer color) {
        View mainView = findViewById(R.id.container);
        mainView.setBackgroundColor(color);
    }
}
