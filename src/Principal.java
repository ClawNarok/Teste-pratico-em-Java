import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Principal {
	static EmployeeNameComparator nameComparator = new EmployeeNameComparator();
	static EmployeeBirthDateComparator dateComparator = new EmployeeBirthDateComparator();
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public static Map<String, ArrayList<String>> employeesFunction = new HashMap<String, ArrayList<String>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    //3.1
		Data.insertData();
		//3.2
		employees.remove(findByName("João"));
		//3.3
		listAll(employees);
		//3.4
		applyIncrease();
		//3.5
		mapEmployees();
		//3.6
		listMapFunction();
		//3.8
		listBirthdayMonth(10);
		listBirthdayMonth(12);
		//3.9
		ArrayList<Employee> dataSorted = new ArrayList<Employee>(employees);
		dataSorted.sort(dateComparator);
		dataSorted.get(0).printNameAndAge();
		//3.10
		ArrayList<Employee> nameSorted = new ArrayList<Employee>(employees);
		nameSorted.sort(nameComparator);
		listAll(nameSorted);
		//3.11
		sumSalaries();
		//3.12
		listMinSalaries("1212");
	}
	
	private static Employee findByName(String name) {
		for (Employee employee : employees) {
			if (employee.getName() == name) {
				return employee;
			}
		}
		return null;
	}
	
	public static void line() {
		System.out.println("------------------------------------------------");
	}
	
	private static void printEmployee(Employee e) {
		System.out.println(String.format("Nome: %s", e.getName()));
		System.out.println(String.format("Data de nascimento: %s", e.getFormatedBirthDate()));
		System.out.println(String.format("Salário: : %s", e.getFormatedSalary()));
		System.out.println(String.format("Função: %s", e.getFunction()));
	}
	
	private static void listAll(ArrayList<Employee> list) {
		line();
		for (Employee e : list) {
		    printEmployee(e);
			line();
		}
	}
	
	private static void applyIncrease() {
		for (int x = 0; x < employees.size(); x++) {
		    Employee e = employees.get(x);
			e.applyIncrease("1.1");
		}
	}

	private static void mapEmployees() {
		for (Employee e : employees) {
			String function = e.getFunction();
			String name = e.getName();
			if (employeesFunction.containsKey(function)) {
				ArrayList<String> list = employeesFunction.get(function);
				list.add(name);
				employeesFunction.put(function, list);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(name);
				employeesFunction.put(function, list);
			}
		}
	}

	private static void listMapFunction() {
		line();
		for (Map.Entry<String, ArrayList<String>> entry : employeesFunction.entrySet()) {
			String funcao = entry.getKey();
			ArrayList<String> names = entry.getValue();
			System.out.print(funcao + ": ");
			System.out.println(names);
			line();
		}
	}

	private static void listBirthdayMonth(int month) {
		line();
		for (Employee e : employees) {
			if (e.getBirthDate().getMonthValue() == month) {
			    printEmployee(e);
				line();
			}
		}
	}

	private static void sumSalaries() {
	  line();
	  BigDecimal total = BigDecimal.ZERO;
	  for (Employee e: employees) {
        total = total.add(e.getSalary());
      }
	  System.out.println(Data.formatSalary(total));
	}

	private static void listMinSalaries(String value) {
	  line();
	  for (Employee e : employees) {
	    System.out.println("Nome: " + e.getName());
	    System.out.println("Quantidade de salário mínimo: " + e.countSalaryMin(new BigDecimal(value)));
	    line();
      }
	}
}
