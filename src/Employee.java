import java.math.BigDecimal;

public class Employee extends Person {
    Employee(String _name, String _birthDate, BigDecimal _salary, String _function) {
		setName(_name);
		setBirthDate(_birthDate);
		setSalary(_salary);
		setFunction(_function);
	}
	
	private BigDecimal salary;
	private String function;
	
	public void setSalary(BigDecimal value) {
	  salary = value;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	
	public String getFormatedSalary() {
		return Data.formatSalary(salary);
	}
	
	public void setFunction(String _function) {
	  function = _function;
	}
	
	public String getFunction() {
		return function;
	}
	
	public void applyIncrease(BigDecimal percentage) {
		setSalary(getSalary().multiply(percentage));
	}
	
	public void applyIncrease(String percentage) {
		setSalary(getSalary().multiply(new BigDecimal(percentage)));
	}
	
	public int countSalaryMin(BigDecimal min) {
      return getSalary().divideToIntegralValue(min).intValue();
    }
}
