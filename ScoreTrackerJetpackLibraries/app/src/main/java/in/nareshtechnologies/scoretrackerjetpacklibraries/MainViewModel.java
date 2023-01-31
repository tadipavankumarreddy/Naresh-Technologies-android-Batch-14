package in.nareshtechnologies.scoretrackerjetpacklibraries;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData<Integer> count;
    //The view model will be created here
    public MainViewModel() {
        count = new MutableLiveData<>();
        count.setValue(0);
        Log.i("MAIN3","ViewModel is Created");
    }

    public void increment(){
        count.setValue(count.getValue() + 1);
    }

    public void decrement(){
        count.setValue(count.getValue() - 1);
    }
    // ViewModel will be destroyed
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("MAIN3","ViewModel is Destroyed");
    }
}
