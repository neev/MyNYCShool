package com.neeruap.mynycshool.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.neeruap.mynycshool.Model.School;
import com.neeruap.mynycshool.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchoolListViewHolder  extends RecyclerView.ViewHolder{
    @BindView(R.id.school_list_cardview) CardView schoolListCardView;
    @BindView(R.id.school_list_text_name) TextView schoolListTextname;
    @BindView(R.id.school_list_grade_text) TextView schoolListTextGrade;

    public SchoolListViewHolder(final Context context, View itemView, List<School> schoolList) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
