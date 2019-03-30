package me.gilo.wc.repo;

import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import me.gilo.wc.models.Identifiable;
import me.gilo.wc.models.Repository;


/**
 * Manages data access for Firebase
 */
public class FirebaseRepository<TEntity extends Identifiable<String>> implements Repository<TEntity, String> {

    private static final String TAG = "FirebaseRepository";

    private final Class<TEntity> entityClass;

    private final CollectionReference collectionReference;
    private final String collectionName;


    public FirebaseRepository(Class<TEntity> entityClass, String collectionName) {
        this.collectionName = collectionName;
        this.entityClass = entityClass;

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        this.collectionReference = db.collection(this.collectionName);
    }

    @Override
    public Task<Boolean> exists(final String documentName) {
        DocumentReference documentReference = collectionReference.document(documentName);
        Log.i(TAG, "Checking existence of '" + documentName + "' in '" + collectionName + "'.");

        return documentReference.get().continueWith(new Continuation<DocumentSnapshot, Boolean>() {
            @Override
            public Boolean then(@NonNull Task<DocumentSnapshot> task) {
                Log.d(TAG,"Checking if '" + documentName + "' exists in '" + collectionName +"'.");
                return task.getResult().exists();
            }
        });
    }

    @Override
    public Task<TEntity> get(String id) {
        final String documentName = id;
        DocumentReference documentReference = collectionReference.document(documentName);
        Log.i(TAG, "Getting '" + documentName + "' in '" + collectionName + "'.");

        return documentReference.get().continueWith(new Continuation<DocumentSnapshot, TEntity>() {
            @Override
            public TEntity then(@NonNull Task<DocumentSnapshot> task) throws Exception {
                DocumentSnapshot documentSnapshot = task.getResult();
                if (documentSnapshot.exists()) {
                    return documentSnapshot.toObject(entityClass);
                } else {
                    Log.d(TAG, "Document '" + documentName + "' does not exist in '" + collectionName + "'.");
                    return entityClass.newInstance();
                }
            }
        });
    }

    @Override
    public Task<Void> create(TEntity entity) {
        final String documentName = entity.getEntityKey();
        DocumentReference documentReference = collectionReference.document(documentName);
        Log.i(TAG, "Creating '" + documentName + "' in '" + collectionName + "'.");
        return documentReference.set(entity).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "There was an error creating '" + documentName + "' in '" + collectionName + "'!", e);
            }
        });
    }

    @Override
    public Task<Void> update(TEntity entity) {
        final String documentName = entity.getEntityKey();
        DocumentReference documentReference = collectionReference.document(documentName);
        Log.i(TAG, "Updating '" + documentName + "' in '" + collectionName + "'.");

        return documentReference.set(entity).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "There was an error updating '" + documentName + "' in '" + collectionName + "'.", e);
            }
        });
    }

    @Override
    public Task<Void> delete(final String documentName) {
        DocumentReference documentReference = collectionReference.document(documentName);
        Log.i(TAG, "Deleting '" + documentName + "' in '" + collectionName + "'.");

        return documentReference.delete().addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "There was an error deleting '" + documentName + "' in '" + collectionName + "'.", e);
            }
        });
    }

}