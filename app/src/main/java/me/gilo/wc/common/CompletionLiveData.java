package me.gilo.wc.common;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public final class CompletionLiveData extends LiveData<Resource<Boolean>> implements OnCompleteListener<Void> {


    public CompletionLiveData() {
        setValue(new Resource<>(Status.LOADING));
    }

    @Override
    public final void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
            setValue(new Resource<>(true));
        } else {
            setValue(new Resource<>(task.getException()));
        }
    }
}
