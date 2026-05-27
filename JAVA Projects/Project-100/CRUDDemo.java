import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;
import java.util.Iterator;

class Employee {
    private int empno;
    private String ename;
    private int salary;

    Employee(int empno, String ename, int salary) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    public int getEmpno() {
        return empno;
    }

    public int getSalary() {
        return salary;
    }

    public String getEname() {
        return ename;
    }

    public String toString() {
        return empno + " " + ename + " " + salary;
    }
}

public class CRUDDemo {
    public static void main(String[] args) {
        Collection<Employee> emplo = new ArrayList<Employee>();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1. INSERT");
            System.out.println("2. DISPLAY");
            System.out.println("3. SEARCH");
            System.out.println("4. DELETE");
            System.out.println("5. UPDATE");
            System.out.println("Enter Your Choice : ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Empno : ");
                    int eno = sc.nextInt();
                    System.out.print("Enter EmpName : ");
                    String ename = sc2.nextLine();
                    System.out.print("Enter Salary : ");
                    int salary = sc.nextInt();
                    emplo.add(new Employee(eno, ename, salary));
                    System.out.println("=============================");
                    System.out.println("Employee Added!");
                    break;

                case 2:
                    System.out.println("=============================");
                    Iterator<Employee> i = emplo.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("=============================");
                    break;

                case 0:
                    System.out.println("Program Ended");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        } while (ch != 0);

        sc.close();
        sc2.close();
    }
}