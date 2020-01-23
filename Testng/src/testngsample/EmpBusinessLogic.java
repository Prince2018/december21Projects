package testngsample;
public class EmpBusinessLogic {
	   public double calculateYearlySalary(EmployeeDetails employeeDetails) // Calculate the yearly salary of employee
	   {double yearlySalary = 0; yearlySalary = employeeDetails.getMonthlySalary() * 12;return yearlySalary;}
	   
	   public double calculateAppraisal(EmployeeDetails employeeDetails) // Calculate the appraisal amount of employee
	   {  double appraisal = 0;   
	      if(employeeDetails.getMonthlySalary() < 10000) {
	         appraisal = 500;         
	      } else {
	         appraisal = 1000;
	      } return appraisal;   
	   }
	}