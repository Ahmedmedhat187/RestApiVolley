package com.ahmed.restapivolley;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    Context mContext;
    private ItemClickListener mItemClickListener;
    List<Post> mPostList = new ArrayList<>();
    SimpleDateFormat mDateFormat = new SimpleDateFormat("dd-MM-yyyy");


    public PostAdapter(Context context , ItemClickListener listener) {
        mContext = context;
        this.mItemClickListener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.post_item , viewGroup , false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.title.setText(mPostList.get(position).title);
        viewHolder.author.setText(mPostList.get(position).author);
        viewHolder.date.setText(mDateFormat.format(mPostList.get(position).dateCreated));
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }


    public void setPosts(List<Post> postList) {
        mPostList = postList;
        notifyDataSetChanged();
    }

    public List<Post> getPosts() {
        return mPostList;
    }


    public interface ItemClickListener {
        void onItemClickListener(int itemId);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        TextView author;
        TextView date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            date = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            mItemClickListener.onItemClickListener(getAdapterPosition());
        }
    }



}
