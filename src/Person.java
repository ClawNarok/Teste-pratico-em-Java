import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Person {
	private String name;
	private LocalDate birthDate;
	
	public void setName(String _name) {
		name = _name;
	}
	
	public String getName() {
		return name;
	}
		
	public void setBirthDate(LocalDate date) {
	  birthDate = date;
	}
	
	public void setBirthDate(String date) {
		LocalDate converted = LocalDate.parse(date);
		birthDate = converted;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public String getFormatedBirthDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formated = formatter.format(birthDate);
		return formated;
	}
	
	public int calculateAge() {
	  int age = Period.between(getBirthDate(), LocalDate.now()).getYears();
	  return age;
	}
	
	public void printNameAndAge() {
	    System.out.println("Nome: " + getName());
	    System.out.println("Idade: " + calculateAge());
	    Principal.line();
	}
}
