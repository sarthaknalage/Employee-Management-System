import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { Employee } from '../employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  constructor(private api:ServiceService , private router:Router) { }

  employee:Employee[]=[];

  ngOnInit(): void {
  this.getEmployees();
  }

  getEmployees(){
    this.api.getAllEmployees().subscribe(data=>{
      this.employee=data;
    })
  }

  updateEmployee(id:number){
    this.router.navigate(['update',id]);
  }

  deleteEmployee(id:number){
    this.api.deleteEmployeeById(id).subscribe(data=>{
      console.log(data);
      this.getEmployees();
    })
  }
}
