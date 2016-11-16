package com.dws_solutions.retrofittest.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Project: RetrofitTest
 *
 * @package: com.dws_solutions.retrofittest.network
 * <p>
 * Created by Sven on 13.11.2016..
 * DwS-Solutions.com - All rights reserved  - Copyright (c) 2016
 */
public class Company {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("fax")
    @Expose
    private String fax;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     *
     * @param hostname
     * The hostname
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     * The fax
     */
    public String getFax() {
        return fax;
    }

    /**
     *
     * @param fax
     * The fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }


    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", hostname='" + hostname + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }
}
