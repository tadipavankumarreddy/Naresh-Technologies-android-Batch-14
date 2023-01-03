package in.nareshtechnologies.fruits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    String[] fruits;
    int[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);

        // TODO 1: You need to populate data on ListView
        // STEP 1: Create a list
        fruits = new String[]{"Apple","Banana","Grapes","Guava","Oranges"/*,"Mosambi","Pineapple","Promogranate",
        "Kiwi","Dragon","Popaya","Chickoo","Custard Apple","Water melon","Musk melon","Lichi"*/};
        // STEP 2: Create an array Adapter
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fruits);*/
        // STEP 3: attach the adapter to the ListView
      /*  listview.setAdapter(adapter);*/
        // TODO 2: Make the listview clickable
        /*listview.setOnItemClickListener((adapterView, view, i, l) ->
                Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show());*/
        // TODO 3: Customize the listview
        //STEP 1-> Prepare the data
        images  = new int[]{R.drawable.apple, R.drawable.banana, R.drawable.grapes, R.drawable.guava, R.drawable.orange};
        // STEP 2 -> create a layout for each items design
        // STEP 4 -> set the adapter
        ListViewAdapter lva = new ListViewAdapter();
        listview.setAdapter(lva);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, fruits[i], Toast.LENGTH_SHORT).show();
            }
        });
    }

    // STEP 3 -> create an inner class that extends baseadapter class
    class ListViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.one_item_design,viewGroup,false);

            TextView t = v.findViewById(R.id.textView);
            ImageView iv = v.findViewById(R.id.imageView);

            t.setText(fruits[i]);
            iv.setImageResource(images[i]);
            return v;
        }
    }

}