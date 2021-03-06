package com.viscocits.redeem.catalogue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viscocits.redeem.R;
import com.viscocits.redeem.retrofit.RetrofitApi;

/**
 * Created by abhi on 24/03/18.
 */

public class ProfileFragment extends Fragment implements RetrofitApi.ResponseListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

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
