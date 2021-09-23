package com.example.surveyapp.utils;

public class GetURI {
    public static String getUri(String path){
        return path.replaceFirst("/surveyApp/","");
    }
}
