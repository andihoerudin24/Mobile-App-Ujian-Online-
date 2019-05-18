package com.tutorkomputer.ujianonlinerevisi.rest;

import com.tutorkomputer.ujianonlinerevisi.data.model.CallResponse;
import com.tutorkomputer.ujianonlinerevisi.data.model.NilaiResponse;
import com.tutorkomputer.ujianonlinerevisi.data.model.SignResponse;
import com.tutorkomputer.ujianonlinerevisi.data.model.Siswa;
import com.tutorkomputer.ujianonlinerevisi.data.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Apiinterface {

    @FormUrlEncoded
    @POST("user/login")
    Call<CallResponse> postAuth(@Field("email") String email,
                                @Field("password") String password);


    @FormUrlEncoded
    @POST("user")
    Call<SignResponse> SignUser(@Field("name") String name,
                                @Field("email") String email,
                                @Field("password") String password,
                                @Field("android_id") String android_id);

    @GET("user/{android_id}")
    Call<UserResponse> getDetail(@Path("android_id") String android_id);



    @FormUrlEncoded
    @PUT("user/{id}")
    Call<UserResponse> upDateuser(@Path("id") String id,
                                  @Field("name") String name,
                                  @Field("email") String email,
                                  @Field("no_hp_ortu") String no_hp_ortu,
                                  @Field("kelas") String kelas );

    @GET("hasil")
    Call<Siswa> gethasil();


    @GET("hasil/{android_id}")
    Call<NilaiResponse> getNilai(@Path("android_id") String android_id );

}
