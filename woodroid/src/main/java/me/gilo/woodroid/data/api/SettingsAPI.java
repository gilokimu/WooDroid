package me.gilo.woodroid.data.api;


import retrofit2.Call;
import me.gilo.woodroid.models.SettingGroup;
import me.gilo.woodroid.models.SettingOption;
import retrofit2.http.*;

import java.util.List;

public interface SettingsAPI {

    @GET("settings")
    Call<List<SettingGroup>> settings();

    @GET("settings/{group_id}/{id}")
    Call<SettingOption> option(@Path("group_id") String group_id, @Path("id") String option_id);

    @GET("settings/{id}")
    Call<List<SettingOption>> options(@Path("id") String group_id);

    @Headers("Content-Type: application/json")
    @PUT("settings/{group_id}/{id}")
    Call<SettingOption> update(
            @Path("group_id") String group_id,
            @Path("id") String option_id,
            @Body SettingOption body
    );



}