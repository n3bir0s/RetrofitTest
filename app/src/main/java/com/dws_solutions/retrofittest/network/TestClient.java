package com.dws_solutions.retrofittest.network;

import com.dws_solutions.retrofittest.entity.ResponseCompany;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Project: RetrofitTest
 *
 * @package: com.dws_solutions.retrofittest.network
 * <p>
 * Created by Sven on 13.11.2016..
 * DwS-Solutions.com - All rights reserved  - Copyright (c) 2016
 */
public interface TestClient {
    @GET("/api/api.php")
    Call<ResponseCompany> getCompanies();

}

