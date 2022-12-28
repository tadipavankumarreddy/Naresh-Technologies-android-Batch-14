package in.nareshtechnologies.uicomponents;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name,age;
    TextView result;
    RadioGroup rg; String g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.person_name);
        age = findViewById(R.id.person_age);
        result = findViewById(R.id.result);
        rg = findViewById(R.id.gender);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup.getCheckedRadioButtonId() == R.id.male){
                    g = "male";
                }else if(radioGroup.getCheckedRadioButtonId() == R.id.female){
                    g = "female";
                }else{
                    g = "Others";
                }
            }
        });
    }

    public void submit(View view) {
        // This method will be invoked as soon as the submit button is pressed on the screen
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        result.setText(n+"\n"+a+"\n"+g);
    }
}