package vm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

import javax.inject.Inject;

/**
 * Generated code from DBinding. Do not modify!
 */
public class EventViewModel extends BaseObservable {
    @Inject
    public EventViewModel() {
    }

    private android.view.View.OnClickListener onClick;

    public void setOnClick(android.view.View.OnClickListener onClick) {
        this.onClick = onClick;
        notifyPropertyChanged(BR.onClick);
    }

    @Bindable
    public android.view.View.OnClickListener getOnClick() {
        return this.onClick;
    }
}