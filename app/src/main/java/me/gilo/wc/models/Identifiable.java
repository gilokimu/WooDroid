package me.gilo.wc.models;

import com.google.firebase.firestore.Exclude;

/**
 * Represents an object that can be uniquely identified among other objects of the same type
 * by using an UID.
 *
 * @param <TKey> type of the unique key (UID) this object is uniquely identified by. The type needs
 *              a correct implementation of its equals() method or the behaviour of code using this
 *              interface will be undefined.
 */
public interface Identifiable<TKey> {

    @Exclude
    TKey getEntityKey();

}