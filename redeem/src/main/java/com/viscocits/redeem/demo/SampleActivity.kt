package com.viscocits.redeem.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.viscocits.redeem.R

/**
 * Created by abhi on 24/03/18.
 */

public class SampleActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_catalogue)

        setUpActionBar()

        initUi()

        initData()


    }

    private fun initData() {


    }

    private fun initUi() {


    }

    private fun setUpActionBar() {

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        title = resources.getString(R.string.toolbar_title_product_catalogue)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        val id = item?.itemId

        if (id == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)

    }


}