package com.viscocits.redeem.catalogue;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.viscocits.redeem.R;
import com.viscocits.redeem.retrofit.RetrofitApi;
import com.viscocits.redeem.utils.GlideHelper;

import java.util.List;
import java.util.Locale;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.MyViewHolder> {

    private final Activity activity;
    private List<ModelGetWishlistDetailsData> products;
    private WishlistFragment fragment;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName, tvProductCode;
        TextView tvRemove, tvMove;
        ImageView ivProduct;

        MyViewHolder(View view) {
            super(view);

            tvProductName = view.findViewById(R.id.tv_product_name);
            tvProductCode = view.findViewById(R.id.tv_code);
            tvRemove = view.findViewById(R.id.tv_remove);
            tvMove = view.findViewById(R.id.tv_move);
            ivProduct = view.findViewById(R.id.iv_product);

        }
    }


    public WishlistAdapter(Activity activity, Fragment fragment, RetrofitApi.ResponseListener responseListener, List<ModelGetWishlistDetailsData> products) {
        this.products = products;
        this.activity = activity;
        this.fragment = (WishlistFragment) fragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_wishlist, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final ModelGetWishlistDetailsData product = products.get(position);

        holder.tvProductName.setText(product.getProductName());
        holder.tvProductCode.setText(product.getProductCode());


        GlideHelper.loadImageUrl(holder.ivProduct, product.getImageName());

        holder.tvRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity != null) {

                    fragment.removeItem(position, false);
                }
            }
        });

        holder.tvMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.removeItem(position, true);
            }
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}