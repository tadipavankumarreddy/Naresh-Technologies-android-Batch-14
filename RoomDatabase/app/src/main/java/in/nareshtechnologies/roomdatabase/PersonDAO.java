package in.nareshtechnologies.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonDAO {

    @Insert
    void insertData(Person p);

    @Update
    void updateData(Person p);

    @Query("Select * from person")
    List<Person> getData();

}
