package com.agima.mymoxyapp.ui.samples.presenterList.item;

import android.graphics.Color;

import com.agima.mymoxyapp.ui.samples.list.model.Student;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Random;

@InjectViewState
public class ItemPresenter extends MvpPresenter<ItemView> {
    private static Integer counter = 0;

    private Integer counterVal;

    private Student student;

    private int color;

    public ItemPresenter(Student student) {
        this.student = student;
        this.counterVal = counter++;
    }

    public void bind() {
        getViewState().setName(student.getName());
        getViewState().setSecondName(student.getSurname());
        getViewState().setCounterText(String.valueOf(counterVal));
        getViewState().setColor(color);
    }

    public void changeColor() {
        color = getRandomColor();
        getViewState().setColor(color);
    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
