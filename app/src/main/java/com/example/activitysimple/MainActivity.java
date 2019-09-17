package com.example.activitysimple;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @BindView(R.id.btnOk) Button btnOk;
    @BindView(R.id.btnCancel) Button btnCancel;
    @BindView(R.id.textViewLogin) EditText editTextLogin;
    @BindView(R.id.textViewPass) EditText getEditTextPass;
    @BindView(R.id.textViewResult) TextView resultText;

    @BindViews({ R.id.btnOk, R.id.btnCancel, R.id.textViewResult }) List<View> buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ButterKnife.apply(buttonList, DISABLE);

    }

    static final ButterKnife.Action<View> DISABLE = new ButterKnife.Action<View>() {
        @Override public void apply(View view, int index) {
            view.setEnabled(false);
        }
    };
    static final ButterKnife.Setter<View, Boolean> ENABLED = new ButterKnife.Setter<View, Boolean>() {
        @Override public void set(View view, Boolean value, int index) {
            view.setEnabled(value);
        }
    };

    @OnClick(R.id.btnOk) void onClickBtnOk() {
        btnOkClick();
    }

    @OnClick(R.id.btnCancel) void onClickBtnCancel() {
        btnCancelClick();

    }

    private void btnOkClick() {
        resultText.setText(getEditTextPass.getText());
        changeBgColor(Color.YELLOW);
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
