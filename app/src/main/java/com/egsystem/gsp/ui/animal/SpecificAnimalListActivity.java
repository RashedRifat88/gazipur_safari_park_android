package com.egsystem.gsp.ui.animal;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.egsystem.gsp.R;
import com.egsystem.gsp.credential.LoginActivity;
import com.egsystem.gsp.data.SharedData;
import com.egsystem.gsp.databinding.ActivityAnimalBinding;
import com.egsystem.gsp.databinding.ActivitySpecificAnimalListBinding;
import com.egsystem.gsp.model.AnimalListModel;
import com.egsystem.gsp.retrofit.RetrofitApiClient;
import com.egsystem.gsp.ui.animal.adapter.SpecificAnimalListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SpecificAnimalListActivity extends AppCompatActivity {


    private ActivitySpecificAnimalListBinding binding;
    private SpecificAnimalListAdapter adapter;
    List<AnimalListModel.Animal> animalList;
    List<AnimalListModel.Animal> specificAnimalList = new ArrayList<>();


    String species_id;
    String area = "";
    ArrayAdapter<String> dataAdapter;
    private List<AnimalListModel.Animal> areaList;
    private ArrayList<String> area_list;
    private HashMap<String, String> area_id_Map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySpecificAnimalListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        species_id = getIntent().getStringExtra("species_id");


        initStatusBar();
        initComponent();

        loadRecyclerView();

        houseRentApi();



    }


    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary, this.getTheme()));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
        }

    }

    private void initComponent() {
        binding.linearBack.setOnClickListener(v -> {
            finish();
        });

//        binding.btnMakePost.setOnClickListener(v -> {
//            Intent intent = new Intent(HouseRentActivity.this, HouseRentPostActivity.class);
//            startActivity(intent);
//        });


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


    private void loadRecyclerView() {
        adapter = new SpecificAnimalListAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(mLayoutManager);
//        adapter.setData(mymensingh_div_service_name_list, mymensingh_div_service_image_list);
        adapter.notifyDataSetChanged();
    }



    @SuppressLint("CheckResult")
    public void houseRentApi() {

        showProgressDialog();

        String token = SharedData.getTOKEN(this);
        Log.d("tag1111177", " token: " + token);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";


        RetrofitApiClient.getApiInterface().animal_list(authorization, accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.d("tag11111", " response.code(): " + response.code());


                            if (response.code() == 401) {
                                Intent intent = new Intent(SpecificAnimalListActivity.this, LoginActivity.class);
                                intent.putExtra("SENDER_ACTIVITY_NAME", "");
                                startActivity(intent);
                            }


                            if (response.isSuccessful()) {
                                closeProgressDialog();

                                Log.d("tag1111177", " response.body(): " + response.body());


                                if (response.code() == 200) {

                                    AnimalListModel model = response.body();

                                    animalList = model.getResult().getAnimals();

                                    Log.d("tag1111177", " animalList: " + animalList);


                                    for (int i = 0; i<animalList.size(); i++){
                                        String speciesId = String.valueOf(animalList.get(i).getSpeciesId().getId());
                                        Log.d("tag1111177", " speciesId: " + speciesId);
                                        Log.d("tag1111177", " species_id: " + species_id);

                                        if (speciesId.equalsIgnoreCase(species_id)){
                                            specificAnimalList.add(animalList.get(i));
                                        }

                                    }


                                    Log.d("tag1111177", " specificAnimalList: " + specificAnimalList);

                                    adapter.setData(specificAnimalList);
                                    adapter.notifyDataSetChanged();



                                } else {
                                    new MaterialDialog.Builder(SpecificAnimalListActivity.this)
                                            .title("Doctor Status")
                                            .content("Nursing package list is empty....")
                                            .positiveText("")
                                            .negativeText("Ok")
                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
                                                @Override
                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                                }
                                            })
                                            .show();
                                }

                            } else {

                            }


                        },
                        error -> {

                            Log.d("tag11111", " response.code(): " + error.toString());

                        },
                        () -> {

                        }
                );


    }






}