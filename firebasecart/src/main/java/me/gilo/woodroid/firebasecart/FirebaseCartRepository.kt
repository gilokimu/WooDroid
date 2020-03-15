package me.gilo.woodroid.firebasecart


import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import me.gilo.woodroid.core.cart.Cart
import me.gilo.woodroid.core.cart.CartItem
import me.gilo.woodroid.core.cart.CartRepository
import me.gilo.woodroid.core.cart.lines.LineItem


open class FirebaseCartRepository(userId : String){

    private val cart: CollectionReference = FirebaseFirestore.getInstance()
        .collection("users")
        .document(userId)
        .collection("cart")

}
