package com.dipak.esoftwarica.ui.add_student;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dipak.esoftwarica.DashboardActivity;
import com.dipak.esoftwarica.R;
import com.dipak.esoftwarica.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {

    private Button btnSave;
    private TextView tvName,tvAge,tvAddress;
    private RadioButton rdoMale,rdoFemale,rdoOthers;
    String Gender;
    private RadioGroup rdoGroup;
    private static List<StudentViewModel> studentViewModelList=new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_student, container, false);
        btnSave=view.findViewById(R.id.btnsave);
        tvName=view.findViewById(R.id.etFullname);
        tvAge=view.findViewById(R.id.etAge);
        tvAddress=view.findViewById(R.id.etAddress);
        rdoMale=view.findViewById(R.id.rbMale);
        rdoFemale=view.findViewById(R.id.rbFemale);
        rdoOthers=view.findViewById(R.id.rbOthers);
        rdoGroup=view.findViewById(R.id.rdoGrp);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnsave) {
                    if (TextUtils.isEmpty(tvName.getText().toString())) {
                        tvName.setError("Please Enter Name");
                        tvName.requestFocus();
                        return;
                    } else if (TextUtils.isEmpty(tvAge.getText().toString())) {
                        tvAge.setError("Enter age");
                        tvAge.requestFocus();
                        return;
                    } else if (TextUtils.isEmpty(tvAddress.getText().toString())) {
                        tvAddress.setError("Please Enter address");
                        tvAddress.requestFocus();
                    }


                    String name = tvName.getText().toString();
                    String address = tvAddress.getText().toString();
                    int age = Integer.parseInt(tvAge.getText().toString());

                    if (rdoMale.isChecked()) {
                        Gender = "Male";
                    } else if (rdoFemale.isChecked()) {
                        Gender = "Female";
                    } else if (rdoOthers.isChecked()) {
                        Gender = "Others";
                    }

                    StudentViewModel studentViewModel = new StudentViewModel(name, Gender, address, age);
                    studentViewModelList = studentViewModel.getListstudent();
                    studentViewModelList.add(studentViewModel);
                    Toast.makeText(getActivity(), "Added sucessfully", Toast.LENGTH_LONG).show();
                    tvName.setText("");
                    tvAddress.setText("");
                    tvAge.setText("");
                    rdoMale.setChecked(false);
                    rdoFemale.setChecked(false);
                    rdoOthers.setChecked(false);
                }
            }
        });

        return view;
    }

}