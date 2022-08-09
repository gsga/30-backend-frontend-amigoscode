import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})


export class AppComponent implements OnInit {
  title = 'employeemanagerapp';

  public employees: Employee[] = [];

  /*
  Inyección de dependencia.
  Esta sintaxis del constructor es un modo de inyectar en la
  clase AppComponent la dependencia de la clase EmployeeService.
  Es decir que esta clase puede acceder a todos los servicios
  (o sea todos los métodos públicos) de la clase EmployeeService.
  */
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  /*
  https://angular.io/guide/observables#defining-observers

  Esta es la sintaxis recomendada en este momento,
  23 de julio de 2022. Lo que está deprecado NO es el
  subscribe() en sí mismo, sino la antigua sintaxis
  con uno o más parámetros posicionales, que podría
  ser confusa para el lector.

  A handler for receiving observable notifications implements 
  the Observer interface. It is an object that defines 
  callback methods to handle the three types of notifications 
  that an observable can send:
  
  NOTIFICATION DETAILS
  next         Required. A handler for each delivered value. 
               Called zero or more times after execution starts.
  error        Optional. A handler for an error notification. 
               An error halts execution of the observable instance.
  complete     Optional. A handler for the execution-complete 
               notification. Delayed values can continue to be 
               delivered to the next handler after execution is complete.
  
  An observer object can define any combination of these handlers. 
  If you don't supply a handler for a notification type,
  the observer ignores notifications of that type.
  */

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      {
        next: (v) => {
          console.log(v);
          this.employees = v;
        },
        error: (e) => { console.error(e.message) },
        complete: () => { console.info('complete') }
      }
    );
  }

}
