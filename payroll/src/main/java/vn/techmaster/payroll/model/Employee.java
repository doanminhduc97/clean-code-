package vn.techmaster.payroll.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Employee {
  private String name;
  private String dob;
  private String role;
  private String startdate;
  private int salary;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getRole() {
    return role;
  }

  /* From DOB, calculate age of employee
   */
  public float getAge() {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate birthDay = LocalDate.parse(this.dob, dateFormatter);
    return birthDay.until(LocalDate.now(), ChronoUnit.DAYS) / 365.2425f;    
  }
  /**
   * function showNumberYearAndMonthOfService() tính ra số năm và tháng làm việc của 1 nhân viên.
   */
 public void showNumberYearAndMonthOfService() {
  DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  LocalDate startdated = LocalDate.parse(this.startdate, dateFormatter);
  // tính số năm làm việc
  int yearOfService = (int) (startdated.until(LocalDate.now(), ChronoUnit.DAYS) / 365.2425f);
  // tính số tháng còn dư
  int monthOfService = (int) ((startdated.until(LocalDate.now(), ChronoUnit.DAYS) - (yearOfService * 365.2425f)) / 30);
  System.out.print(yearOfService + "năm, "+ monthOfService +" tháng");
 }
  /**
   * function getCurrentSalary() tính mức lương hiện tại của nhân viên.
   */
 public float getCurrentSalary() {
   float currentSalary = 0;
   int yearOfService = (int) (this.startdate.until(LocalDate.now(), ChronoUnit.DAYS) / 365.2425f);
   for (int i = 0; i < yearOfService; i++) {
    salaryIncrease = (float) (this.salary * 0.06);
    currentSalary += salaryIncrease;
  }
  return currentSalary;
 }
  public void setRole(String role) {
    this.role = role;
  }

  public String getStartdate() {
    return startdate;
  }

  public void setStartdate(String startdate) {
    this.startdate = startdate;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee [dob=" + dob + ", name=" + name + ", age in years = " + String.valueOf(this.getAge()) + ", year of service = "+ showNumberYearAndMonthOfService() + ", current salary = " + getCurrentSalary()"]";
  }
}
