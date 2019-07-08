package me.gilo.woodroid.firebasecart


import android.arch.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import me.gilo.woodroid.core.cart.CartRepository
import me.gilo.woodroid.core.cart.lines.LineItem


open class FirebaseCartRepository(userId : String) : CartRepository() {

    private val cart: CollectionReference = FirebaseFirestore.getInstance()
        .collection("users")
        .document(userId)
        .collection("cart")


    override fun cart(): LiveData<List<LineItem>> {
        TODO("not implemented")
    }

    override fun clear(): LiveData<String> {
        TODO("not implemented")
    }

    override fun count(id: Int): LiveData<Int> {
        TODO("not implemented")
    }

    override fun addToCart(lineItem: LineItem): LiveData<LineItem> {
        TODO("not implemented")
    }

    override fun delete(cartId: String): LiveData<String> {
        TODO("not implemented")
    }

    override fun restore(cartId: String): LiveData<String> {
        TODO("not implemented")
    }

    override fun update(cartId: String, quantity: Int): LiveData<LineItem> {
        TODO("not implemented")
    }




}
