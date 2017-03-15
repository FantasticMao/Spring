package com.maomao.spring.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Manager {
    private Integer id;
    private Integer employeeId;
    private Integer departmentId;

    public Manager() {
    }

    @PostConstruct
    public void init() {
        System.out.println("Manager init ...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Manager destroy ...");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", departmentId=" + departmentId +
                '}';
    }
}
