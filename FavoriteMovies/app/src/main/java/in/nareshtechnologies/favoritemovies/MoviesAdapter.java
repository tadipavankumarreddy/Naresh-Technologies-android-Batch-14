package in.nareshtechnologies.favoritemovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    // As soon as MoviesAdapter object is created, we need to get context, MoviesPosters, MoviesNames
    Context context;
    int[] posters;
    String[] names;

    public MoviesAdapter(Context context, int[] posters, String[] names) {
        this.context = context;
        this.posters = posters;
        this.names = names;
    }

    // It attaches (inflates) a design layout to the recyclerview item
    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_row_design,parent,false);
        return new MoviesViewHolder(v);
    }

    // Based on the adapter's position, it populates data on the recyclerview
    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        holder.movie_poster.setImageResource(posters[position]);
        holder.movie_name.setText(names[position]);
    }

    // This method returns the total number of items on recyclerview
    @Override
    public int getItemCount() {
        return posters.length;
    }

    // Here connections are established
    public class MoviesViewHolder extends RecyclerView.ViewHolder {
        ImageView movie_poster;
        TextView movie_name;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_name = itemView.findViewById(R.id.textView);
            movie_poster = itemView.findViewById(R.id.imageView);
        }
    }
}
