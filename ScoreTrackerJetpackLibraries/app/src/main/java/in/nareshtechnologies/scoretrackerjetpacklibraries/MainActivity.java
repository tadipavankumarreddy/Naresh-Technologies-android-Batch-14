package in.nareshtechnologies.scoretrackerjetpacklibraries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import in.nareshtechnologies.scoretrackerjetpacklibraries.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainViewModel mvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mvm = new ViewModelProvider(this).get(MainViewModel.class);

        binding.result.setText(String.valueOf(mvm.count));

        binding.plusBtn.setOnClickListener(v -> {
            mvm.increment();
            binding.result.setText(String.valueOf(mvm.count));
        });

        binding.minusBtn.setOnClickListener(v -> {
            mvm.decrement();
            binding.result.setText(String.valueOf(mvm.count));
        });
    }
}