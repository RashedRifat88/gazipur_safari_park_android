package com.egsystem.gsp.ui.animal.adapter;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.egsystem.gsp.R;
import com.egsystem.gsp.model.AnimalListModel;
import com.egsystem.gsp.model.SpeciesListModel;
import com.egsystem.gsp.ui.animal.SpecificAnimalListActivity;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.HouseRentPostViewHolder> {

    List<SpeciesListModel.Species> instituteList = new ArrayList<>();
    List<String> home_module_name_ban_list = new ArrayList<>();
    List<String> home_module_image_list = new ArrayList<>();
    Context context;

    Cursor dataCursor;

    String categoryName = "";

    String title;
    String category_id;
    private List<String> memberListFiltered = new ArrayList<>();

    private static long COUNTDOWN_IN_MILLIS = 0;
    private long timeLeftInMillis;
    private CountDownTimer countDownTimer;


    private AdapterCallback adapterCallback;

    public AnimalListAdapter(Context context) {
        this.context = context;

//        try {
//            adapterCallback = ((AdapterCallback) context);
//        } catch (ClassCastException e) {
////            throw new ClassCastException("Activity must implement AdapterCallback.", e);
//        }

    }


    public void setData(List<SpeciesListModel.Species> instituteList) {
        this.instituteList = instituteList;
//        this.home_module_name_ban_list = home_module_name_ban_list;
    }

    public void filterList(List<SpeciesListModel.Species> instituteList) {
        this.instituteList = instituteList;
        notifyDataSetChanged();
    }

    public void filterByAreaList(List<SpeciesListModel.Species> instituteList) {
        this.instituteList = instituteList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return instituteList.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public HouseRentPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item_animal_list, parent, false);
        HouseRentPostViewHolder myViewHolder = new HouseRentPostViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listener.onItemClick(v, myViewHolder.getPosition());
            }
        });
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final AnimalListAdapter.HouseRentPostViewHolder holder, @SuppressLint("RecyclerView") int position) {

        LinearLayout linear1 = holder.linear1;
        LinearLayout linearDetails = holder.linearDetails;


        ImageView iv_circle = holder.iv_circle;
        ImageView iv_1 = holder.iv_1;

        TextView tv_name = holder.tv_name;

        CardView card1 = holder.card1;

        SpeciesListModel.Species species = instituteList.get(position);


        String name = species.getName();
        String species_id = String.valueOf(species.getId());


        tv_name.setText(name);

//        String imageUrl = species.getThumbnailImage();
//        Glide.with(context).load(imageUrl).into(iv_1);




//        tv_details.setOnClickListener(v -> {
//            Intent intent = new Intent(context, HouseRentDetailsActivity.class);
//            intent.putExtra("species", (Serializable) species);
//            context.startActivity(intent);
//        });
//

        linear1.setOnClickListener(v -> {
            Intent intent = new Intent(context, SpecificAnimalListActivity.class);
            intent.putExtra("species_id", species_id);
//            intent.putExtra("species", (Serializable) species);
            context.startActivity(intent);
        });

//
//        linearDetails.setOnClickListener(v -> {
//            Intent intent = new Intent(context, HouseRentDetailsActivity.class);
//            intent.putExtra("species", (Serializable) species);
//            context.startActivity(intent);
//        });




    }



    public long milliseconds(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date mDate = sdf.parse(date);
            long timeInMilliseconds = mDate.getTime();
            return timeInMilliseconds;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public static String getFormattedDateFromTimestamp(long timestampInMilliSeconds, String dateStyle) {
        Date date = new Date();
        date.setTime(timestampInMilliSeconds);
        String formattedDate = new SimpleDateFormat(dateStyle).format(date);
        return formattedDate;
    }



    class HouseRentPostViewHolder extends RecyclerView.ViewHolder {

        TextView txtSlNo;
        TextView tv_name;
        TextView tv_subject;
        TextView tv_toilet;
        TextView tv_balconi;
        TextView tv_amount;
        TextView tv_address;
        TextView tv_area;
        TextView tv_details;

        TextView tv_phone;
        TextView tv_doctor_name_ban;

        LinearLayout linear1;
        LinearLayout linearDetails;
        RelativeLayout relative1;

        ImageView iv_circle;
        ImageView iv_1;

        CardView card1;
        ProgressBar progressBar;

        public HouseRentPostViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);

            iv_1 = itemView.findViewById(R.id.iv_1);

            card1 = itemView.findViewById(R.id.card1);

            linear1 = itemView.findViewById(R.id.linear1);
//
//            progressBar = itemView.findViewById(R.id.progressBar);

        }
    }


//    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
//    public void filter(CharSequence charText) {
//
//        List<String> filteredList = new ArrayList<>();
//        String charString = charText.toString();
//
//        if (charString.length() == 0) {
//////         memberListFiltered = dataSet;
////         filteredList.addAll(dataSet);
//            Log.i("tag", String.valueOf("1:  "+charString.length())+dataSet);
//
//
//        }
//
//        if (charString.isEmpty() || charString.equalsIgnoreCase("")) {
//            memberListFiltered = titleList;
//        } else {
////         List<MemberInfoModel.Result> filteredList = new ArrayList<>();
//            for (String row : titleList) {
//                if (
//                        row.toLowerCase().contains(charString.toLowerCase())
////                                ||
////                                row.getMobile().toLowerCase().contains(charString.toLowerCase())
////                                ||
////                                row.getYear().toLowerCase().contains(charString.toLowerCase())
////                                ||
////                                row.getMember_id_String().toLowerCase().contains(charString.toLowerCase())
////                             ||
////                             row.getTakaAmount().toLowerCase().contains(charString.toLowerCase()) ||
////                             row.getPaymentStatus().toLowerCase().contains(charString.toLowerCase())
//                ) {
//                    filteredList.add(row);
//                }
//            }
//
//            Log.i("tag", "2:  "+String.valueOf(charString.length())+filteredList);
//
//            memberListFiltered = filteredList;
//        }
//
////     Filter.FilterResults filterResults = new Filter.FilterResults();
////     filterResults.values = memberListFiltered;
//        this.setData(memberListFiltered, memberListFiltered, memberListFiltered);
//        this.notifyDataSetChanged();
//    }


    public interface AdapterCallback {
        void onMethodCallback(List<String> favTopicList);

        void onMethodCallback();
    }


}

