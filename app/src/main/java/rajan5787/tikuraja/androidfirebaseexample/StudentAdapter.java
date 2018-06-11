package rajan5787.tikuraja.androidfirebaseexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rajanpipaliya on 11/06/18.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    private List<Student> studentList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student Student = studentList.get(position);
        holder.name.setText(Student.getName());
        holder.email.setText(Student.getEmail());
        holder.number.setText(Student.getNumber());
        holder.standard.setText(Student.getStandard());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email, number, standard;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.item_name);
            email = (TextView) view.findViewById(R.id.item_email);
            number = (TextView) view.findViewById(R.id.item_number);
            standard = (TextView) view.findViewById(R.id.item_standard);

        }
    }


    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }


}

