package task;

import dao.DBConnectorImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkerDetails {
    private final DBConnectorImpl DB_CONNECTOR = new DBConnectorImpl();

    public void executeTask(String lastName, BigDecimal givenPercentage) {
        try {
            Statement statement = DB_CONNECTOR.getConnection().createStatement();
            String query = "SELECT dep.department_name, emp.salary, job.max_salary FROM employees emp JOIN job_history jb ON emp.employee_id = jh.employee_id  JOIN job ON jh.job_id = job.job_id JOIN departments dep ON jh.department_id = dep.department_id WHERE emp.last_name  = '" + lastName + "' ORDER BY dep.department_name ASC";

            printResult(statement.executeQuery(query), givenPercentage);

            DB_CONNECTOR.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printResult(ResultSet resultSet, BigDecimal givenPercentage) throws SQLException {
        System.out.println("Department name   Is salary lower then " + givenPercentage);

        while (resultSet.next()) {
            String department_name = resultSet.getString("department_name");
            BigDecimal salary = resultSet.getBigDecimal("salary");
            boolean isLower = isLower(givenPercentage, calculateSalaryDifference(salary, resultSet.getBigDecimal("max_salary")));

            System.out.println(department_name + "  " + isLower);
        }
    }

    private BigDecimal calculateSalaryDifference(BigDecimal salary, BigDecimal max_salary) {
        return salary.multiply(max_salary).divide(new BigDecimal(100), RoundingMode.HALF_UP);
    }

    private boolean isLower(BigDecimal givenPercentage, BigDecimal percentageDiff) {
        return givenPercentage.compareTo(percentageDiff) > 0;
    }
}
