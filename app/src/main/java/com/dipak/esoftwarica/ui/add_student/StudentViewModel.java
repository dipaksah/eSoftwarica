package com.dipak.esoftwarica.ui.add_student;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class StudentViewModel extends ViewModel {


    static List<StudentViewModel> liststudent=new ArrayList<>();
    private String name,gender,address;
    private int age;

    public StudentViewModel(String name, String gender, String address, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public static List<StudentViewModel> getListstudent() {
        return liststudent;
    }

    public static void setListstudent(List<StudentViewModel> liststudent) {
        StudentViewModel.liststudent = liststudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}