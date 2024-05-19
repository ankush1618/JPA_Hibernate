package com.ps.training.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements InitializingBean,DisposableBean {

	@Autowired
	private Employee employee;
	
    public Employee getEmployee() {
    	return employee;
    }
    
    public void setEmployee(Employee employee) {
    	this.employee=employee;
    }
	
    public EmployeeService() {
    	System.out.println("EmployeeService no-args constructor called");
    }
    
    @Override
	public void destroy() throws Exception {
    	System.out.println("Employee Service clossign resources");
   
	}
    
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Employee Service initializing to Dummy Value");
		if(employee.getName()==null) {
			employee.setName("Ankush");
		}
	}
	
	

}
