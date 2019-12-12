package com.dipak.esoftwarica.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dipak.esoftwarica.DashboardActivity;
import com.dipak.esoftwarica.R;
import com.dipak.esoftwarica.ui.add_student.StudentViewModel;
import com.dipak.esoftwarica.ui.add_student.ViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    public static List<StudentViewModel> studentslist=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.recycler);

        StudentViewModel studentViewModel=new StudentViewModel("dipak","Male","ktm",22);
        studentslist=studentViewModel.getListstudent();
        if (studentslist.isEmpty()){
            studentslist.add(new StudentViewModel("Dip","Male","pokhara",23));
            studentslist.add(new StudentViewModel("sita","Female","janakpur",15));
        }

        ViewAdapter viewAdapter=new ViewAdapter(getActivity(), studentslist);
        recyclerView.setAdapter(viewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;


    }
}

