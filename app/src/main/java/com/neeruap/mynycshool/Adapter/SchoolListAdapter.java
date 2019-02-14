package com.neeruap.mynycshool.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentActivity;
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
    public void onBindViewHolder(@NonNull SchoolListViewHolder holder, final int position) {

        MyNYCSchoolLogs.d("Value for School list"+ schoolList.get(position).getSchool_name());
        holder.schoolListTextname.setText(schoolList.get(position).getSchool_name());
        holder.schoolListTextGrade.setText(schoolList.get(position).getFinalgrades());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selected_school_Id = schoolList.get(position).getDbn();

                BottomSheetDialogFragment bottomSheetDialogFragment = new BottomsheetDialog();
                bottomSheetDialogFragment.show(((FragmentActivity)context).getSupportFragmentManager(), bottomSheetDialogFragment.getTag());


            }
        });

    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    // bottom sheet class

    public static class BottomsheetDialog extends BottomSheetDialogFragment {

        private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {

            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    dismiss();
                }

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        };

        @Override
        public void setupDialog(Dialog dialog, int style) {
            super.setupDialog(dialog, style);
            View contentView = View.inflate(getContext(), R.layout.sat_score_bottom_sheet_layout, null);
            dialog.getWindow().setBackgroundDrawable( new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.setContentView(contentView);

            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();

            //params.height = 1000;
            params.setMargins(50,50,50,50);

            CoordinatorLayout.Behavior behavior = params.getBehavior();
            ((View) contentView.getParent()).setBackgroundColor(Color.TRANSPARENT);



            if (behavior != null && behavior instanceof BottomSheetBehavior) {

                ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
            }
        }
    }
}
