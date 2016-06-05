package com.tutorialsbuzz.recyclerview.TabFragments;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tutorialsbuzz.recyclerview.R;

import java.util.List;

public class RVTwoAdapter extends RecyclerView.Adapter<RVTwoAdapter.ItemViewHolder> implements View.OnClickListener{

    private List<String> mItems;
    private OnRecyclerViewItemClickListener<String> itemClickListener;



    public RVTwoAdapter(List<String> mItems) {
        this.mItems = mItems;

    }

    @Override
    public void onClick(View v) {

        if (itemClickListener != null) {
            String model = (String) v.getTag();
            itemClickListener.onItemClick(v, model);
        }

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.list_item);
        }
    }

    public void add(String item, int position) {

        mItems.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
//        int position = mItems.indexOf(item);
        mItems.remove(0);
        notifyItemRemoved(0);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener<String> listener) {
        this.itemClickListener = listener;
    }


    public void update() {
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.mTextView.setText(mItems.get(i));
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        view.setOnClickListener(this);
        return itemViewHolder;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
