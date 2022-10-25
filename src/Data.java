import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Data {
	private static String[] names = new String[] {
			"Maria",
			"João",
			"Caio",
			"Miguel",
			"Alice",
			"Heitor",
			"Arthur",
			"Laura",
			"Heloísa",
			"Helena",
			};
	
	private static String[] birthDates = new String[] {
			"2000-10-18",
			"1990-05-12",
			"1961-05-02",
			"1988-10-14",
			"1995-01-05",
			"1999-11-19",
			"1993-03-31",
			"1994-07-08",
			"2003-05-24",
			"1996-09-02",
			};
	
	private static String[] salaries = new String[] {
		"2009.44",
		"2284.38",
		"9836.14",
		"19119.88",
		"2234.68",
		"1582.72",
		"4071.84",
		"3017.45",
		"1606.85",
		"2799.93",
	};

	private static String[] functions = new String[] {
		"Operador",
		"Operador",
		"Coordenador",
		"Diretor",
		"Recepcionista",
		"Operador",
		"Contador",
		"Gerente",
		"Eletricista",
		"Gerente",
	};
	
	public static String formatSalary(BigDecimal decimal) {
		DecimalFormat df = new DecimalFormat("###,###,###.00");
		return df.format(decimal);
	}
	
	public static void insertData() {
		for (int x = 0; x < names.length; x++) {
			String name = names[x];
			String birthDate = birthDates[x];
			BigDecimal salary = new BigDecimal(salaries[x]);
			String function = functions[x];
			Employee newEmployee = new Employee(name, birthDate, salary, function);
			Principal.employees.add(newEmployee);
		}
	}
}
