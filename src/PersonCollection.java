import java.util.ArrayList;

public class PersonCollection 
{
	private static PersonCollection _instance = null;

	public static PersonCollection instance() {
		if(_instance == null) {
			_instance = new PersonCollection(); 
		}
		return(_instance);
	}

	ArrayList<Person> persons;

	public PersonCollection() {
		persons = new ArrayList<Person>();
	}

	public void addPerson(Person person) {
		persons.add(person);
	}

	public void removePerson(Person person) {
		persons.remove(person);
	}

	public ArrayList<Person> getAllPersons() {
		return(persons);
	}

	public Person getPersonByIndex(int i) {
		return(persons.get(i));
	}

	public int getPersonCount() {
		return(persons.size());
	}

	public ArrayList<Person> search(String s) {
		Person p = null;
		ArrayList<Person> pc = new ArrayList<Person>();
		String str = s.toLowerCase();
		for(int i=0; i<getPersonCount(); i++) {
			p = getPersonByIndex(i);
			if(matches(p, str)) {
				pc.add(p);
			}
		}
		return(pc);
	}

	public boolean matches(Person p, String str) {
		String fname = p.getFirstName().toLowerCase();
		String lname = p.getLastName().toLowerCase();
		String fullName = fname + lname;
		if(fullName.contains(str)) {
			return(true);
		}
		return(false);
	}
}
