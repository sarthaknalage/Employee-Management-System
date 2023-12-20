import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-new-employee',
  templateUrl: './new-employee.component.html',
  styleUrls: ['./new-employee.component.css']
})
export class NewEmployeeComponent implements OnInit {

  constructor(private api:ServiceService) { }

  employee:Employee = new Employee();

  ngOnInit(): void {
    this.addNewEmployee;
  }

  addNewEmployee(employee:Employee){
    this.api.SaveNewEmployee(this.employee).subscribe(data=>{
      this.employee=data;
    })
  }
    
  addEmployee(){
    console.log(this.employee);
  }
}
