package team;

import java.util.ArrayList;

/**
 *
 * @author Rihards
 */
public class LoadAndSave 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {  
        Person persA = new Person ("Anton", 12,32,43,23);
        System.out.println("Person A printed: "+ persA.toString());
        String p1 = "Bob,12,32,43,43";
        String p2 = "Linda,12,36,43,73";
        String p3 = "Zebra,2,42,443,46";
        String p4 = "Janis,45,58,47,58";
        
        ArrayList<String> personList = new ArrayList<String>(); // Making a new arraylist
        //Adding people strings:
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(persA.toString() );
        personList.add(p4);
        
        FileHandlerStat.savePersons(personList, "people.txt");
        
        /////LOAD:
        ArrayList<Person> listOfPeople = new ArrayList<Person>();
        
        ArrayList<String> fromTheDeadList = new ArrayList<String>();
        fromTheDeadList = FileHandlerStat.load("persons.txt");
        if(fromTheDeadList == null){
            System.out.println("Something went wrong!...load returned null");
        }
        else{// there is something there...
           
            for (String peopleString : fromTheDeadList) {
                //Go from a string to a person object:  
                //peopleString IS a string of 1 person - > Person object
                Person tempPerson = new Person( peopleString );
                listOfPeople.add( tempPerson  );
            }
        }
        /////////////See my arraylist of Person objects:
        System.out.println("-------- NOW PRINTING MY PERSON OBEJCTS:");
        for (Person onePerson : listOfPeople) {
            System.out.println("Person: " + onePerson.toString() );
    }
    
    }
}