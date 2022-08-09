import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeService } from './employee.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    /* Si no lo importo me da en runtime
    el error NullInjectorError: No provider for HttpClient! */
    HttpClientModule,
    AppRoutingModule
  ],
  /* providers es el array de los proveedores de servicios,
  a los cuales llamamos simplemente servicios por brevedad.
  */
  // providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
