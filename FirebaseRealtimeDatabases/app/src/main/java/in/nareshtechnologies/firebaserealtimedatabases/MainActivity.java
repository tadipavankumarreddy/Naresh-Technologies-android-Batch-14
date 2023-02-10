package in.nareshtechnologies.firebaserealtimedatabases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText name,age;
    TextView result;
    ProgressBar progressBar;
    DatabaseReference dbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.person_name);
        age = findViewById(R.id.person_age);
        result = findViewById(R.id.result);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        dbr = FirebaseDatabase.getInstance().getReference("Person");
    }

    public void loadData(View view) {
        progressBar.setVisibility(View.VISIBLE);

        dbr.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBar.setVisibility(View.INVISIBLE);
                result.setText("");
                for(DataSnapshot d: snapshot.getChildren()){
                    Person p = d.getValue(Person.class);
                    result.append(p.getName()+"\n"+p.getAge()+"\n\n");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "CACELLED", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveData(View view) {
        progressBar.setVisibility(View.VISIBLE);
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        Person p = new Person(n,a);
        dbr.push().setValue(p)
                .addOnSuccessListener(unused -> {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                });
    }

}