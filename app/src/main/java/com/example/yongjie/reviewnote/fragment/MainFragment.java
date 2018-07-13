package com.example.yongjie.reviewnote.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yongjie.reviewnote.MainActivity;
import com.example.yongjie.reviewnote.R;
import com.melnykov.fab.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 主页Fragment
 */
public class MainFragment extends Fragment {


    @BindView(R.id.rv_review_content)
    RecyclerView rvReviewContent;
    Unbinder unbinder;
    @BindView(R.id.fab_add_item)
    FloatingActionButton fabAddItem;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        fabAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动添加item的AddFragment
                MainActivity activity = (MainActivity) getActivity();
                activity.addFragmentInBackStack(new AddFragment(), "AddFragment");
            }
        });
        fabAddItem.attachToRecyclerView(rvReviewContent);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
