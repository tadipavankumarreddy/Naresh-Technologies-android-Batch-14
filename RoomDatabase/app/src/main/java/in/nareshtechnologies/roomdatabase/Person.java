package in.nareshtechnologies.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {

    @PrimaryKey(autoGenerate = true)
    int person_id;

    @ColumnInfo(name = "personName")
    String person_name;

    int person_age;

    public Person(String person_name, int person_age) {
        this.person_name = person_name;
        this.person_age = person_age;
    }

    public int getPerson_id() {
        return person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public int getPerson_age() {
        return person_age;
    }
}
