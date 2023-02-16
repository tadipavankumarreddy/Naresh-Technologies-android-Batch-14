package `in`.nareshtechnologies.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count : Int = 0

        val tv : TextView = findViewById(R.id.textView);
        val b1 : Button = findViewById(R.id.button);
        val b2 : Button = findViewById(R.id.button2);

        b1.setOnClickListener(View.OnClickListener {
            count++
            tv.text = ""+count
        })

        b2.setOnClickListener(View.OnClickListener {
            count--
            tv.text = ""+count
        })
    }
}