package introsde.document.ws;

import javax.jws.WebService;

import introsde.document.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//Service Implementation

@WebService(endpointInterface = "introsde.document.ws.People", serviceName="PeopleService")
public class PeopleImpl implements People {

   //step1  fill the database   
    @Override
    public List<Person>  filldb() throws IOException {
    	
			return DataBaseInit.fillDataBase();
		
    }
    
    
    // step2 read the person identified with id
	@Override
    public Person readPerson(int id) {
        System.out.println("---> Reading Person by id = "+id);
        Person p = Person.getPersonById(id);
        if (p!=null) {
            System.out.println("---> Found Person by id = "+id+" => "+p.getFirstname());
        } else {
            System.out.println("---> Didn't find any Person with  id = "+id);
        }
        return p;
    }
    
	
	//step3 get the list of people
    @Override
    public List<Person> getPeople() {
        return Person.getAll();
    }
    
    
    
    //step4 add a new person in the database
    @Override
    public int addPerson(Person person) {
    	person.setIdPerson(Person.getAll().size()+1);
        Person.savePerson(person);
        return person.getIdPerson();
    }

    
    //step5 update the person 
    @Override
    public int updatePerson(Person person) {
        Person.updatePerson(person);
        return person.getIdPerson();
    }
    
    
    //step6 delete person with id
    @Override
    public int deletePerson(int id) {
        Person p = Person.getPersonById(id);
        if (p!=null) {
            Person.removePerson(p);
            return 0;
        } else {
            return -1;
        }
    }

    
    
    //step7 update the preferences of person with id
    @Override
    public int updatePersonPP(int id, ActivityPreference hp) {
    	ActivityPreference ls = ActivityPreference.getActivityPreferenceById(hp.getIdActivityPreference());
        if (ls.getPerson().getIdPerson() == id) {
        	ActivityPreference.updateActivityPreference(hp);
            return hp.getIdActivityPreference();
        } else {
            return -1;
        }
    }
    
    
    
    //step8 read the preferences identified by the named activity: activity from person with id
    @Override
    public List<ActivityPreference> readPersonPP(int id, String activity) {
    	
  	
  		return ActivityPreference.getActivityByIdAndActivityType(id, activity);
      }
   
    //step9 save the preferences of person with id
    @Override
    public int savePersonPP(int id, ActivityPreference hp) {
    	Person p =Person.getPersonById(id);
    	hp.setIdActivityPreference(ActivityPreference.getAll().size()+1);
        if (p!=null) {
        	hp.setPerson(p);
        	ActivityPreference.saveActivityPreference(hp);
            return hp.getIdActivityPreference();
        } else {
            return -1;
        }
    }
    
    
    //step10 read the preferences identified by id: activity_id from person with id
    @Override
    public List<ActivityPreference> readPersonPPID(int id,  int  activity_id){
  	 
  		return ActivityPreference.getActivityByIdPersonAndActivity_id(id, activity_id);
     }
   
    
    
    // step11 read all preferences
    @Override
    public List<ActivityPreference> readPreferences(){
    	List<ActivityPreference> l =ActivityPreference.getAll();
    	return l;
    	
    }
    
   
   
}