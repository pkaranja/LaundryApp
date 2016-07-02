package com.laundry.ptah.laundryapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bmutinda.httpbuster.Api;
import com.bmutinda.httpbuster.ApiCallback;
import com.bmutinda.httpbuster.BusterResponse;
import com.bmutinda.httpbuster.HttpBuster;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.laundry.ptah.laundryapp.R;
import com.laundry.ptah.laundryapp.RecyclerViewAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ptah on 6/26/16.
 */
public class RecyclerViewFragment extends Fragment {

    static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 5;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Object> mContentItems = new ArrayList<>();
    private String category;
    private static final String TAG = "Fetch";
    Api api = new Api();


    public static RecyclerViewFragment newInstance(String category) {
        RecyclerViewFragment instance = new RecyclerViewFragment();
        instance.category = category;

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager;


        if (GRID_LAYOUT) {
            layoutManager = new GridLayoutManager(getActivity(), 2);
        } else {
            layoutManager = new LinearLayoutManager(getActivity());
        }
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());

        mAdapter = new RecyclerViewAdapter(mContentItems);

        mRecyclerView.setAdapter(mAdapter);

        {
            api.setEndpoint("https://api.icndb.com/");
            HttpBuster httpBuster = HttpBuster.withApi(api).build();

            // Get Request with other parameters added
            HashMap<String, Object> map = new HashMap<>();
            map.put("category", category);
            httpBuster.makeGetRequest("jokes/random/10", map, new ApiCallback() {
                @Override
                public void done(BusterResponse response, JSONObject jsonObject, Exception exception) {
                    Log.e(TAG, "GET with params done");
                    if ( jsonObject !=null){
                        Log.e(TAG, jsonObject.toString());
                    }

                    Log.e(TAG, "Response WITH =" +response.getString() );
                }
            });

            for (int i = 0; i < ITEM_COUNT; ++i) {

                mContentItems.add(new Object());
            }
            mAdapter.notifyDataSetChanged();
        }
    }
}
