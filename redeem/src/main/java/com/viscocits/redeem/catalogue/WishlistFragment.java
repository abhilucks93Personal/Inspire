package com.viscocits.redeem.catalogue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.viscocits.redeem.R;
import com.viscocits.redeem.retrofit.RetrofitApi;
import com.viscocits.redeem.utils.Constants;

import java.util.ArrayList;

/**
 * Created by abhi on 24/03/18.
 */

public class WishlistFragment extends Fragment implements RetrofitApi.ResponseListener {


    private ProgressBar progressBar;
    private WishlistAdapter wishlistAdapter;
    private ArrayList<ModelGetWishlistDetailsData> products = new ArrayList<>();
    private int curUpdatePos = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);

        initUi(view);

        initData();

        return view;
    }

    private void initData() {
        getWishListItems();
    }

    private void getWishListItems() {
        RetrofitApi.getInstance().getWishListDetails(getActivity(), progressBar, this, Constants.DEFAULT_USER_ID, Constants.DEFAULT_CAMPAIGN_ID);
    }

    private void initUi(View view) {

        progressBar = view.findViewById(R.id.progressBar);

        RecyclerView rvProducts = view.findViewById(R.id.rvCartProducts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvProducts.setLayoutManager(layoutManager);
        wishlistAdapter = new WishlistAdapter(getActivity(), this, this, products);
        rvProducts.setAdapter(wishlistAdapter);


    }


    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }

    @Override
    public void _onNext(Object obj) {
        if (obj instanceof ModelGetWishlistDetailsResponse) {
            ModelGetWishlistDetailsResponse response = (ModelGetWishlistDetailsResponse) obj;
            if (response.getStatusCode().equals("200") && response.getData() != null) {
                products.clear();
                products.addAll(response.getData());
                wishlistAdapter.notifyDataSetChanged();
            }
        } else if (obj instanceof ModelGetCartDetailsResponse) {
            ModelGetCartDetailsResponse response = (ModelGetCartDetailsResponse) obj;
           /* if (response.getStatusCode().equals("200") && response.getData() != null) {
                products.clear();
                products.addAll(response.getData());
                wishlistAdapter.notifyDataSetChanged();
            }*/

            if (curUpdatePos >= 0) {
                if (curUpdatePos < products.size()) {
                    products.remove(curUpdatePos);
                    wishlistAdapter.notifyDataSetChanged();
                }
            }
        }

    }


    public void removeItem(int position, boolean isMove) {

        curUpdatePos = position;
        if (isMove)
            RetrofitApi.getInstance().addToBasket(getActivity(), this, products.get(position).getProductId(), products.get(position).getProductCode(), 1, Constants.DEFAULT_CAMPAIGN_ID, Constants.DEFAULT_USER_ID);
        else if (position < products.size()) {
            products.remove(position);
            wishlistAdapter.notifyDataSetChanged();
        }
    }


}