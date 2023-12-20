import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private httpClient:HttpClient) { }

  getAllEmployees():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>('http://localhost:8080/emp/employees');
  }

  SaveNewEmployee(employee:Employee):Observable<Employee>{
    return this.httpClient.post<Employee>('http://localhost:8080/emp/save',employee);
  }

  getEmployeeById(id:number):Observable<Employee>{
    return this.httpClient.get<Employee>(`http://localhost:8080/emp/get/${id}`);
  }

  updateEmployee(id:number,employee:Employee):Observable<object>{
    return this.httpClient.put(`http://localhost:8080/emp/update/${id}`, employee);
  }

  deleteEmployeeById(id:number){
    return this.httpClient.delete(`http://localhost:8080/emp/delete/${id}`)
  }
}
