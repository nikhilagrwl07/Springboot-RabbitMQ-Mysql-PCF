package com.example.cftest.cftest;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = EmployeeMessage.class)
public class EmployeeMessage {
    private String empName;
    private String empId;

    public EmployeeMessage(String empId, String empName) {
        this.empId=empId;
        this.empName=empName;
    }

    public EmployeeMessage() {
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "EmployeeMessage{" +
                "empName='" + empName + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}
