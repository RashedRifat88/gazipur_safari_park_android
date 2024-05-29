package com.egsystem.gsp.adapter;//package com.egsystem.navantis.adapter;
//
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.database.Cursor;
//import android.os.CountDownTimer;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ProgressBar;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.egsystem.navantis.R;
//import com.egsystem.navantis.model.ClientListModel;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class AllInfoAdapter extends RecyclerView.Adapter<AllInfoAdapter.AllInfoViewHolder> {
//
//    List<ClientListModel.Client> instituteList = new ArrayList<>();
//    List<String> home_module_name_ban_list = new ArrayList<>();
//    List<String> home_module_image_list = new ArrayList<>();
//    Context context;
//
//    Cursor dataCursor;
//
//    String categoryName = "";
//
//    String title;
//    String category_id;
//    private List<String> memberListFiltered = new ArrayList<>();
//
//    private static long COUNTDOWN_IN_MILLIS = 0;
//    private long timeLeftInMillis;
//    private CountDownTimer countDownTimer;
//
//
//    private AdapterCallback adapterCallback;
//
//    public AllInfoAdapter(Context context) {
//        this.context = context;
//
////        try {
////            adapterCallback = ((AdapterCallback) context);
////        } catch (ClassCastException e) {
//////            throw new ClassCastException("Activity must implement AdapterCallback.", e);
////        }
//
//    }
//
//
//    public void setData(List<ClientListModel.Client> instituteList) {
//        this.instituteList = instituteList;
////        this.home_module_name_ban_list = home_module_name_ban_list;
//    }
//
//    public void filterList(List<ClientListModel.Client> instituteList) {
//        this.instituteList = instituteList;
//        notifyDataSetChanged();
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return instituteList.size();
//    }
//
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//
//    @Override
//    public AllInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.single_item_all_info_list, parent, false);
//        AllInfoViewHolder myViewHolder = new AllInfoViewHolder(view);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                listener.onItemClick(v, myViewHolder.getPosition());
//            }
//        });
//        return myViewHolder;
//    }
//
//
//    @Override
//    public void onBindViewHolder(final AllInfoViewHolder holder, @SuppressLint("RecyclerView") int position) {
////        TextView txtSlNo = holder.txtSlNo;
////        TextView tv_time_left_in_days = holder.tv_time_left_in_days;
////        TextView tv_time_left = holder.tv_time_left;
////        TextView tv_name = holder.tv_name;
////        TextView tv_expire_date = holder.tv_expire_date;
////
//        LinearLayout linear1 = holder.linear1;
//        LinearLayout linearDetails = holder.linearDetails;
//
////        RelativeLayout relative1 = holder.relative1;
////        ImageView imageView = holder.imageView;
////        ImageView img_clock = holder.img_clock;
////        ImageView img_arrow = holder.img_arrow;
////        ProgressBar progressBar = holder.progressBar;
//
//        ImageView iv_circle = holder.iv_circle;
//        ImageView iv_1 = holder.iv_1;
//
//        TextView tv_name = holder.tv_name;
//        TextView tv_client_no = holder.tv_client_no;
//        TextView tv_cc = holder.tv_cc;
//        TextView tv_rent_price = holder.tv_rent_price;
//        TextView tv_phone = holder.tv_phone;
//        TextView tv_doctor_name_ban = holder.tv_doctor_name_ban;
//
//        CardView card1 = holder.card1;
//
////        img_clock.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_animation));
//////        imageView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_animation));
//////        cardview.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fall_down_animation));
////
////
//        ClientListModel.Client client = instituteList.get(position);
//
//
//        String name = client.getFullName();
//        String deg = client.getDesignation();
//        String email = client.getEmail();
//        String address = client.getAddress();
//        String phone = client.getMobileNumber();
//
//
//        tv_name.setText(name);
//        tv_client_no.setText("Deg: " +deg);
//        tv_cc.setText(email);
//        tv_rent_price.setText("Addr: "+address);
//        tv_phone.setText("Phone: "+phone);
//
////        String imageUrl = client.getProfileImage();
////        Glide.with(context).load(imageUrl).into(iv_1);
////
////        iv_1.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                boolean wrapInScrollView = true;
////                MaterialDialog dialog1 = new MaterialDialog.Builder(context)
////                        .customView(R.layout.material_dialog_photo, wrapInScrollView)
////                        .build();
////
////                ImageView iv_dialog_fullscreen = dialog1.getCustomView().findViewById(R.id.iv_dialog_fullscreen);
////                Glide.with(context).load(imageUrl).into(iv_dialog_fullscreen);
////
////                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
////                WindowManager.LayoutParams wmlp = dialog1.getWindow()
////                        .getAttributes();
////                wmlp.width = WindowManager.LayoutParams.MATCH_PARENT;
////                wmlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
////                dialog1.show();
////
////                dialog1.setCancelable(true);
////                dialog1.setCanceledOnTouchOutside(true);
////            }
////        });
//
//
//
////        int aPosition = position + 1;
////
////        if (aPosition % 5 == 1) {
////            linear2.setBackgroundResource(R.color.light_color1);
////            img_clock.setColorFilter(ContextCompat.getColor(context, R.color.light_deep_color1), android.graphics.PorterDuff.Mode.SRC_IN);
////        } else if (aPosition % 5 == 4) {
////            linear2.setBackgroundColor(context.getResources().getColor(R.color.light_color2));
////            img_clock.setColorFilter(ContextCompat.getColor(context, R.color.light_deep_color2), android.graphics.PorterDuff.Mode.SRC_IN);
////        } else if (aPosition % 5 == 3) {
////            linear2.setBackgroundColor(context.getResources().getColor(R.color.light_color3));
////            img_clock.setColorFilter(ContextCompat.getColor(context, R.color.light_deep_color3), android.graphics.PorterDuff.Mode.SRC_IN);
////        } else if (aPosition % 5 == 2) {
////            linear2.setBackgroundColor(context.getResources().getColor(R.color.light_color4));
////            img_clock.setColorFilter(ContextCompat.getColor(context, R.color.light_deep_color4), android.graphics.PorterDuff.Mode.SRC_IN);
////        } else if (aPosition % 5 == 0) {
////            linear2.setBackgroundColor(context.getResources().getColor(R.color.light_color5));
////            img_clock.setColorFilter(ContextCompat.getColor(context, R.color.light_deep_color5), android.graphics.PorterDuff.Mode.SRC_IN);
////        }
//
//
////        linear1.setOnClickListener(v -> {
////            Intent intent = new Intent(context, AllInfoCheckoutActivity.class);
////            intent.putExtra("title", client.getName());
////            intent.putExtra("client", (Serializable) client);
////            context.startActivity(intent);
////        });
////
////
////        linearDetails.setOnClickListener(v -> {
////            Intent intent = new Intent(context, AllInfoCheckoutActivity.class);
////            intent.putExtra("title", client.getName());
////            intent.putExtra("client", (Serializable) client);
////            context.startActivity(intent);
////        });
//
//
//
//
//    }
//
//
//
//    public long milliseconds(String date) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            Date mDate = sdf.parse(date);
//            long timeInMilliseconds = mDate.getTime();
//            return timeInMilliseconds;
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public static String getFormattedDateFromTimestamp(long timestampInMilliSeconds, String dateStyle) {
//        Date date = new Date();
//        date.setTime(timestampInMilliSeconds);
//        String formattedDate = new SimpleDateFormat(dateStyle).format(date);
//        return formattedDate;
//    }
//
//
//
//    class AllInfoViewHolder extends RecyclerView.ViewHolder {
//
//        TextView txtSlNo;
//        TextView tv_name;
//        TextView tv_client_no;
//        TextView tv_cc;
//        TextView tv_rent_price;
//        TextView tv_phone;
//        TextView tv_doctor_name_ban;
//
//        LinearLayout linear1;
//        LinearLayout linearDetails;
//        RelativeLayout relative1;
//
//        ImageView iv_circle;
//        ImageView iv_1;
//
//        CardView card1;
//        ProgressBar progressBar;
//
//        public AllInfoViewHolder(View itemView) {
//            super(itemView);
//            tv_name = itemView.findViewById(R.id.tv_name);
//            tv_client_no = itemView.findViewById(R.id.tv_client_no);
//            tv_cc = itemView.findViewById(R.id.tv_cc);
//            tv_rent_price = itemView.findViewById(R.id.tv_rent_price);
//            tv_phone = itemView.findViewById(R.id.tv_phone);
//
//            iv_1 = itemView.findViewById(R.id.iv_1);
//
////            iv_circle = itemView.findViewById(R.id.iv_circle);
////            card1 = itemView.findViewById(R.id.card1);
//
//            linear1 = itemView.findViewById(R.id.linear1);
//            linearDetails = itemView.findViewById(R.id.linearDetails);
////
////            progressBar = itemView.findViewById(R.id.progressBar);
//
//        }
//    }
//
//
////    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
////    public void filter(CharSequence charText) {
////
////        List<String> filteredList = new ArrayList<>();
////        String charString = charText.toString();
////
////        if (charString.length() == 0) {
////////         memberListFiltered = dataSet;
//////         filteredList.addAll(dataSet);
////            Log.i("tag", String.valueOf("1:  "+charString.length())+dataSet);
////
////
////        }
////
////        if (charString.isEmpty() || charString.equalsIgnoreCase("")) {
////            memberListFiltered = titleList;
////        } else {
//////         List<MemberInfoModel.Result> filteredList = new ArrayList<>();
////            for (String row : titleList) {
////                if (
////                        row.toLowerCase().contains(charString.toLowerCase())
//////                                ||
//////                                row.getMobile().toLowerCase().contains(charString.toLowerCase())
//////                                ||
//////                                row.getYear().toLowerCase().contains(charString.toLowerCase())
//////                                ||
//////                                row.getMember_id_String().toLowerCase().contains(charString.toLowerCase())
//////                             ||
//////                             row.getTakaAmount().toLowerCase().contains(charString.toLowerCase()) ||
//////                             row.getPaymentStatus().toLowerCase().contains(charString.toLowerCase())
////                ) {
////                    filteredList.add(row);
////                }
////            }
////
////            Log.i("tag", "2:  "+String.valueOf(charString.length())+filteredList);
////
////            memberListFiltered = filteredList;
////        }
////
//////     Filter.FilterResults filterResults = new Filter.FilterResults();
//////     filterResults.values = memberListFiltered;
////        this.setData(memberListFiltered, memberListFiltered, memberListFiltered);
////        this.notifyDataSetChanged();
////    }
//
//
//    public interface AdapterCallback {
//        void onMethodCallback(List<String> favTopicList);
//
//        void onMethodCallback();
//    }
//
//
//}
//
