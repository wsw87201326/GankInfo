package vm;

import android.databinding.ObservableField;

import javax.inject.Inject;

/**
 * Created by wsw on 2016/12/16.
 */

public class DailyImgViewModel {

    @Inject
    public DailyImgViewModel() {
    }

    public final ObservableField<String> url = new ObservableField<>();
    public final ObservableField<String> time = new ObservableField<>();
}
