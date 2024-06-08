package com.egsystem.gsp.retrofit;



import com.egsystem.gsp.model.AnimalListModel;
import com.egsystem.gsp.model.LoginModel;
import com.egsystem.gsp.model.SpeciesListModel;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST(Api.user_login)
    Observable<Response<LoginModel>> user_login(@Header("authorization") String authorization,
                                                @Header("Accept") String accept,
                                                @Field("email_or_mobile_number") String mobile_number_or_email,
                                                @Field("password") String password,
                                                @Field("device_name") String device_name

    );


//    @Headers("Content-Type: application/x-www-form-urlencoded")
//    @FormUrlEncoded
//    @POST(Api.make_appointment)
//    Observable<Response<MakeAppointmentModel>> make_appointment(@Header("authorization") String authorization,
//                                                                @Header("Accept") String accept,
//                                                                @Field("doctor_department_id") Integer doctor_department_id,
//                                                                @Field("doctor_id") Integer doctor_id,
//                                                                @Field("appointment_date") String appointment_date,
//                                                                @Field("appointment_time") String appointment_time,
//                                                                @Field("diseases") String diseases,
//                                                                @Field("diseases_details") String diseases_details,
//                                                                @Field("patient_name") String patient_name,
//                                                                @Field("patient_age") String patient_age,
//                                                                @Field("relation") String relation,
//                                                                @Field("patient_phone") String patient_phone
//
//
//    );

//    @Headers("Content-Type: application/x-www-form-urlencoded")
//    @FormUrlEncoded
//    @POST(Api.client_register)
//    Observable<Response<ClientRegisterModel>> client_register(@Header("authorization") String authorization,
//                                                              @Header("Accept") String accept,
//                                                              @Field("full_name") String full_name,
//                                                              @Field("mobile_number") String mobile_number,
//                                                              @Field("email") String email,
//                                                              @Field("password") String password,
//                                                              @Field("password_confirmation") String password_confirmation,
//                                                              @Field("address") String address,
//                                                              @Field("designation_id") String designation_id,
//                                                              @Field("status") String status
//    );


//
//    @Multipart
//    @POST(Api.upload_test_order)
//    Observable<Response<UploadTestOrderModel>> upload_prescription(@Header("Authorization") String authorization,
//                                                                   @Header("Accept") String accept,
//                                                                   @Part MultipartBody.Part test_prescription
//
//    );


//    @GET(Api.designation_list)
//    Observable<Response<DesignationListModel>> designation_list(@Header("authorization") String authorization,
//                                                                @Header("Accept") String accept
//
//    );
//
//


    @GET(Api.species)
    Observable<Response<SpeciesListModel>> species_list(@Header("authorization") String authorization,
                                                        @Header("Accept") String accept

    );

    @GET(Api.animals)
    Observable<Response<AnimalListModel>> animal_list(@Header("authorization") String authorization,
                                                      @Header("Accept") String accept

    );


}

