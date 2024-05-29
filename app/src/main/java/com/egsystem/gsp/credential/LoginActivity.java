package com.egsystem.gsp.credential;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.afollestad.materialdialogs.MaterialDialog;
import com.egsystem.gsp.MainActivity;
import com.egsystem.gsp.R;
import com.egsystem.gsp.data.SharedData;
import com.egsystem.gsp.databinding.ActivityLoginBinding;
import com.egsystem.gsp.model.LoginModel;
import com.egsystem.gsp.retrofit.RetrofitApiClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {



    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initStatusBar();
        initComponents();

        checkSharedPrefData();

    }

    private void checkSharedPrefData() {
        if (SharedData.getUSER_MOBILE(this) == null || SharedData.getUSER_MOBILE(this).isEmpty()) {

        } else {
            binding.etUserName.setText(SharedData.getUSER_MOBILE(this));
        }
    }



    @SuppressLint("CheckResult")
    private void loginApi() {

        showProgressDialog();

        String email_or_phone = binding.etUserName.getText().toString();
        String password = binding.etPassword.getText().toString();
        String deviceModel = android.os.Build.MODEL;
        String deviceManufacturer = android.os.Build.MANUFACTURER;
        String deviceProduct = Build.PRODUCT;
        int sdkVersion = android.os.Build.VERSION.SDK_INT;
        String deviceName = deviceManufacturer + " " + deviceModel + " android_sdk: "+ sdkVersion;
        String token = "";
        String authorization = "Bearer" + " " ;
        String accept = "application/json";


        RetrofitApiClient.getApiInterface().user_login(authorization, accept,  email_or_phone, password, deviceName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                            Log.d("tag3344", "response.code():" + response.code());
                            Log.d("tag3344", response.toString());
                            Log.d("tag3344", response.message().toString());
                            Log.d("tag3344", String.valueOf(response.code())); 

                            if (response.code() == 401) {
                                new MaterialDialog.Builder(LoginActivity.this)
                                        .title("Login Status")
                                        .content("Username or password is incorrect. Please try again with correct one")
                                        .positiveText("")
                                        .negativeText("Ok")
                                        .show();
                            }

                            if (response.code() == 201 || response.code() == 200) {

                                closeProgressDialog();

                                LoginModel loginModel = response.body();
//                                boolean status = loginModel.getStatus();
//                                boolean status = loginModel.getSuccess();
//                                String status2 = loginModel.getMessage();
                                String userToken = loginModel.getToken().toString();
                                String user_id = loginModel.getUser().getId().toString();
                                String user_name = loginModel.getUser().getName();
                                String user_phone = loginModel.getUser().getMobileNumber();
                                String user_email = loginModel.getUser().getEmail();
                                String usera_password = loginModel.getUser().getPassword();


                                SharedData.saveTOKEN(LoginActivity.this, userToken);
                                SharedData.saveTOKEN(LoginActivity.this, userToken);
                                SharedData.saveUSER_NAME(LoginActivity.this, user_name);
                                SharedData.saveUSER_ID(LoginActivity.this, user_id);
                                SharedData.saveUSER_MOBILE(LoginActivity.this, user_phone);
                                SharedData.saveEMAIL(LoginActivity.this, user_email);
                                SharedData.savePASSWORD(LoginActivity.this, usera_password);

                                SharedData.saveIS_USER_REGISTERED(this, true);
                                SharedData.saveIS_USER_LOGGED_IN(this, true);

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }


                            new MaterialDialog.Builder(LoginActivity.this)
                                    .title("Status")
                                    .content(response.code())
                                    .positiveText("")
                                    .negativeText("Ok")
                                    .show();

                            if (response.isSuccessful()) {

                                LoginModel loginModel = response.body();
                                String userToken = loginModel.getToken().toString();

                                SharedData.saveTOKEN(LoginActivity.this, userToken);
//                                String message = loginModel.getMessage();
                                String user_id = loginModel.getUser().getId().toString();
                                String user_name = loginModel.getUser().getName();
                                String user_phone = loginModel.getUser().getMobileNumber();
                                Log.d("tag20", "userToken in onClickVerify: ");

                                if (response.code() == 200 || response.code() == 201) {

                                    SharedData.saveTOKEN(LoginActivity.this, userToken);
                                    SharedData.saveUSER_NAME(LoginActivity.this, user_name);
                                    SharedData.saveUSER_ID(LoginActivity.this, user_id);
                                    SharedData.saveUSER_MOBILE(LoginActivity.this, user_phone);

                                    SharedData.saveIS_USER_REGISTERED(this, true);
                                    SharedData.saveIS_USER_LOGGED_IN(this, true);

                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }


                            } else {
                                Log.d("tag3344", "else is called ");
                            }
                        },
                        error -> {
//                            customProgress.hideProgress();

//                            if (response.code() == 401) {
//                                new MaterialDialog.Builder(LoginActivity.this)
//                                        .title("Login Status")
//                                        .content(response.code())
//                                        .positiveText("Username or password is incorrect. Please try again with correct one")
//                                        .negativeText("Ok")
//                                        .show();
//                            }

                            Log.d("tag3344", "error msg: "+error.getMessage().toString() );

                        },
                        () -> {
                            Log.d("tag3344", "onComplete");
//                            customProgress.hideProgress();


                        }
                );


    }








    private void initComponents() {

        binding.btnSignIn.setOnClickListener(view -> {
//            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(intent);

            loginApi();

        });

    }


    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }



    ProgressDialog progressDialog;

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait ....");
        progressDialog.show();
    }

    private void closeProgressDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }





}