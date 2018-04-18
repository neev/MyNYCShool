package com.neeruap.mynycshool;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.neeruap.mynycshool.Adapter.SchoolListAdapter;
import com.neeruap.mynycshool.Model.School;
import com.neeruap.mynycshool.Retrofit.RetrofitApiInterface;
import com.neeruap.mynycshool.Util.MyNYCSchoolLogs;
import com.neeruap.mynycshool.Util.NYCApiCallRequest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.school_list_recyclerview) RecyclerView schoolListRecyclerView;
    public static int schoolNameListPosition;
    List<School> allSchoolList = new ArrayList<>();
    private int startVal = 10;
    private int offSetVal = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        // call api to get the school data
        loadData();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadData(){
        MyNYCSchoolLogs.d("loadData() is called startVal: "+startVal +" and offsetVal: "+offSetVal);

        // initialize an instance of the RetroApiInterface interface
        RetrofitApiInterface apiInterface = NYCApiCallRequest.getRetroApiClient();
        // Retrofit helps us to parse the JSON response to a list of Java objects
        Call<List<School>> call = apiInterface.getSchools(NYCApiCallRequest.API_KEY, startVal,offSetVal);
        MyNYCSchoolLogs.d("loadData() is called");
        call.enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(@NonNull Call<List<School>> call, @NonNull Response<List<School>> response) {
                MyNYCSchoolLogs.d("Successfully loaded the requested data ");
                allSchoolList = response.body();
                MyNYCSchoolLogs.d("school Name : "+ allSchoolList.get(0).getSchool_name());
                MyNYCSchoolLogs.d("school List size : "+ allSchoolList.size());
                showResults(allSchoolList);

            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                MyNYCSchoolLogs.d("onFailure: "+ t.toString());
            }
        });
    }

    private void showResults(List<School> list){


        schoolListRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        schoolListRecyclerView.setItemAnimator( new DefaultItemAnimator());
        schoolListRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        MyNYCSchoolLogs.d("call Recycler view adapter");
        schoolListRecyclerView.setAdapter(new SchoolListAdapter(this,list));

    }


}
