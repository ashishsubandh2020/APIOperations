package com.operation.util;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;




@Component
public class WebServiceUtil {
	
	public HttpHeaders getHeaders( )
	{
		HttpHeaders  httpHeaders=new HttpHeaders();
		    httpHeaders.add("vary","Accept-Encoding");

		    httpHeaders.add("cache-control","no-cache");
httpHeaders.add("content-length","131");
		    
		  httpHeaders.add("expires","-1");
		  return httpHeaders;
	}
	
	public static int[] toArray(String json, Gson parser) {
        return parser.fromJson(json, int[].class);
    }
	
	}
