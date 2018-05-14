package com.viscocits.redeem.catalogue;

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
import com.viscocits.redeem.utils.Utility;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by abhi on 24/03/18.
 */

public class HomeFragment extends Fragment implements RetrofitApi.ResponseListener {


    private ProgressBar progressBar;
    private TextView tvNoProducts;
    ProductsAdapter productsAdapter;
    RecyclerView rvProducts;
    private ArrayList<ModelGetAllProductsData> products = new ArrayList<>();
    LinearLayout llProducts;
    private TextView tvWelcomeText, tvCreditBalance;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initUi(view);

        initData();

        return view;

    }

    private void initData() {

        ModelLoginData userData = Utility.getPreferenceProfileData(getActivity());
        if (userData != null) {
            tvWelcomeText.setText(String.format("Welcome %s", userData.getForename()));
            tvCreditBalance.setText(String.format(Locale.getDefault(), "My Balance : %d Credits", (int) userData.getCurrentBalance()));
        }

        RetrofitApi.getInstance().getFeaturedProducts(getActivity(), progressBar, tvNoProducts, this, Constants.DEFAULT_USER_ID);
    }

    private void initUi(View view) {

        progressBar = view.findViewById(R.id.progressBar);
        tvNoProducts = view.findViewById(R.id.tv_no_products);
        llProducts = view.findViewById(R.id.ll_products);
        tvWelcomeText = view.findViewById(R.id.tv_welcome_text);
        tvCreditBalance = view.findViewById(R.id.tv_credit_balance);

        rvProducts = view.findViewById(R.id.rvProducts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvProducts.setLayoutManager(layoutManager);
        productsAdapter = new ProductsAdapter(getActivity(), this, products);
        rvProducts.setAdapter(productsAdapter);
    }

    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }

    @Override
    public void _onNext(Object obj) {
        if (obj instanceof ModelGetAllProductsResponse) {
            ModelGetAllProductsResponse response = (ModelGetAllProductsResponse) obj;
            llProducts.setVisibility(View.VISIBLE);
            products.clear();
            products.addAll(response.getData());
            productsAdapter.notifyDataSetChanged();
        }
    }


}
