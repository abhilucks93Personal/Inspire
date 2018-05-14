package com.viscocits.redeem.catalogue;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
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

public class CartFragment extends Fragment implements RetrofitApi.ResponseListener {


    private ProgressBar progressBar;
    private CartAdapter cartAdapter;
    private ArrayList<ModelGetCartDetailsData> products = new ArrayList<>();
    private TextView tvFooterTotal;
    private LinearLayout llFooter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        initUi(view);

        initData();

        return view;
    }

    private void initData() {
        getCartItems();
    }

    private void getCartItems() {
        RetrofitApi.getInstance().getCartDetails(getActivity(), progressBar, this, Constants.DEFAULT_USER_ID, Constants.DEFAULT_CAMPAIGN_ID);
    }

    private void initUi(View view) {

        progressBar = view.findViewById(R.id.progressBar);

        RecyclerView rvProducts = view.findViewById(R.id.rvCartProducts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvProducts.setLayoutManager(layoutManager);
        cartAdapter = new CartAdapter(getActivity(), this, this, products);
        rvProducts.setAdapter(cartAdapter);

        llFooter = view.findViewById(R.id.ll_footer);
        tvFooterTotal = view.findViewById(R.id.tv_total);
        TextView tvConfirm = view.findViewById(R.id.tv_confirm);
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ConfirmOrderActivity.class)
                        .putParcelableArrayListExtra("data", products));
            }
        });

        updateFooter();

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
                products.clear();
                products.addAll(response.getData());
                cartAdapter.notifyDataSetChanged();
                updateFooter();
            }
        }

    }

    private void updateFooter() {
        if (products.size() == 0) {
            llFooter.setVisibility(View.GONE);
            return;
        }

        int totalAmount = 0;
        for (ModelGetCartDetailsData item : products) {
            totalAmount += (item.getQuantity() * item.getPricePaid());
        }
        if (totalAmount > 0) {
            llFooter.setVisibility(View.VISIBLE);
            tvFooterTotal.setText(new StringBuilder().append("Total : ").append(totalAmount).append(" Points").toString());
        }
    }

    public void removeItem(int position) {
        if (position < products.size()) {
            products.remove(position);
            cartAdapter.notifyDataSetChanged();
            updateFooter();
        }
    }

    public void updateItem(int quantity, int position) {
        if (position < products.size()) {
            products.get(position).setQuantity(quantity);
            cartAdapter.notifyDataSetChanged();
            updateFooter();
        }
    }
}