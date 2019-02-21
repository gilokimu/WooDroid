package me.gilo.woodroid.data.api;


import me.gilo.woodroid.models.SettingGroup;
import me.gilo.woodroid.models.TaxRate;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SettingsAPI {

    @GET("settings")
    Call<List<SettingGroup>> settings();




}