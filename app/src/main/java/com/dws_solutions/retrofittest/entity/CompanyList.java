package com.dws_solutions.retrofittest.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Project: RetrofitTest
 *
 * @package: com.dws_solutions.retrofittest.network
 * <p>
 * Created by Sven on 15.11.2016..
 * DwS-Solutions.com - All rights reserved  - Copyright (c) 2016
 */
public class CompanyList {


        @SerializedName("data")
        private List<Company> companies;
        // ...

}
