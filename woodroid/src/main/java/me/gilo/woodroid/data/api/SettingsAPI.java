package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.SettingGroup;
import me.gilo.woodroid.models.SettingOption;
import me.gilo.woodroid.models.TaxRate;
import me.gilo.woodroid.models.WebhookDelivery;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SettingsAPI {

    @GET("settings")
    Call<List<SettingGroup>> settings();

    @GET("settings/{group_id}/{id}")
    Call<SettingOption> option(@Path("group_id") int group_id, @Path("id") int option_id);

    @GET("settings/{id}")
    Call<List<SettingOption>> options(@Path("id") int group_id);

    @Headers("Content-Type: application/json")
    @GET("settings/{group_id}/{id}")
    Call<SettingOption> update(@Path("group_id") int group_id, @Path("id") int option_id);



}