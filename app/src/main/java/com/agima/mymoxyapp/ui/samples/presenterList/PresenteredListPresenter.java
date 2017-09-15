package com.agima.mymoxyapp.ui.samples.presenterList;


import com.agima.mymoxyapp.ui.samples.list.model.Student;
import com.agima.mymoxyapp.ui.samples.presenterList.adapter.PresenteredListAdapter;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class PresenteredListPresenter extends MvpPresenter<PresenteredListView>{

    public void setList(PresenteredListAdapter presenteredListAdapter) {
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

        presenteredListAdapter.setItems(students);
        getViewState().setAdapter(presenteredListAdapter);
    }

}
