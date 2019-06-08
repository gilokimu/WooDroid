package me.gilo.woodroid.data.auth

import org.apache.http.NameValuePair

import java.util.Comparator

class AlphabeticSorter : Comparator<NameValuePair> {

    override fun compare(nameValuePair1: NameValuePair, nameValuePair2: NameValuePair): Int {
        return nameValuePair1.name.compareTo(nameValuePair2.name)
    }
}