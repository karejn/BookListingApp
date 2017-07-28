package com.example.ekzhu.booklistingapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ekzhu on 12.07.2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {

   // ViewHolder
    static class ViewHolder {
        private ImageView imageImageView;
        private TextView titleTextView;
        private TextView authorTextView;
    }

    /**
     * @param context of the app.
     * @param books   is the list of books, which is the data source of the adapter.
     */

    public BookAdapter(Activity context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    /**
     * Returns a list item view that displays information about the book at the given position
     * in the list of books.
     */

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        final Book currentBook = getItem(position);
        ViewHolder holder;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder();
            holder.titleTextView = (TextView) listItemView.findViewById(R.id.book_title);
            holder.authorTextView = (TextView) listItemView.findViewById(R.id.book_author);
            holder.imageImageView = (ImageView) listItemView.findViewById(R.id.book_image);
            listItemView.setTag(holder);

        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        holder.titleTextView.setText(currentBook.getTitle());
        holder.authorTextView.setText(currentBook.getAuthor());

        Picasso.with(getContext()).setLoggingEnabled(true);

        Picasso.with(getContext())
                .load(currentBook.getImageUrl())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.no_placeholder)
                .into(holder.imageImageView);

        return listItemView;
    }
}
