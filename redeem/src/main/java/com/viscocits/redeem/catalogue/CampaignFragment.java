package com.viscocits.redeem.catalogue;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.viscocits.redeem.R;
import com.viscocits.redeem.retrofit.RetrofitApi;
import com.viscocits.redeem.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhi on 24/03/18.
 */

public class CampaignFragment extends Fragment implements RetrofitApi.ResponseListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_campaign, container, false);

        initUi(view);

        initData();

        return view;

    }

    private void initData() {
    }


    private void initUi(View view) {


    }


    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }

    @Override
    public void _onNext(Object obj) {
        if (obj instanceof ModelGetCartDetailsResponse) {
            ModelGetCartDetailsResponse response = (ModelGetCartDetailsResponse) obj;
            if (response.getStatusCode().equals("200") && response.getData() != null) {

            }
        }
    }


}
