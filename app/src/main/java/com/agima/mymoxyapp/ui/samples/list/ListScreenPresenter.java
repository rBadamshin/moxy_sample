package com.agima.mymoxyapp.ui.samples.list;

import android.graphics.Color;

import com.agima.mymoxyapp.R;
import com.agima.mymoxyapp.ui.samples.list.list.ListAdapter;
import com.agima.mymoxyapp.ui.samples.list.list.ListAdapterDelegate;
import com.agima.mymoxyapp.ui.samples.list.model.Student;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@InjectViewState
public class ListScreenPresenter extends MvpPresenter<ListScreenView> implements ListAdapterDelegate {

    //private ListAdapter adapter;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().setTitle("Список");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Петя", "Чеканчин"));
        students.add(new Student("Телефон", "Андроидов"));
        students.add(new Student("Телефон", "Айосов"));
        students.add(new Student("Разработчик", "Хайподрайвер"));
        students.add(new Student("Разработчик", "Флегматик"));
        students.add(new Student("Имя", "Фамилия"));
        students.add(new Student("Разработчик", "Разработчиков"));
        students.add(new Student("Инженер", "Инженеров"));
        students.add(new Student("Максим", "Мартынов"));
        students.add(new Student("Петя", "Чеканчин"));
        students.add(new Student("Телефон", "Андроидов"));
        students.add(new Student("Телефон", "Айосов"));
        students.add(new Student("Разработчик", "Хайподрайвер"));
        students.add(new Student("Разработчик", "Флегматик"));
        students.add(new Student("Имя", "Фамилия"));
        students.add(new Student("Разработчик", "Разработчиков"));
        students.add(new Student("Инженер", "Инженеров"));
        students.add(new Student("Максим", "Мартынов"));
        students.add(new Student("Петя", "Чеканчин"));
        students.add(new Student("Телефон", "Андроидов"));
        students.add(new Student("Телефон", "Айосов"));
        students.add(new Student("Разработчик", "Хайподрайвер"));
        students.add(new Student("Разработчик", "Флегматик"));
        students.add(new Student("Имя", "Фамилия"));
        students.add(new Student("Разработчик", "Разработчиков"));
        students.add(new Student("Инженер", "Инженеров"));
        students.add(new Student("Максим", "Мартынов"));
        students.add(new Student("Петя", "Чеканчин"));
        students.add(new Student("Телефон", "Андроидов"));
        students.add(new Student("Телефон", "Айосов"));
        students.add(new Student("Разработчик", "Хайподрайвер"));
        students.add(new Student("Разработчик", "Флегматик"));
        students.add(new Student("Имя", "Фамилия"));
        students.add(new Student("Разработчик", "Разработчиков"));
        students.add(new Student("Инженер", "Инженеров"));
        students.add(new Student("Максим", "Мартынов"));

        ListAdapter adapter = new ListAdapter(students, this);
        getViewState().setAdapter(adapter);
    }

    @Override
    public void onClick(int position, int color) {
        getViewState().showMessage(R.string.item_clicked, position);
    }

    @Override
    public int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
