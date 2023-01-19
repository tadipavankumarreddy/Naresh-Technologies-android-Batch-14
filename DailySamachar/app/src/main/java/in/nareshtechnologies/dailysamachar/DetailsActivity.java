package in.nareshtechnologies.dailysamachar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    private ImageView details_image;
    private TextView author,date,title,content;
    private Datum d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initViews();
        d = (Datum) getIntent().getSerializableExtra("ADATA");
        Glide.with(this).load(d.getImageUrl()).into(details_image);
        author.setText(d.getAuthor());
        date.setText(d.getDate());
        title.setText(d.getTitle());
        content.setText(d.getContent());

    }



    public void openOriginal(View view) {
        String url = d.getUrl();
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

    public void readMore(View view) {
        String url = d.getReadMoreUrl();
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

    private void initViews() {
        details_image = findViewById(R.id.details_image);
        author = findViewById(R.id.details_author);
        title = findViewById(R.id.details_title);
        date = findViewById(R.id.details_date);
        content = findViewById(R.id.details_content);
    }
}