package tup.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Tutorial de Baeldung
 * https://www.baeldung.com/jpa-entities
 * Las entidades en JPA no son más que POJO 
 * (Plain Old Java Object)
 * que representan datos que se pueden guardar en la 
 * base de datos. Una entidad representa una tabla en una 
 * base de datos. Cada instancia de una entidad es una 
 * fila en la tabla.
 * 
 * https://stackoverflow.com/a/29333628/2740402
 * Al crear una nueva entidad hay que hacer al menos dos cosas:
 *   -  anotar la clase con @Entity
 *   -  crear un campo de identificación y anotarlo con @Id
 * Todo lo demás es opcional, por ejemplo, el nombre de la tabla 
 * se deriva del nombre de la clase de la entidad (y, por lo 
 * tanto, la anotación @Table puede ser opcional), las columnas 
 * de la tabla se derivan de las variables de las entidades 
 * (y, por lo tanto, la anotación @Column puede ser opcional), etc.
 * 
 * JPA trata de proporcionar un comienzo rápido y fácil para 
 * los desarrolladores que quieren aprender a usar esta API. 
 * Dar a los desarrolladores la opción de configurar la 
 * menor cantidad de cosas posible para hacer algo funcional 
 * es una de las formas en que esta API quiere lograr este 
 * aprendizaje. Por lo tanto, la anotación @Entity (junto con 
 * la anotación @Id) es lo mínimo que debe hacer para crear 
 * una entidad.
 * 
 * Tutorial de Thorben Janssen
 * https://thorben-janssen.com/key-jpa-hibernate-annotations/
 * Muy completo y claro.
 */
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imgUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    public Employee() {
    }

    public Employee(Long id, String name, String email, String jobTitle, String phone, String imgUrl,
            String employeeCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imgUrl = imgUrl;
        this.employeeCode = employeeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                "}";
    }

}
