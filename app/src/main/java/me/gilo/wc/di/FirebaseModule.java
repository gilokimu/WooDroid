package me.gilo.wc.di;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;


@Module
class FirebaseModule {

    @Singleton
    @Provides
    FirebaseFirestore providesFirestore() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        return db;
    }

    @Singleton
    @Provides
    @Named("storage")
    StorageReference providesStorage() {
        return FirebaseStorage.getInstance().getReference();
    }

    @Singleton
    @Provides
    @Named("users")
    CollectionReference providesUsers() {
        return getFirestoreInstance().collection("users");
    }

    FirebaseFirestore getFirestoreInstance(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        return db;
    }



}
