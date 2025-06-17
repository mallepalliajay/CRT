);import java.sql.*;
import java.time.LocalDate;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // change 'xe' to your DB name if different
        String user = "your_username"; // e.g., system or hr
        String pass = "your_password"; // your DB password

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, user, pass);

            // Insert into DEPT
            PreparedStatement deptStmt = con.prepareStatement(
                "INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (?, ?, ?)");
            deptStmt.setInt(1, 10);
            deptStmt.setString(2, "ACCOUNTING");
            deptStmt.setString(3, "NEW YORK");
            deptStmt.executeUpdate();

            // Insert into EMP
            PreparedStatement empStmt = con.prepareStatement(
                "INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            empStmt.setInt(1, 1001);
            empStmt.setString(2, "SMITH");
            empStmt.setString(3, "CLERK");
            empStmt.setInt(4, 7839);
            empStmt.setDate(5, Date.valueOf(LocalDate.of(2024, 5, 20)));
            empStmt.setDouble(6, 2500.00);
            empStmt.setDouble(7, 300.00);
            empStmt.setInt(8, 10);
            empStmt.executeUpdate();

            // Insert into BONUS
            PreparedStatement bonusStmt = con.prepareStatement(
                "INSERT INTO BONUS (ENAME, JOB, SAL, COMM) VALUES (?, ?, ?, ?)");
            bonusStmt.setString(1, "ALLEN");
            bonusStmt.setString(2, "SALESMAN");
            bonusStmt.setDouble(3, 1600);
            bonusStmt.setDouble(4, 500);
            bonusStmt.executeUpdate();

            // Insert into SALGRADE
            PreparedStatement salStmt = con.prepareStatement(
                "INSERT INTO SALGRADE (GRADE, LOSAL, HISAL) VALUES (?, ?, ?)");
            salStmt.setInt(1, 1);
            salStmt.setInt(2, 1000);
            salStmt.setInt(3, 2000);
            salStmt.executeUpdate();

            System.out.println("✅ Data inserted successfully into all tables.");
            con.close();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}