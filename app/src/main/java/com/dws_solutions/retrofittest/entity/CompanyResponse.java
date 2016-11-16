package com.dws_solutions.retrofittest.entity;

/**
 * Project: RetrofitTest
 *
 * @package: com.dws_solutions.retrofittest.network
 * <p>
 * Created by Sven on 15.11.2016..
 * DwS-Solutions.com - All rights reserved  - Copyright (c) 2016
 */

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**

 {
    "response": [{
            "id": 1,
            "hostname": "example1.com",
            "name": "Company Name",
            "address": null,
            "phone": null,
            "fax": null
        }, {
            "id": 2,
            "hostname": "example2.com",
            "name": "Company Name 2",
            "address": null,
            "phone": null,
            "fax": null
    }]
 }

 */

public class CompanyResponse {
    @SerializedName("response")
    public List<Company> response;

    public List<Company> getResponse() {
        return response;
    }

    public void setResponse(List<Company> response) {
        this.response = response;
    }
}
