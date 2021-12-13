package android.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class filmsListAdapter extends
        RecyclerView.Adapter<filmsListAdapter.WordViewHolder>{

    private final LinkedList<String> films;
    private final LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView filmItemView;
        final filmsListAdapter mAdapter;

        public WordViewHolder(View itemView, filmsListAdapter adapter) {
            super(itemView);
            filmItemView = itemView.findViewById(R.id.film);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = films.get(mPosition);

            //TODO: Open new view with details about film

            mAdapter.notifyDataSetChanged();
        }
    }

    public filmsListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.films = wordList;
    }

    @Override
    public filmsListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.filmlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(filmsListAdapter.WordViewHolder holder,
                                 int position) {
        String mCurrent = films.get(position);
        holder.filmItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return films.size();
    }
}
