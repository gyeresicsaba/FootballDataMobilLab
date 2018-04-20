package com.example.gyere.footballdata.mock.interceptors;

import android.net.Uri;

import com.example.gyere.footballdata.network.NetworkConfig;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

public class TeamMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

//
//        if (uri.getPath().equals(NetworkConfig.ENDPOINT_ADDRESS + "Todos") && request.method().equals("POST")) {
//            responseString = "";
//            responseCode = 200;
//        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_ADDRESS + "Todos") && request.method().equals("Get")) {
//            MemoryRepository memoryRepository = new MemoryRepository();
//            memoryRepository.open(null);
//            //responseString = GsonHelper.getGson().toJson(memoryRepository.getFavourites());
//            responseString = "";
//            responseCode = 200;
//        } else {
//            responseString = "ERROR";
//            responseCode = 503;
//        }
//
//        return makeResponse(request, headers, responseCode, responseString);
        return null;
    }
}
