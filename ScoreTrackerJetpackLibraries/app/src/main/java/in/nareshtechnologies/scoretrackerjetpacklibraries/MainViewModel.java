package in.nareshtechnologies.scoretrackerjetpacklibraries;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    int count;
    //The view model will be created here
    public MainViewModel() {
        count = 0;
        Log.i("MAIN3","ViewModel is Created");
    }

    public void increment(){
        count++;
    }

    public void decrement(){
        count--;
    }
    // ViewModel will be destroyed
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("MAIN3","ViewModel is Destroyed");
    }
}
