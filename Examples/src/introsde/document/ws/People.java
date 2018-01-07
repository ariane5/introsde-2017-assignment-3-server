package introsde.document.ws;

import introsde.document.model.*;

import java.io.IOException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface People {
	@WebMethod(operationName="filldb")
    @WebResult(name="person") 
    public  List<Person>  filldb() throws IOException;
	
    @WebMethod(operationName="readPerson")
    @WebResult(name="person") 
    public Person readPerson(@WebParam(name="personId") int id);

    @WebMethod(operationName="readPeopleList")
    @WebResult(name="people") 
    public List<Person> getPeople();

    @WebMethod(operationName="createPerson")
    @WebResult(name="personId") 
    public int addPerson(@WebParam(name="person") Person person);

    @WebMethod(operationName="updatePerson")
    @WebResult(name="personId") 
    public int updatePerson(@WebParam(name="person") Person person);

    @WebMethod(operationName="deletePerson")
    @WebResult(name="personId") 
    public int deletePerson(@WebParam(name="personId") int id);

    @WebMethod(operationName="updatePersonPreferences")
    @WebResult(name="hpId") 
    public int updatePersonPP(@WebParam(name="personId") int id, @WebParam(name="activitypreference") ActivityPreference hp);

    @WebMethod(operationName="savePersonPP")
    @WebResult(name="hpId") 
    public int savePersonPP(@WebParam(name="personId") int id, @WebParam(name="activitypreference") ActivityPreference hp);
    
    @WebMethod(operationName="readPersonPP")
    @WebResult(name="preferences")  
    public List<ActivityPreference> readPersonPP(@WebParam(name="personId") int id, @WebParam(name="activity") String activity);
    
    @WebMethod(operationName="readPersonPPID")
    @WebResult(name="preferences")  
    public List<ActivityPreference> readPersonPPID(@WebParam(name="personId") int id, @WebParam(name="activity_id") int activity_id);
    @WebMethod(operationName="readpreferences")
    @WebResult(name="preferences")  
    public List<ActivityPreference> readPreferences();
    
   
    
    
}