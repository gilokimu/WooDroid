package me.gilo.wc.repo;

import me.gilo.woodroid.Woocommerce;

public class WoocommerceRepository {

    Woocommerce woocommerce = new Woocommerce.Builder()
            .setSiteUrl("http://157.230.131.179")
            .setApiVersion(Woocommerce.API_V3)
            .setConsumerKey("ck_26c61abd7eeff238d87dc56585bf26cb2d1a1ec3")
            .setConsumerSecret("cs_062e8e3a7ae0ce08fdebc0c39f8f834d5e87598e")
            .build();
}
