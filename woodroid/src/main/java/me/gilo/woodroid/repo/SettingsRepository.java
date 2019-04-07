package me.gilo.woodroid.repo;

import me.gilo.woodroid.callback.WooCall;
import me.gilo.woodroid.data.api.SettingsAPI;
import me.gilo.woodroid.data.api.ShippingMethodAPI;
import me.gilo.woodroid.models.SettingGroup;
import me.gilo.woodroid.models.SettingOption;
import me.gilo.woodroid.models.ShippingMethod;

import java.util.List;

public class SettingsRepository extends WooRepository{

    private final SettingsAPI apiService;

    public SettingsRepository(String baseUrl, String consumerKey, String consumerSecret) {
       super( baseUrl, consumerKey, consumerSecret);
       apiService = retrofit.create(SettingsAPI.class);
    }

    public WooCall<List<SettingGroup>> settings() {
        return apiService.settings();
    }

    public WooCall<SettingOption> option(String group_id, String option_id) {
        return apiService.option(group_id, option_id);
    }

    public WooCall<List<SettingOption>> options(String group_id) {
        return apiService.options(group_id);
    }

    public WooCall<SettingOption> updateOption(String group_id, String option_id, SettingOption option) {
        return apiService.update(group_id, option_id, option);
    }

}
