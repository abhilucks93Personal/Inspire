package com.viscocits.redeem.catalogue;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.viscocits.redeem.R;
import com.viscocits.redeem.retrofit.RetrofitApi;
import com.viscocits.redeem.utils.Constants;
import com.viscocits.redeem.utils.GlideHelper;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    private final Activity activity;
    private final RetrofitApi.ResponseListener responseListener;
    private List<ModelGetAllProductsData> products;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName, tvPoints;
        TextView tvAddToBasket, tvAddToWishlist;
        ImageView ivProduct;

        MyViewHolder(View view) {
            super(view);

            tvProductName = view.findViewById(R.id.tv_product_name);
            tvPoints = view.findViewById(R.id.tv_points);
            tvAddToBasket = view.findViewById(R.id.tv_add_to_basket);
            tvAddToWishlist = view.findViewById(R.id.tv_add_to_wishlist);
            ivProduct = view.findViewById(R.id.iv_product);

        }
    }

    public ProductsAdapter(Activity activity, RetrofitApi.ResponseListener responseListener, List<ModelGetAllProductsData> products) {
        this.products = products;
        this.activity = activity;
        this.responseListener = responseListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_products, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ModelGetAllProductsData product = products.get(position);

        holder.tvProductName.setText(product.getName());

        int price = product.getClientPrice().intValue();
        holder.tvPoints.setText(String.format("%s points", price));

        GlideHelper.loadImageUrl(holder.ivProduct, product.getImageName());

        holder.tvAddToBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitApi.getInstance().addToBasket(activity, responseListener, product.getProductId().intValue(), product.getCode(), 1, Constants.DEFAULT_CAMPAIGN_ID, Constants.DEFAULT_USER_ID);
            }
        });

        holder.tvAddToWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitApi.getInstance().addToWishlist(activity, responseListener, product.getProductId().intValue(), 1, Constants.DEFAULT_CAMPAIGN_ID, Constants.DEFAULT_USER_ID);
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}