package com.neeruap.mynycshool.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neeruap.mynycshool.Model.School;
import com.neeruap.mynycshool.R;

import java.util.List;

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListViewHolder> {
        Context context;
        List<School> schoolList;
        int schoolListNamesPosition;


    public SchoolListAdapter(Context context, List<School> schoolList) {
        this.context = context;
        this.schoolList = schoolList;
        this.schoolListNamesPosition = schoolListNamesPosition;
    }

    @NonNull
    @Override
    public SchoolListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.school_list_card_item_layout, null);
        SchoolListViewHolder homeProductsViewHolder = new SchoolListViewHolder(context, view, schoolList);
        return homeProductsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolListViewHolder holder, int position) {

        holder.schoolListTextname.setText(schoolList.get(position).getSchool_name());
        holder.schoolListTextGrade.setText(schoolList.get(position).getFinalgrades());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
