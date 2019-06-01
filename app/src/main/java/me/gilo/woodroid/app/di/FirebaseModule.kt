package me.gilo.woodroid.app.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides

import javax.inject.Named
import javax.inject.Singleton


@Module
internal class FirebaseModule {

    private val firestoreInstance: FirebaseFirestore
        get() = FirebaseFirestore.getInstance()

    @Singleton
    @Provides
    fun providesFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Singleton
    @Provides
    @Named("storage")
    fun providesStorage(): StorageReference {
        return FirebaseStorage.getInstance().reference
    }

    @Singleton
    @Provides
    @Named("users")
    fun providesUsers(): CollectionReference {
        return firestoreInstance.collection("users")
    }


}
