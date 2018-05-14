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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    private final Activity activity;
    private List<ModelGetCartDetailsData> products;
    private CartFragment fragment;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName, tvPoints, tvPointsTotal, tvQuantity;
        TextView tvRemove, tvIncrement, tvDecrement;
        ImageView ivProduct;

        MyViewHolder(View view) {
            super(view);

            tvProductName = view.findViewById(R.id.tv_product_name);
            tvPoints = view.findViewById(R.id.tv_points);
            tvQuantity = view.findViewById(R.id.tv_quantity);
            tvPointsTotal = view.findViewById(R.id.tv_points_total);
            tvRemove = view.findViewById(R.id.tv_remove);
            tvDecrement = view.findViewById(R.id.tv_decrement);
            tvIncrement = view.findViewById(R.id.tv_increment);
            ivProduct = view.findViewById(R.id.iv_product);

        }
    }


    public CartAdapter(Activity activity, Fragment fragment, RetrofitApi.ResponseListener responseListener, List<ModelGetCartDetailsData> products) {
        this.products = products;
        this.activity = activity;
        this.fragment = (CartFragment) fragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final ModelGetCartDetailsData product = products.get(position);

        holder.tvProductName.setText(product.getName());
        holder.tvQuantity.setText(String.valueOf(product.getQuantity()));
        holder.tvPoints.setText(new StringBuilder().append(product.getQuantity()).append(" x ").append(product.getPricePaid().intValue()).append(" Points").toString());
        holder.tvPointsTotal.setText(String.format(Locale.ENGLISH, "%d Points", product.getTotalAmount()));

        GlideHelper.loadImageUrl(holder.ivProduct, product.getImageName());

        holder.tvRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity != null) {

                    fragment.removeItem(position);
                }
            }
        });

        holder.tvIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity != null) {
                    fragment.updateItem(product.getQuantity() + 1, position);
                }
            }
        });

        holder.tvDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity != null && product.getQuantity() > 1) {
                    fragment.updateItem(product.getQuantity() - 1, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}