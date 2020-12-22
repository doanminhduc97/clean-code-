# Hướng dẫn cách chạy
1. Biên dịch rồi truy cập vào http://localhost:8080
```
Employee [dob=1975-11-27, name=Trịnh Minh Cường, age in years = 45.055]
Employee [dob=1972-10-15, name=Nguyễn Văn X, age in years = 48.17074]
Employee [dob=1999-01-05, name=Đoàn Văn Y, age in years = 21.947063]
Employee [dob=1995-02-18, name=Nguyễn Thị A, age in years = 25.826677]
Employee [dob=1990-03-17, name=Đoàn Văn B, age in years = 30.752172]
Employee [dob=1994-02-16, name=Bùi Thị C, age in years = 26.83149]
```
2. Cách tính số năm khoảng cách giữa 2 thời điểm như sau
```java
public float getAge() {
    DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate birthDay = LocalDate.parse(this.dob, DATEFORMATTER);
    return birthDay.until(LocalDate.now(), ChronoUnit.DAYS) / 365.2425f;    
}
```
3. Cách tính số năm tháng làm việc của 1 nhân viên như sau: 
```java
public void showNumberYearAndMonthOfService() {
  DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  LocalDate startdated = LocalDate.parse(this.startdate, dateFormatter);
  // tính số năm làm việc
  int yearOfService = (int) (startdated.until(LocalDate.now(), ChronoUnit.DAYS) / 365.2425f);
  // tính số tháng còn dư
  int monthOfService = (int) ((startdated.until(LocalDate.now(), ChronoUnit.DAYS) - (yearOfService * 365.2425f)) / 30);
  System.out.print(yearOfService + "năm, "+ monthOfService +" tháng");
 }
```
4. Cách tính mức lương hiện tại của nhân viên.
```java
public float getCurrentSalary() {
   float currentSalary = 0;
   int yearOfService = (int) (this.startdate.until(LocalDate.now(), ChronoUnit.DAYS) / 365.2425f);
   for (int i = 0; i < yearOfService; i++) {
    salaryIncrease = (float) (this.salary * 0.06);
    currentSalary += salaryIncrease;
  }
  return currentSalary;
 }
```