package com.mindex.challenge.data;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Compensation {
    private String employeeId;
    private String salary;
    private Date effectiveDate;

    public Compensation() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSalary() {
    	return salary;
    }
    
    public void setSalary(String salary) {
    	this.salary = salary;
    }
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getEffectiveDate() {
    	return effectiveDate;
    }
    
    public void setEffectiveDate(Date effectiveDate) {
    	this.effectiveDate = effectiveDate;
    }
}
