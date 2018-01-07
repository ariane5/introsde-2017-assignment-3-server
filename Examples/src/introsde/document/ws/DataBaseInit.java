package introsde.document.ws;

import introsde.document.model.*;

import java.io.IOException;
import java.util.List;


public class DataBaseInit {
	public DataBaseInit(){};
	

	
	public static List<Person>  fillDataBase() throws IOException{
		DataBaseInit	db = new DataBaseInit();
		   db.CreateActivity("sport");
		   db.CreateActivity("social");
		   db.CreateActivity("school");
		   db.CreatePerson("mario", "marco", "17-02-1978");
		   db.CreatePerson("john", "john", "11-12-1988");
		   db.CreatePerson("marc","marc", "18-09-1958");
		   db.CreatePerson("paul", "paul", "19-07-1968");
		   db.CreatePerson("esther", "esther", "20-10-1990");
		   db.CreateActivityPreference("swimming", "friends competition", "Trento city", "2017-09-13T12:00:00.0", 1,"sport");
		   db.CreateActivityPreference("football", "final", "sanbartolameo", "2017-09-13T19:00:00.0", 1,"sport");
		   db.CreateActivityPreference("swimming", "competition 2017", "Trento city", "2017-09-13T12:00:00.0", 2,"sport");
		   db.CreateActivityPreference("football", "calcio amicale", "sanbartolameo", "2017-09-13T19:00:00.0", 3,"sport");
		   db.CreateActivityPreference("discussion", "social media", "sanbartolameo", "2017-09-13T20:00:00.0", 4,"social");
		   db.CreateActivityPreference("economics", "innovation and management", "povo", "2017-09-13T9:00:00.0", 5,"school");
		   List<Person> people = Person.getAll();
		    return people;
	}
	
	public void CreatePerson(String fname,String lname,String bdate) throws IOException {
		Person p = new Person();
		List<Person> people = Person.getAll();
		int count = people.size();
        p.setFirstname(fname);
		p.setLastname(lname);
		p.setBirthdate(bdate);
    	p.setIdPerson(count +1);
    	System.out.println(count +1);
		 Person.savePerson(p);
	}
	
	public void CreateActivityPreference( String name,String description,String place,String startdate,int idP,String type) throws IOException {
		ActivityPreference ac = new ActivityPreference();
		Person p= Person.getPersonById(idP);
		Activity a = Activity.getActivityByActivtyType(type);
		List<ActivityPreference> acT = ActivityPreference.getAll();
		int count = acT.size();
		ac.setName(name);
		ac.setDescription(description);
		ac.setPerson(p);
		ac.setPlace(place);
		ac.setStartdate(startdate);
		ac.setIdActivityPreference(count +1);
		ac.setActivity(a);
        
    	 
       ActivityPreference.saveActivityPreference(ac);
	}
	
	public void CreateActivity(String name) throws IOException {
		Activity a= new Activity();
         a.setName(name);
         List<Activity> acT = Activity.getAll();
  		int count = acT.size();
  		a.setIdActivity(count+1);
         Activity.saveActivity(a);
         
	}
	
	

}
