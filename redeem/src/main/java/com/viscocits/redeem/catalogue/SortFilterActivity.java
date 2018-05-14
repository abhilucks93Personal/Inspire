package com.viscocits.redeem.catalogue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.viscocits.redeem.R;
import com.viscocits.redeem.retrofit.RetrofitApi;
import com.viscocits.redeem.utils.Utility;
import com.warkiz.widget.IndicatorSeekBar;


/**
 * Created by abhi on 24/03/18.
 */

public class SortFilterActivity extends Activity implements RetrofitApi.ResponseListener {


    private int userId = -1;
    private TextView tvSortAsc, tvSortDesc;
    private String sortCol = "", brandNames = "";
    int pointsFrom, pointsTo;
    public final String ASC_SORT = "Point_Asc";
    public final String DSC_SORT = "Point_Desc";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sort_filter);

        initUi();

        initData();
    }


    private void initData() {

        ModelLoginData userData = Utility.getPreferenceProfileData(SortFilterActivity.this);
        int currentBalance = (int) userData.getCurrentBalance();

        sortCol = getIntent().getStringExtra("sort");
        brandNames = getIntent().getStringExtra("brandNames");
        pointsFrom = getIntent().getIntExtra("pointsFrom", 0);
        pointsTo = getIntent().getIntExtra("pointsTo", currentBalance);

        setSortUi();

    }

    private void setSortUi() {
        switch (sortCol) {
            case ASC_SORT:
                tvSortAsc.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                tvSortDesc.setTextColor(getResources().getColor(R.color.colorGrey));
                break;

            case DSC_SORT:
                tvSortDesc.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                tvSortAsc.setTextColor(getResources().getColor(R.color.colorGrey));
                break;
        }
    }

    private void initUi() {

        ImageView ivCross = findViewById(R.id.ivCross);
        ivCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        tvSortAsc = findViewById(R.id.tv_sort_asc);
        tvSortAsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sortCol = ASC_SORT;
                setSortUi();

            }
        });
        tvSortDesc = findViewById(R.id.tv_sort_desc);
        tvSortDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortCol = DSC_SORT;
                setSortUi();
            }
        });

        final TextView tvPoints = findViewById(R.id.tvPoints);

        IndicatorSeekBar indicatorSeekBar = findViewById(R.id.indicatorSeekBar);
        // indicatorSeekBar.setMax(pointsTo);
        //indicatorSeekBar.setProgress(pointsTo);

        indicatorSeekBar.setOnSeekChangeListener(new IndicatorSeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(IndicatorSeekBar seekBar, int progress, float progressFloat, boolean fromUserTouch) {
                tvPoints.setText(String.format("0 - %d", progress));
                pointsTo = progress;
            }

            @Override
            public void onSectionChanged(IndicatorSeekBar seekBar, int thumbPosOnTick, String textBelowTick, boolean fromUserTouch) {

            }

            @Override
            public void onStartTrackingTouch(IndicatorSeekBar seekBar, int thumbPosOnTick) {

            }

            @Override
            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {

            }
        });


    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent();
        intent.putExtra("sort", sortCol);
        intent.putExtra("pointFrom", pointsFrom);
        intent.putExtra("pointTo", pointsTo);
        intent.putExtra("brandNames", brandNames);
        setResult(RESULT_OK, intent);

        super.onBackPressed();
    }

    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }

    @Override
    public void _onNext(Object obj) {

    }
}