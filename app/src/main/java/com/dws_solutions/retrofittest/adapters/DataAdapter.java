package com.dws_solutions.retrofittest.adapters;

/**
 * Project: RetrofitTest
 *
 * @package: com.dws_solutions.retrofittest.adapters
 * <p>
 * Created by Sven on 16.11.2016..
 * DwS-Solutions.com - All rights reserved  - Copyright (c) 2016
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dws_solutions.retrofittest.R;
import com.dws_solutions.retrofittest.entity.Company;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Company> companies;

    public DataAdapter(ArrayList<Company> companies) {
        this.companies = companies;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.company_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_name.setText(companies.get(i).getName());
        viewHolder.tv_subtitle.setText(companies.get(i).getHostname());
        viewHolder.tv_address.setText(companies.get(i).getAddress());
        viewHolder.tv_phone.setText(companies.get(i).getPhone());
        viewHolder.tv_fax.setText(companies.get(i).getFax());
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_subtitle,tv_address, tv_phone, tv_fax;
        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.label_name);
            tv_subtitle = (TextView)view.findViewById(R.id.label_subtitle);
            tv_address = (TextView)view.findViewById(R.id.label_address);
            tv_phone = (TextView)view.findViewById(R.id.label_phone);
            tv_fax = (TextView)view.findViewById(R.id.label_fax);

        }
    }

}
