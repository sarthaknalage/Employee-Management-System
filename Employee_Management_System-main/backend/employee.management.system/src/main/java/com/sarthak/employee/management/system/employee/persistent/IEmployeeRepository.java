package com.sarthak.employee.management.system.employee.persistent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sarthak.employee.management.system.model.Employee;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
//	adding some custom methods , In case no worry about their implementation body it will provided by data JPA
	@Query(value = "update Employee e SET e.employeeID=:id, e.employeeFName=:fName, e.employeeLName=:lName, e.employeeEmail=:mail where e.employeeID=:id1",nativeQuery = false)
	@Modifying(flushAutomatically = true)
	@Transactional(value = TxType.REQUIRED)
	public Integer updatedRecord(Integer id,String fName, String lName,String mail,Integer id1);// Named parameters
}
