package com.mindex.challenge.controller;

import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;

@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/repstructure/{id}")
    public ReportingStructure read(@PathVariable String id) {
        LOG.debug("Received Reporting Structure request for employee id [{}]", id);
        Employee e = employeeService.read(id);
        return new ReportingStructure(e, countAllReports(e));
    }
    
    private int countAllReports(Employee e) {
    	HashSet<String> reportIDs = new HashSet<String>();
    	addReportIDs(reportIDs, e);
    	return reportIDs.size();
    }
    
    private void addReportIDs(HashSet<String> reportIDs, Employee e) {
		// get reports and call recursively
		List<Employee> reports = e.getDirectReports();
		if(reports != null) {
			LOG.debug(" Employee "+e.getEmployeeId()+" has "+reports.size()+ "reports");
			for(Employee r: reports) {
				if (! reportIDs.contains(r.getEmployeeId())) {
					reportIDs.add(r.getEmployeeId());					
					Employee fullRecord = employeeService.read(r.getEmployeeId());
					LOG.debug(" recursing on employee "+fullRecord.getEmployeeId());
					addReportIDs(reportIDs, fullRecord);
				}
			}
		}
    }
} 
