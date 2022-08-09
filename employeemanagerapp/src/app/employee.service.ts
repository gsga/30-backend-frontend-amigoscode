/*
Todo servicio en Angular está anotado con el decorador @Injectable,
porque este es un modo de que los consumidores puedan consumir
el servicio, a través de la inyección de dependencia. 
Para que el frontend en Angular pueda comunicarse con el backend
(en este caso en Spring Boot, pero podría ser distinto) usando
el protocolo HTTP necesita usar las funcionalidades de HttpClient.
Un modo de lograr esto es mediante el sistema
de inyección de dependencias (DI) a través del constructor.
*/
import { Injectable } from "@angular/core";
/*
Para poder usar acá HttpClient, necesito importar y declarar
HttpClientModule en app.module.ts.
Si no lo hago, el compilador compila, pero en runtime la consola
del browser da un error provider not found, null injector.
*/
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";

import { environment } from "src/environments/environment";
import { Employee } from "./employee";

/*
https://angular.io/api/core/Injectable
The @Injectable() decorator marks a class as available 
to be provided and injected as a dependency.
{providedIn: 'root'} means that the 
service is visible throughout the application.

Notar que la anotación es requerida para que ESTA clase
pueda ser inyectada como dependencia en otras clases.
El decorador NO se necesita para que OTRAS clases puedan
ser inyectadas como dependencias en esta clase. Esas otras
clases, por su parte, sí necesitan estar marcadas como @Injectable.
*/
@Injectable({ providedIn: 'root' })

export class EmployeeService {

    private apiServerUrl = environment.apiBaseUrl;

    /*
    https://angular.io/guide/http
    Most front-end applications need to communicate with a server 
    over the HTTP protocol, to download or upload data and access 
    other back-end services. Angular provides a client HTTP API 
    for Angular applications, the HttpClient service 
    class in @angular/common/http.
    The HTTP client service offers the following major features:
      -  The ability to request typed response objects
      -  Streamlined error handling
      -  Testability features
      -  Request and response interception
    */
    constructor(private http: HttpClient) { }

    /*
    https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Template_literals
    Template literals are literals delimited with backtick (`) characters, 
    allowing for multi-line strings, for string interpolation with embedded 
    expressions, and for special constructs called tagged templates.
    La sintaxis es ${variable_name} 
    */
    public getEmployees(): Observable<Employee[]> {
        return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`);
    }

    public addEmployee(employee: Employee): Observable<Employee> {
        return this.http.post<Employee>(`${this.apiServerUrl}/employee/add`, employee);
    }

    public updateEmployee(employee: Employee): Observable<Employee> {
        return this.http.put<Employee>(`${this.apiServerUrl}/employee/update`, employee);
    }

    public deleteEmployee(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/employee/delete/${id}`);
    }

}