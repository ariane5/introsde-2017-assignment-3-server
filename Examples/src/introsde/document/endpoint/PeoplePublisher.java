package introsde.document.endpoint;

import java.util.ArrayList;
import java.util.List;

import introsde.document.model.Activity;
import introsde.document.model.ActivityPreference;
import introsde.document.model.Person;
import introsde.document.ws.PeopleImpl;

import javax.xml.ws.Endpoint;

public class PeoplePublisher {
    public static String SERVER_URL = "http://localhost";
    public static String PORT = "6902";
    public static String BASE_URL = "/ws/people";
    //public static List<ActivityPreference>	ls2 ;
    public static String getEndpointURL() {
        return SERVER_URL+":"+PORT+BASE_URL;
    }

    public static void main(String[] args) {
        String endpointUrl = getEndpointURL();
        System.out.println("Starting People Service...");
        System.out.println("--> Published at = "+endpointUrl);
        Endpoint.publish(endpointUrl, new PeopleImpl());
        
       
        
    }
 
 
}