package com.vikcandroid.retrofit101;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android-dev on 7/31/17.
 */

public class GithubRepoAdapter extends ArrayAdapter<GithubRepo> {

    public GithubRepoAdapter(@NonNull Context context, @NonNull List<GithubRepo> repos) {
        super(context, 0, repos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView != null) {
            listItemView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        assert listItemView != null;
        return listItemView;


    }
}
