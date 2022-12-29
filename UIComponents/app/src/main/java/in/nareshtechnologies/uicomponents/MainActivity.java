package in.nareshtechnologies.uicomponents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name, age;
    TextView result;
    RadioGroup rg;
    String g,country,feature;
    CheckBox hin, eng, tel;
    Spinner s;
    SwitchCompat sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.person_name);
        age = findViewById(R.id.person_age);
        result = findViewById(R.id.result);
        rg = findViewById(R.id.gender);
        hin = findViewById(R.id.hin);
        eng = findViewById(R.id.eng);
        tel = findViewById(R.id.tel);
        s = findViewById(R.id.countries);
        sc = findViewById(R.id.switch_btn);

        rg.setOnCheckedChangeListener((radioGroup, i) -> {
            if (radioGroup.getCheckedRadioButtonId() == R.id.male) {
                g = "male";
            } else if (radioGroup.getCheckedRadioButtonId() == R.id.female) {
                g = "female";
            } else {
                g = "Others";
            }
        });

        sc.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b){
                feature = "turn on";
            }else{
                feature = "turn off";
            }
        });

        // How to populate data on Spinner using java
        String[] cl = new String[]{"India","Pakistan","Bangladesh"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cl);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                country = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                country = "";
            }
        });
    }

    public void submit(View view) {
        // This method will be invoked as soon as the submit button is pressed on the screen
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        String lk = "";
        if (hin.isChecked())
            lk += "Hindi\n"; // lk = lk + "Hindi\n";
        if (eng.isChecked())
            lk += "English\n";
        if (tel.isChecked())
            lk += "Telugu\n";
        result.setText(n + "\n" + a + "\n" + g+"\n"+lk+"\n"+country+"\n"+feature);
    }
}