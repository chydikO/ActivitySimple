package com.example.activitysimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
