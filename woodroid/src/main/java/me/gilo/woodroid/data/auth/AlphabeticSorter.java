package me.gilo.woodroid.data.auth;

import org.apache.http.NameValuePair;

import java.util.Comparator;

public class AlphabeticSorter implements Comparator<NameValuePair> {

    @Override
    public int compare(NameValuePair nameValuePair1, NameValuePair nameValuePair2) {
        return nameValuePair1.getName().compareTo(nameValuePair2.getName());
    }
}