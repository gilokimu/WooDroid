package me.gilo.wc.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import me.gilo.wc.utils.ViewModelFactory;
import me.gilo.wc.viewmodels.CategoryViewModel;
import me.gilo.wc.viewmodels.ProductViewModel;
import me.gilo.wc.viewmodels.ReviewViewModel;


@SuppressWarnings("WeakerAccess")
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel.class)
    abstract ViewModel bindProductViewModel(ProductViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel.class)
    abstract ViewModel bindCategoryViewModel(CategoryViewModel viewModel);


    @Binds
    @IntoMap
    @ViewModelKey(ReviewViewModel.class)
    abstract ViewModel bindRevuewViewModel(ReviewViewModel viewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
