package me.gilo.wc.repo

import android.util.Log
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import me.gilo.wc.models.Identifiable
import me.gilo.wc.models.Repository


/**
 * Manages data access for Firebase
 */
open class FirebaseRepository<TEntity : Identifiable<String>>(
    private val entityClass: Class<TEntity>,
    private val collectionName: String
) : Repository<TEntity, String> {

    private val collectionReference: CollectionReference


    init {

        val db = FirebaseFirestore.getInstance()
        this.collectionReference = db.collection(this.collectionName)
    }

    override fun exists(documentName: String): Task<Boolean> {
        val documentReference = collectionReference.document(documentName)
        Log.i(TAG, "Checking existence of '$documentName' in '$collectionName'.")

        return documentReference.get().continueWith { task ->
            Log.d(TAG, "Checking if '$documentName' exists in '$collectionName'.")
            task.result!!.exists()
        }
    }

    override fun get(id: String): Task<TEntity> {
        val documentReference = collectionReference.document(id)
        Log.i(TAG, "Getting '$id' in '$collectionName'.")

        return documentReference.get().continueWith { task ->
            val documentSnapshot = task.result
            if (documentSnapshot!!.exists()) {
                documentSnapshot.toObject(entityClass)
            } else {
                Log.d(TAG, "Document '$id' does not exist in '$collectionName'.")
                entityClass.newInstance()
            }
        }
    }

    override fun create(entity: TEntity): Task<Void> {
        val documentName = entity.entityKey
        val documentReference = collectionReference.document(documentName)
        Log.i(TAG, "Creating '$documentName' in '$collectionName'.")
        return documentReference.set(entity).addOnFailureListener { e ->
            Log.d(
                TAG,
                "There was an error creating '$documentName' in '$collectionName'!",
                e
            )
        }
    }

    override fun update(entity: TEntity): Task<Void> {
        val documentName = entity.entityKey
        val documentReference = collectionReference.document(documentName)
        Log.i(TAG, "Updating '$documentName' in '$collectionName'.")

        return documentReference.set(entity).addOnFailureListener { e ->
            Log.d(
                TAG,
                "There was an error updating '$documentName' in '$collectionName'.",
                e
            )
        }
    }

    override fun delete(documentName: String): Task<Void> {
        val documentReference = collectionReference.document(documentName)
        Log.i(TAG, "Deleting '$documentName' in '$collectionName'.")

        return documentReference.delete().addOnFailureListener { e ->
            Log.d(
                TAG,
                "There was an error deleting '$documentName' in '$collectionName'.",
                e
            )
        }
    }

    companion object {

        private val TAG = "FirebaseRepository"
    }

}