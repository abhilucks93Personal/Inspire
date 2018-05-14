package com.viscocits.inspire;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.viscocits.redeem.catalogue.CartFragment;
import com.viscocits.redeem.catalogue.CatalogueFragment;
import com.viscocits.redeem.catalogue.HomeFragment;
import com.viscocits.redeem.catalogue.ModelLoginData;
import com.viscocits.redeem.catalogue.MoreFragment;
import com.viscocits.redeem.catalogue.WishlistFragment;
import com.viscocits.redeem.utils.Utility;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {


    private TextView tvTitle;
    private TextView homeTab, moreTab, cartTab, catalogueTab, wishlistTab;
    private ImageView ivCart;
    String selectedTab = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setStatusBarTranslucent(this, true);
        setContentView(R.layout.activity_main2);


        homeTab = findViewById(R.id.navigation_home);
        homeTab.setOnClickListener(this);
        moreTab = findViewById(R.id.navigation_more);
        moreTab.setOnClickListener(this);
        cartTab = findViewById(R.id.navigation_cart);
        cartTab.setOnClickListener(this);
        catalogueTab = findViewById(R.id.navigation_catalogue);
        catalogueTab.setOnClickListener(this);
        wishlistTab = findViewById(R.id.navigation_wishlist);
        wishlistTab.setOnClickListener(this);

        tvTitle = findViewById(R.id.nav_title);
        setCampaignName();
        homeTab.performClick();

    }

    private void setCampaignName() {
        ModelLoginData userData = Utility.getPreferenceProfileData(this);
        if (userData != null) {
            tvTitle.setText(userData.getCampaignName());
        }
    }

    @Override
    public void onClick(View v) {
        Fragment selectedFragment = null;
        switch (v.getId()) {
            case R.id.navigation_home:
                if (homeTab.getText() != selectedTab) {
                    resetAllTabs();
                    Drawable layerDrawable = getResources().getDrawable(R.drawable.home_grey);
                    selectTab(homeTab, layerDrawable);
                    selectedFragment = new HomeFragment();
                }
                break;
            case R.id.navigation_cart:
                if (cartTab.getText() != selectedTab) {
                    resetAllTabs();
                    Drawable layerDrawable2 = getResources().getDrawable(R.drawable.cart);
                    selectTab(cartTab, layerDrawable2);
                    selectedFragment = new CartFragment();
                }
                break;
            case R.id.navigation_catalogue:
                if (catalogueTab.getText() != selectedTab) {
                    resetAllTabs();
                    Drawable layerDrawable3 = getResources().getDrawable(R.drawable.home_grey);
                    selectTab(catalogueTab, layerDrawable3);
                    selectedFragment = new CatalogueFragment();
                }
                break;
            case R.id.navigation_wishlist:
                if (wishlistTab.getText() != selectedTab) {
                    resetAllTabs();
                    Drawable layerDrawable4 = getResources().getDrawable(R.drawable.more_grey);
                    selectTab(wishlistTab, layerDrawable4);
                    selectedFragment = new WishlistFragment();
                }
                break;
            case R.id.navigation_more:
                if (moreTab.getText() != selectedTab) {
                    resetAllTabs();
                    Drawable layerDrawable5 = getResources().getDrawable(R.drawable.more_grey);
                    selectTab(moreTab, layerDrawable5);
                    selectedFragment = new MoreFragment();
                }
                break;

        }

        if (selectedFragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, selectedFragment);
            transaction.commit();
        }
    }

    private void selectTab(TextView tab, Drawable layerDrawable) {
        //
        selectedTab = tab.getText().toString();
        tab.setCompoundDrawablesWithIntrinsicBounds(null, mutateDrawable(getResources().getColor(R.color.colorPrimaryDark2), layerDrawable), null, null);
        tab.setTextColor(getResources().getColor(R.color.colorPrimaryDark2));
        tab.setBackgroundColor(getResources().getColor(R.color.colorWhite));
    }

    private Drawable mutateDrawable(int color, Drawable layerDrawable) {
        Drawable drawable = layerDrawable.mutate();
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);

        return drawable;
    }

    private void resetAllTabs() {

        Drawable layerDrawableHome = getResources().getDrawable(R.drawable.home_grey);
        Drawable layerDrawableCatalogue = getResources().getDrawable(R.drawable.home_grey);
        Drawable layerDrawableCart = getResources().getDrawable(R.drawable.cart);
        Drawable layerDrawableWishlist = getResources().getDrawable(R.drawable.more_grey);
        Drawable layerDrawableMore = getResources().getDrawable(R.drawable.more_grey);

        homeTab.setCompoundDrawablesWithIntrinsicBounds(null, mutateDrawable(getResources().getColor(R.color.colorWhite), layerDrawableHome), null, null);
        catalogueTab.setCompoundDrawablesWithIntrinsicBounds(null, mutateDrawable(getResources().getColor(R.color.colorWhite), layerDrawableCatalogue), null, null);
        cartTab.setCompoundDrawablesWithIntrinsicBounds(null, mutateDrawable(getResources().getColor(R.color.colorWhite), layerDrawableCart), null, null);
        wishlistTab.setCompoundDrawablesWithIntrinsicBounds(null, mutateDrawable(getResources().getColor(R.color.colorWhite), layerDrawableWishlist), null, null);
        moreTab.setCompoundDrawablesWithIntrinsicBounds(null, mutateDrawable(getResources().getColor(R.color.colorWhite), layerDrawableMore), null, null);
        homeTab.setTextColor(getResources().getColor(R.color.colorWhite));
        catalogueTab.setTextColor(getResources().getColor(R.color.colorWhite));
        cartTab.setTextColor(getResources().getColor(R.color.colorWhite));
        wishlistTab.setTextColor(getResources().getColor(R.color.colorWhite));
        moreTab.setTextColor(getResources().getColor(R.color.colorWhite));
        homeTab.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        catalogueTab.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        cartTab.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        wishlistTab.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        moreTab.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }
}
