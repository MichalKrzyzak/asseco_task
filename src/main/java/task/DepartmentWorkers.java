package task;

import dao.DBConnectorImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentWorkers {
    private final DBConnectorImpl DB_CONNECTOR = new DBConnectorImpl();

    public void executeTask(String departmentName) {
        try {
            Statement statement = DB_CONNECTOR.getConnection().createStatement();
            String query = "SELECT emp.last_name FROM employees emp JOIN job_history jh ON emp.employee_id = jh.employee_id JOIN departments dep ON emp.department_id = dep.department_id WHERE dep.department_name = '" + departmentName + "' AND jh.department_id = dep.department_id ORDER BY emp.last_name ASC";

            printResult(statement.executeQuery(query));

            DB_CONNECTOR.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printResult(ResultSet resultSet) throws SQLException {
        System.out.println("Last name");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("last_name"));
        }
    }
}
