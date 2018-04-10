package com.operation.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.operation.service.MathOperationService;
import com.operation.util.WebServiceUtil;

import MathResults.CombinedArray;
import MathResults.FibonacciResult;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;



@RestController
public class MathOperationController {
	public static final  String API_URL="/api";
@Autowired
MathOperationService mathOperationService;
@Autowired
WebServiceUtil util;
@RequestMapping(value = API_URL+"/TriangleType", method = RequestMethod.GET)
@ResponseBody
@ResponseStatus(value = HttpStatus.OK)
public ResponseEntity<String>  getTriangleType(@RequestParam(value = "a") String sideA,
		@RequestParam(value = "b") String sideB,
		@RequestParam(value = "c") String sideC) {
    int a = Integer.valueOf(sideA);
    int b = Integer.valueOf(sideB);  
    int c = Integer.valueOf(sideC);
    HttpHeaders httpHeaders=util.getHeaders();
  String triangleType=mathOperationService.getTriangleType(a, b, c);

    return new ResponseEntity<String>(triangleType,httpHeaders,HttpStatus.OK);
    
}

@RequestMapping(value = API_URL+"/fibonacci", method = RequestMethod.GET)
@ResponseBody
@ResponseStatus(value = HttpStatus.OK)
public ResponseEntity<String> fibonacci(@RequestParam(value = "num", defaultValue = "1") String parm) {
        int num = Integer.valueOf(parm);
        HttpHeaders httpHeaders=util.getHeaders();
        String result= Integer.toString(MathOperationService.fib(num+1));
        return new ResponseEntity<String>(result,httpHeaders,HttpStatus.OK);
}
@RequestMapping(value = API_URL+"/ReverseWords", method = RequestMethod.GET)
@ResponseBody
@ResponseStatus(value = HttpStatus.OK)
public ResponseEntity<String> reverseWords(@RequestParam(value = "sentence", defaultValue = "1") String sentence) {
        
        HttpHeaders httpHeaders=util.getHeaders();
        String result=mathOperationService.reverseWordInMyString(sentence);
        return new ResponseEntity<String>(result,httpHeaders,HttpStatus.OK);
}
@RequestMapping(value = API_URL+"/makeonearray", method = RequestMethod.POST)
@ResponseBody
@ResponseStatus(value = HttpStatus.OK)
public ResponseEntity<CombinedArray> combinedArrayResult(@RequestBody JSONObject requestJson) {
	
	Gson parser = new Gson();
	TreeSet<Integer> resultSet=new TreeSet<>();
    Set<String> keys = requestJson.keySet();
   for (final String key : keys) {
   String json= requestJson.get(key).toString();
	int[] arr = WebServiceUtil.toArray(json, parser);
	for(int i=0;i<arr.length;i++)
	{
		resultSet.add(arr[i]);
	}
   }
 Integer[] result = resultSet.toArray(new Integer[resultSet.size()]);
 CombinedArray combinedResult=new CombinedArray();
 combinedResult.setArray(result);
 HttpHeaders httpHeaders=util.getHeaders();
 return new ResponseEntity<CombinedArray>(combinedResult,httpHeaders,HttpStatus.OK);
}
}
