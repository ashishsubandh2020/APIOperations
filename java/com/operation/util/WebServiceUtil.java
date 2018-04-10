package com.operation.util;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import MathResults.FibonacciResult;


@Component
public class WebServiceUtil {
	
	public HttpHeaders getHeaders( )
	{
		HttpHeaders  httpHeaders=new HttpHeaders();
		  //  httpHeaders.add("content-encoding","gzip");
		    httpHeaders.add("vary","Accept-Encoding");
		    httpHeaders.add("content-type","application/json; charset=utf-8");
		    httpHeaders.add("cache-control","no-cache");
		  httpHeaders.add("expires","-1");
		  return httpHeaders;
	}
	
	public static int[] toArray(String json, Gson parser) {
        return parser.fromJson(json, int[].class);
    }
	
	}
