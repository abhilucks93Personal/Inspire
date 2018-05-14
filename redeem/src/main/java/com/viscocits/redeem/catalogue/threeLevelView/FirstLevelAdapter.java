package com.viscocits.redeem.catalogue.threeLevelView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.viscocits.redeem.R;
import com.viscocits.redeem.catalogue.CatalogueFragment;
import com.viscocits.redeem.catalogue.ModelGetAllCategoriesData;

import java.util.ArrayList;

public class FirstLevelAdapter extends BaseExpandableListAdapter {

    private final ArrayList<ModelGetAllCategoriesData> categories;
    private final CatalogueFragment catalogueFragment;
    private Activity context;

    public FirstLevelAdapter(Activity context, CatalogueFragment catalogueFragment, ArrayList<ModelGetAllCategoriesData> categories) {
        this.context = context;
        this.categories = categories;
        this.catalogueFragment = catalogueFragment;

    }

    @Override
    public Object getChild(int arg0, int arg1) {
        return arg1;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final int mainGroupPosition = groupPosition;
        SecondLevelExpandableListView secondLevelELV = new SecondLevelExpandableListView(context);
        secondLevelELV.setAdapter(new SecondLevelAdapter(context, categories.get(groupPosition).getSubCategories()));
        //secondLevelELV.setGroupIndicator(null);

        secondLevelELV.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                catalogueFragment.openProductActivity(categories.get(mainGroupPosition).getSubCategories().get(groupPosition).getSubCategories().get(childPosition).getId());

                return true;
            }


        });


        return secondLevelELV;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return categories.get(groupPosition).getSubCategories().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public int getGroupCount() {
        return categories.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final ModelGetAllCategoriesData data = categories.get(groupPosition);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_categories_level_first, null);
            TextView tvCategoriesLevelOne = convertView.findViewById(R.id.tv_categories_level_one);
            if (data != null) {
                tvCategoriesLevelOne.setText(data.getName());
            }
        }
        return convertView;
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


 /* secondLevelELV.setOnGroupClickListener(new android.widget.ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

               // catalogueFragment._onGroupClick(parent, v, mainGroupPosition, groupPosition, -1, id, 2);

               *//* if (categories.get(mainGroupPosition).getSubCategories().get(groupPosition).getSubCategories() == null || categories.get(mainGroupPosition).getSubCategories().get(groupPosition).getSubCategories().size() == 0) {
                    Utility.showToast(context, categories.get(groupPosition).getName());
                } else {
                    if (parent.isGroupExpanded(groupPosition)) {
                        parent.collapseGroup(groupPosition);
                    } else {
                        parent.expandGroup(groupPosition);
                    }
                }*//*


                return true;
            }
        });

        secondLevelELV.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

              //  catalogueFragment._onGroupClick(parent, v, mainGroupPosition, groupPosition, childPosition, id, 3);

               *//* if (categories.get(mainGroupPosition).getSubCategories().get(groupPosition).getSubCategories() == null || categories.get(mainGroupPosition).getSubCategories().get(groupPosition).getSubCategories().size() == 0) {
                    Utility.showToast(context, categories.get(groupPosition).getName());
                } else {
                    if (parent.isGroupExpanded(groupPosition)) {
                        parent.collapseGroup(groupPosition);
                    } else {
                        parent.expandGroup(groupPosition);
                    }
                }*//*

                return true;
            }


        });
*/


       /* final int mainGroupPosition = groupPosition;
        SecondLevelExpandableListView secondLevelELV = new SecondLevelExpandableListView(context);
        secondLevelELV.setAdapter(new SecondLevelAdapter(context, categories.get(groupPosition).getSubCategories()));
        //secondLevelELV.setGroupIndicator(null);
        secondLevelELV.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

                // catalogueFragment._onGroupClick(parent, v, mainGroupPosition, groupPosition, -1groupPosition, id, 2);

                if (categories.get(groupPosition).getSubCategories() == null || categories.get(groupPosition).getSubCategories().size() == 0) {
                    Utility.showToast(context, categories.get(groupPosition).getName());
                } else {
                    if (parent.isGroupExpanded(groupPosition)) {
                        parent.collapseGroup(groupPosition);
                    } else {
                        parent.expandGroup(groupPosition);
                    }
                }

                return true;
            }
        });*/