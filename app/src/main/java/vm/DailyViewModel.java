package vm;

import android.databinding.ObservableField;

/**
 * Daily View Model Created by wsw on 2016/12/11.
 */

public class DailyViewModel {
    public final ObservableField<String> desc = new ObservableField<>();
    public final ObservableField<String> author = new ObservableField<>();
    public final ObservableField<String> time = new ObservableField<>();
    public final ObservableField<String> type = new ObservableField<>();
    public final ObservableField<String> url = new ObservableField<>();
}
