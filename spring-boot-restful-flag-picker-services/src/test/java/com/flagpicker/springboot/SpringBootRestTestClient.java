package com.flagpicker.springboot;
 
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.flagpicker.springboot.model.Continent;

import com.flagpicker.springboot.model.Country;;
 

public class SpringBootRestTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/spring-boot-restful/";
     
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllContinents(){
        System.out.println("Testing listAllContinents API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> continentsMap = restTemplate.getForObject(REST_SERVICE_URI+"/continent/", List.class);
         
        if(continentsMap!=null){
            for(LinkedHashMap<String, Object> map : continentsMap){
                System.out.println("Continent id="+map.get("continentId")+", Name="+map.get("name")+", countryList="+map.get("countryList"));;
            }
        }else{
            System.out.println("No Continent exist----------");
        }
    }
    @SuppressWarnings("unchecked")
    private static void listAllCountries(){
        System.out.println("Testing listAllCountries API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> countriesMap = restTemplate.getForObject(REST_SERVICE_URI+"/country/", List.class);
         
        if(countriesMap!=null){
            for(LinkedHashMap<String, Object> map : countriesMap){
                System.out.println("Country : id="+map.get("id")+", Name="+map.get("name")+", Flag="+map.get("flag"));;
            }
        }else{
            System.out.println("No Country exist----------");
        }
    }
/*     
     GET 
    private static void getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI+"/user/1", User.class);
        System.out.println(user);
    }
     
     POST 
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User(0,"Sarah",51,134);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/user/", user, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
     PUT 
    private static void updateUser() {
        System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user  = new User(1,"Tomy",33, 70000);
        restTemplate.put(REST_SERVICE_URI+"/user/1", user);
        System.out.println(user);
    }
 
     DELETE 
    private static void deleteUser() {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/3");
    }
 
 
     DELETE 
    private static void deleteAllUsers() {
        System.out.println("Testing all delete Users API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/");
    }*/
 
    public static void main(String args[]){
    	listAllContinents();
    	listAllCountries();
   
    }
}