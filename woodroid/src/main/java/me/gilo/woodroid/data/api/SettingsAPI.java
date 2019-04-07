package me.gilo.woodroid.data.api;


import me.gilo.woodroid.callback.WooCall;
import me.gilo.woodroid.models.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SettingsAPI {

    @GET("settings")
    WooCall<List<SettingGroup>> settings();

    @GET("settings/{group_id}/{id}")
    WooCall<SettingOption> option(@Path("group_id") String group_id, @Path("id") String option_id);

    @GET("settings/{id}")
    WooCall<List<SettingOption>> options(@Path("id") String group_id);

    @Headers("Content-Type: application/json")
    @PUT("settings/{group_id}/{id}")
    WooCall<SettingOption> update(
            @Path("group_id") String group_id,
            @Path("id") String option_id,
            @Body SettingOption body
    );



}