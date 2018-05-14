package com.viscocits.redeem.catalogue.threeLevelView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.viscocits.redeem.R;
import com.viscocits.redeem.catalogue.ModelGetAllCategoriesData;
import com.viscocits.redeem.utils.Utility;

import java.util.ArrayList;

public class SecondLevelAdapter extends BaseExpandableListAdapter {

    private final ArrayList<ModelGetAllCategoriesData> subCategories;
    private Activity context;

    public SecondLevelAdapter(Activity context, ArrayList<ModelGetAllCategoriesData> subCategories) {
        this.context = context;
        this.subCategories = subCategories;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public int getGroupCount() {
        return subCategories.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final ModelGetAllCategoriesData data = subCategories.get(groupPosition);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_categories_level_second, null);
            TextView tvCategoriesLevelTwo = convertView.findViewById(R.id.tv_categories_level_two);
            if (data != null) {
                tvCategoriesLevelTwo.setText(data.getName());
                /*tvCategoriesLevelTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (data.getSubCategories() == null || data.getSubCategories().size() == 0) {
                            Utility.showToast(context, data.getName());
                        }
                    }
                });*/
            }
        }
        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final ModelGetAllCategoriesData data = subCategories.get(groupPosition).getSubCategories().get(childPosition);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_categories_level_third, null);
            TextView tvCategoriesLevelThree = convertView.findViewById(R.id.tv_categories_level_three);
            if (data != null) {
                tvCategoriesLevelThree.setText(data.getName());
               /* tvCategoriesLevelThree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Utility.showToast(context, data.getName());
                    }
                });*/
            }

        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return subCategories.get(groupPosition).getSubCategories().size();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}