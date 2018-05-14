package com.viscocits.inspire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.viscocits.redeem.catalogue.ModelGetCampaignResponse;
import com.viscocits.redeem.catalogue.ModelLoginResponse;
import com.viscocits.redeem.retrofit.RetrofitApi;
import com.viscocits.redeem.utils.Constants;
import com.viscocits.redeem.utils.Utility;

public class LoginActivity extends AppCompatActivity implements RetrofitApi.ResponseListener {

    private RetrofitApi.ResponseListener listener = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setStatusBarTranslucent(this, true);
        setContentView(R.layout.activity_login);

        final EditText etUserName = findViewById(R.id.et_user_name);
        final EditText etPassword = findViewById(R.id.et_password);

        TextView tvLogin = findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUserName = etUserName.getText().toString().trim();
                String strPassword = etPassword.getText().toString().trim();

                if (strUserName.length() == 0 || strPassword.length() == 0) {
                    Utility.showToast(LoginActivity.this, "Please enter the credentials");
                    return;
                }

                RetrofitApi.getInstance().loginApi(LoginActivity.this, listener, strUserName, strPassword);
            }
        });


    }


    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }

    @Override
    public void _onNext(Object obj) {

        if (obj instanceof ModelLoginResponse) {
            ModelLoginResponse response = (ModelLoginResponse) obj;

            if (response.getStatusCode().equals("200") && response.getData() != null) {

                Utility.addPreferences(LoginActivity.this, Constants.KEY_LOGIN_CHECK, true);
                Utility.addPreferenceProfileData(LoginActivity.this, response.getData());
                startActivity(new Intent(LoginActivity.this, Main2Activity.class));
                finishAffinity();

            } else if (response.getStatusCode().equals("404")) {
                Utility.showToast(LoginActivity.this, "User does not exist!");
            }
        }

    }
}
