package redoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private  String empName;
	private  String empLocation;
	private  String empEmail;
	private  Double salary;
	private   LocalDate createdAt;
	private  LocalDate updatedAt;

//	"empName":"user",
//	"empLocation":"hyd",
//	"empEmail":"user-1@gmail.com",
//	"salary":50000

}
