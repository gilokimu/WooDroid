package me.gilo.woodroid.firebasecart


import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore



open class FirebaseCartRepository(userId : String){

    private val cart: CollectionReference = FirebaseFirestore.getInstance()
        .collection("users")
        .document(userId)
        .collection("cart")

}
