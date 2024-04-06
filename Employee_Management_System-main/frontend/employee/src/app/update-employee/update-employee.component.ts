import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { Employee } from '../employee';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  employee:Employee = new Employee();

  constructor(private api:ServiceService , private route:ActivatedRoute,
    private router:Router) { }

   id:number=0;
  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    
    this.api.getEmployeeById(this.id).subscribe(data=>{
      this.employee = data;
    }, error=> console.log(error));
  }

  update(){
    this.api.updateEmployee(this.id,this.employee).subscribe(data=>{
        console.log("Record Updated "+data);
       this.redirectToEmployeeList();
    },error=>console.log(error));
  }

  redirectToEmployeeList(){
     this.router.navigate(['employees']);
  }
}
