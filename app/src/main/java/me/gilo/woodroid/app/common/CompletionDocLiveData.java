package me.gilo.woodroid.app.common;

import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;


public final class CompletionDocLiveData extends LiveData<Resource<Boolean>> implements OnCompleteListener<DocumentReference> {


    public CompletionDocLiveData() {
        setValue(new Resource<>(Status.LOADING));
    }

    @Override
    public final void onComplete(@NonNull Task<DocumentReference> task) {
        if (task.isSuccessful()) {
            setValue(new Resource<>(true));
        } else {
            setValue(new Resource<>(task.getException()));
        }
    }
}
