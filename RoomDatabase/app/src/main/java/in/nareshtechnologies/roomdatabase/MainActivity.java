package in.nareshtechnologies.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name,age;
    TextView result;

    PersonDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.person_name);
        age = findViewById(R.id.person_age);
        result = findViewById(R.id.result);

        database = Room.databaseBuilder(this,PersonDatabase.class,"nareshitech")
                .allowMainThreadQueries()
                .build();
    }

    public void saveData(View view) {
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());

        Person p = new Person(n,a);
        database.personDAO().insertData(p);
    }

    public void loadData(View view) {

        List<Person> p = database.personDAO().getData();

        result.setText("");

        for(Person person : p){
            result.append(person.getPerson_id()+"\n"+person.getPerson_name()+"\n"+person.getPerson_age()+"\n\n");
        }

    }
}