package com.tutorialsbuzz.recyclerview.TabFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tutorialsbuzz.recyclerview.R;

import java.util.ArrayList;

public class TabOneFragment extends Fragment {

    private RecyclerView recyclerview,recyclerviewTwo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.tab_one_fragment, container, false);

        recyclerview = (RecyclerView)view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);


        recyclerviewTwo = (RecyclerView)view.findViewById(R.id.recyclerviewtwo);

        LinearLayoutManager layoutManagertwo = new LinearLayoutManager(getActivity());
        recyclerviewTwo.setLayoutManager(layoutManagertwo);

        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            items.add("TextView_"+i);
        }

        ArrayList<String> itemsTwo = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {
            itemsTwo.add("two"+i);
        }

        final RVAdapter adapter = new RVAdapter(items);
        recyclerview.setAdapter(adapter);

        final RVTwoAdapter adapterTwo = new RVTwoAdapter(itemsTwo);
        recyclerviewTwo.setAdapter(adapterTwo);



        adapter.setOnItemClickListener(new OnRecyclerViewItemClickListener<String>() {
            @Override
            public void onItemClick(View view, String str) {
//                adapter.remove("0");
                Toast.makeText(getContext(),str+"",Toast.LENGTH_SHORT).show();
//                adapter.remove("");
                adapterTwo.add("0000000",0);

            }
        });
    }
}
