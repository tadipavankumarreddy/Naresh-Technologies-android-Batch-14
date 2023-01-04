package in.nareshtechnologies.favoritemovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int[] movie_posters;
    String[] movie_names;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);

        prepareData();

        MoviesAdapter ma = new MoviesAdapter(this, movie_posters, movie_names);

        recyclerView.setAdapter(ma);
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));*/
        /*recyclerView.setLayoutManager(new GridLayoutManager(this,2));*/
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

    }

    private void prepareData() {
        movie_posters = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
        R.drawable.f, R.drawable.g,R.drawable.h,R.drawable.i, R.drawable.j};

        movie_names = new String[]{"Anabelle","Beauty and the beast", "chronicle of Narnia","Dabanng",
                "ek tha tiger","Fan","Gadar","Heropanti","Ice Age", "Jab we Met"};
    }
}


/**
 * Data
 * Layout (design)
 * Adapter
 * ViewHolder
 * Recyclerview
 * LayoutManger
 * */
// TODO 1: Prepare Data
// TODO 2: Design a layout file that represents all the items design on REcyclerview
// TODO 3: Create an Adapter along with the view holder
// TODO 4: connect the recyclerview
