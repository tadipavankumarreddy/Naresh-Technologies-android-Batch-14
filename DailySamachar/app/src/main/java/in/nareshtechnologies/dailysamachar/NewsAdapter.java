package in.nareshtechnologies.dailysamachar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;
    List<Datum> data;

    public NewsAdapter(Context context, List<Datum> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_row_design,parent,false);
        NewsViewHolder na = new NewsViewHolder(v);
        return na;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getImageUrl()).into(holder.news_images);
        holder.news_titles.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView news_images;
        TextView news_titles;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            news_images = itemView.findViewById(R.id.news_image);
            news_titles = itemView.findViewById(R.id.news_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Datum d = data.get(position);
            Intent i = new Intent(context,DetailsActivity.class);
            i.putExtra("ADATA",d);
            context.startActivity(i);
        }
    }
}
