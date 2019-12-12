package com.dipak.esoftwarica.ui.add_student;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dipak.esoftwarica.R;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.StudentDetailsViewHolders> {

    Context mContext;
    List<StudentViewModel> studentViewModelList;
     int img;

    public ViewAdapter(Context mContext, List<StudentViewModel> studentViewModelList) {
        this.mContext = mContext;
        this.studentViewModelList = studentViewModelList;
    }

    @NonNull
    @Override
    public StudentDetailsViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_details,parent,false);
        return new StudentDetailsViewHolders(view,mContext,studentViewModelList);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentDetailsViewHolders holder, final int position) {


        StudentViewModel studentViewModel=studentViewModelList.get(position);
        String Gender=studentViewModel.getGender();

        if (Gender.equals("Male")){
            img=R.drawable.person;
        }else if (Gender.equals("Female")){
            img=R.drawable.female;
        }else if (Gender.equals("Others")) {
            img=R.drawable.other;
        }

        int age=studentViewModel.getAge();
        holder.imgage.setImageResource(img);
        holder.tvName.setText(studentViewModel.getName());
        holder.tvAge.setText(studentViewModel.getAge()+"");
        holder.tvAddress.setText(studentViewModel.getAddress());
        holder.tvGender.setText(studentViewModel.getGender());


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentViewModelList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentViewModelList.size();
    }

    public class StudentDetailsViewHolders extends RecyclerView.ViewHolder {

        private TextView tvName,tvAge,tvAddress,tvGender;
        ImageView imgage;
        private Button btnDelete;

        public StudentDetailsViewHolders(@NonNull View itemView, final Context context, final List<StudentViewModel>studentViewModelList) {
            super(itemView);

            btnDelete=itemView.findViewById(R.id.btndelete);
            tvName=itemView.findViewById(R.id.tvname);
            tvAge=itemView.findViewById(R.id.tvage);
            tvAddress=itemView.findViewById(R.id.tvaddress);
            tvGender=itemView.findViewById(R.id.tvgender);
            imgage=itemView.findViewById(R.id.img1);

        }
    }
}
