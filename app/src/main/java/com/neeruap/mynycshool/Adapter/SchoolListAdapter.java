package com.neeruap.mynycshool.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neeruap.mynycshool.Model.School;
import com.neeruap.mynycshool.R;
import com.neeruap.mynycshool.Util.MyNYCSchoolLogs;

import java.util.List;

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListViewHolder> {
        Context context;
        List<School> schoolList;
        int schoolListNamesPosition;


    public SchoolListAdapter(Context context, List<School> schoolList) {
        this.context = context;
        this.schoolList = schoolList;
        this.schoolListNamesPosition = schoolListNamesPosition;
        MyNYCSchoolLogs.d("called Recycler view adapter");
    }

    @NonNull
    @Override
    public SchoolListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyNYCSchoolLogs.d("School List Adapter called");
        View view = LayoutInflater.from(context).inflate(R.layout.school_list_card_item_layout, parent,false);
        SchoolListViewHolder allSchoolListViewHolder = new SchoolListViewHolder(context, view, schoolList);
        return allSchoolListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolListViewHolder holder, int position) {

        MyNYCSchoolLogs.d("Value for School list"+ schoolList.get(position).getSchool_name());
        holder.schoolListTextname.setText(schoolList.get(position).getSchool_name());
        holder.schoolListTextGrade.setText(schoolList.get(position).getFinalgrades());

    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
