package com.viscocits.inspire;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viscocits.redeem.catalogue.CatalogueFragment;
import com.viscocits.redeem.retrofit.RetrofitApi;
import com.viscocits.redeem.utils.Constants;
import com.viscocits.redeem.utils.Utility;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RetrofitApi.ActivityToFragmentListener {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;


    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_HOME = "TAG_HOME";
    private static final String TAG_BLANK = "TAG_BLANK";

    public static String CURRENT_TAG = TAG_HOME;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    private Fragment currentFragment;
    private String[] arrayTitles;
    private TextView tvNavTitle, tvCartCount, tvPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Utility.setStatusBarTranslucent(this, true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();

        initUi(savedInstanceState);

    }


    private void findViewById() {

        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        tvNavTitle = findViewById(R.id.tv_nav_title);
        tvCartCount = findViewById(R.id.tv_cart);
        tvPoints = findViewById(R.id.tv_points);
    }

    private void initUi(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        mHandler = new Handler();

        arrayTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }

    private void setNavTitle() {
        if (navItemIndex < arrayTitles.length)
            tvNavTitle.setText(arrayTitles[navItemIndex]);
    }

    public void setPoints(String str) {
        if (str == null)
            tvPoints.setVisibility(View.GONE);
        else {
            tvPoints.setVisibility(View.VISIBLE);
            tvPoints.setText(str);
        }
    }

    public void setCartCount(String str) {
        if (str == null)
            tvCartCount.setText("");
        else {
            tvCartCount.setText(str);
        }
    }


    private void loadHomeFragment() {

        selectNavMenu();
        // setCartCount(null);
        //  setPoints(null);


        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            return;
        }


        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments

                setNavTitle();
                currentFragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, currentFragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.postDelayed(mPendingRunnable, 100);
        }

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {

        Fragment fragment;
        switch (navItemIndex) {
            case 0:
                // home
                fragment = new CatalogueFragment();
                break;

            case 1:
                // home
                fragment = new BlankFragment();
                break;

            case 2:
                // home
                fragment = new BlankFragment();
                break;

            case 3:
                // home
                fragment = new BlankFragment();
                break;

            case 4:
                // home
                fragment = new BlankFragment();
                break;

            case 5:
                // home
                fragment = new BlankFragment();
                break;

            default:
                fragment = new BlankFragment();
                break;
        }

        return fragment;
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.nav_home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;

                    case R.id.nav_campaign:
                        navItemIndex = 1;
                        CURRENT_TAG = "a";
                        break;

                    case R.id.nav_wishlist:
                        navItemIndex = 2;
                        CURRENT_TAG = "b";
                        break;

                    case R.id.nav_orders:
                        navItemIndex = 3;
                        CURRENT_TAG = "c";
                        break;


                    case R.id.nav_statement:
                        navItemIndex = 4;
                        CURRENT_TAG = "d";
                        break;


                    case R.id.nav_community_forum:
                        navItemIndex = 5;
                        CURRENT_TAG = "e";
                        break;

                    default:
                        navItemIndex = -1;
                        CURRENT_TAG = TAG_BLANK;
                }

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.sidebar_navigation, getTheme());

        actionBarDrawerToggle.setHomeAsUpIndicator(drawable);
        actionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    private void selectNavMenu() {
        if (navItemIndex < navigationView.getMenu().size())
            navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }
        super.onBackPressed();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Utility.hideKeyboard(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


        }
    }

    private void showLogoutDialog() {
        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(MainActivity.this);

        // set title
        alertDialogBuilder.setTitle("Alert");

        // set dialog message
        alertDialogBuilder
                .setMessage("Do you want to Logout ?")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Utility.addPreferences(MainActivity.this, Constants.keyLoginCheck, false);
                        Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                        intent.putExtra("anim", false);
                        startActivity(intent);
                        dialog.dismiss();
                        finishAffinity();

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        // create alert dialog
        android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    @Override
    public void update(String tag, String str) {
        switch (tag) {

            case "cart":
                setCartCount(str);
                break;

            case "points":
                setPoints(str);
                break;
        }
    }
}
