package com.example.social_media_using_blockchain;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ReelsFragment extends Fragment {

    public ReelsFragment() {
        // Required empty public constructor
    }

    public static ReelsFragment newInstance() {
        Bundle args = new Bundle();
        ReelsFragment fragment = new ReelsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reels, container, false);
    }
}