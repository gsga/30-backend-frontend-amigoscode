/*
 * Esta es la clase principal de la aplicación. 
 * Está tal como la genera la plataforma.
 */
package tup.employeemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
  * La documentación oficial está en 
  * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/SpringBootApplication.html
  * y en 
  * https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-using-springbootapplication-annotation.html
  * 
  * La anotación @SpringBootApplication es equivalente a 
  * usar @Configuration, @EnableAutoConfiguration y @ComponentScan 
  * con sus atributos predeterminados.
  */
@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

}
