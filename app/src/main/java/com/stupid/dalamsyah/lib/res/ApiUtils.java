package com.stupid.dalamsyah.lib.res;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://api.studistupid.com/";

    public static ApiService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }

}
