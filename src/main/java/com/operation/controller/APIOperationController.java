package com.operation.controller;


import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.operation.model.CombinedArray;
import com.operation.service.APIOperationService;
import com.operation.util.BusinessException;
import com.operation.util.ErrorResponse;
import com.operation.util.WebServiceUtil;

import net.minidev.json.JSONObject;



@RestController
public class APIOperationController {
	private final Logger logger = LoggerFactory.getLogger(APIOperationController.class);
	public static final  String API_URL="/api";
@Autowired
APIOperationService mathOperationService;
@Autowired
WebServiceUtil util;
@RequestMapping(value = API_URL+"/TriangleType", method = RequestMethod.GET)
@ResponseBody
@ResponseStatus(value = HttpStatus.OK)
public ResponseEntity<String>  getTriangleType(@RequestParam(value = "a") int a,
		@RequestParam(value = "b") int b,
		@RequestParam(value = "c") int c) {
if(a<=0 ||b<=0 ||c<=0)
{
	 throw new BusinessException("Invalid Side length :Please enter positive value");
}

HttpHeaders httpHeaders=util.getHeaders();
  String triangleType=mathOperationService.getTriangleType(a, b, c);
    return new ResponseEntity<>(triangleType,httpHeaders,HttpStatus.OK);
    
}

@RequestMapping(value = API_URL+"/fibonacci", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE})
@ResponseBody
@ResponseStatus(value = HttpStatus.OK)
private ResponseEntity<String> fibonacci(@RequestParam(value = "num", defaultValue = "1") Long parm) {
	if(parm<=0)
	{
		 throw new BusinessException("Invalid inputh :Please enter positive value");
	}
        long num = Long.valueOf(parm);
        HttpHeaders httpHeaders=util.getHeaders();
        String result= Long.toString(APIOperationService.fib(num+1));
        return new ResponseEntity<>(result,httpHeaders,HttpStatus.OK);
}
@RequestMapping(value = API_URL+"/ReverseWords", method = RequestMethod.GET)
@ResponseBody
@ResponseStatus(value = HttpStatus.OK)
private ResponseEntity<String> reverseWords(@RequestParam(value = "sentence", defaultValue = "1") String sentence) {
        
        HttpHeaders httpHeaders=util.getHeaders();
        String result=mathOperationService.reverseWordInMyString(sentence);
        return new ResponseEntity<>(result,httpHeaders,HttpStatus.OK);
}
@RequestMapping(value = API_URL+"/makeonearray", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE})
@ResponseBody
@ResponseStatus(value = HttpStatus.OK)
private ResponseEntity<String> combinedArrayResult(@RequestBody JSONObject requestJson) {
	
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
 
 String combinedResponse=combinedResult.getResponse();
 System.out.println("combinedResponse"+combinedResponse);
 return new ResponseEntity<>(combinedResponse,httpHeaders,HttpStatus.OK);
}
@ExceptionHandler(Exception.class)
@ResponseBody
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
private ResponseEntity<?> handleException(Exception e) {
			System.out.println(e.getClass().getName());;
    ObjectMapper mapper = new ObjectMapper();
    e.printStackTrace();
    String json = "";
    try {
    if(e.getClass().getName().contains("HttpMessageNotReadableException"))
    {
    	ErrorResponse response = new ErrorResponse("400","Invalid input body:please check");
		json = mapper.writeValueAsString(response);
    
    }
    else
    {
    		ErrorResponse response = new ErrorResponse("400",e.getMessage());
    		json = mapper.writeValueAsString(response);
    }
    	
    } catch (JsonProcessingException e1) {
        logger.error("Error in processing json request"+e1.getMessage());
       
    }
    return new ResponseEntity<>(json + "\n", HttpStatus.BAD_REQUEST);
}
}
