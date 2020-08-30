import task.DepWorkerDetails;
import task.DepartmentWorkers;
import task.WorkerDetails;

import java.math.BigDecimal;
import java.util.Scanner;

public class TaskPicker implements TaskExecutor {
    private final DepartmentWorkers DEPARTMENT_WORKERS = new DepartmentWorkers();
    private final WorkerDetails WORKER_DETAILS = new WorkerDetails();
    private final DepWorkerDetails DEP_WORKERS_DETAILS = new DepWorkerDetails();
    private final Scanner SCANNER;

    public TaskPicker(Scanner scanner) {
        this.SCANNER = scanner;
    }

    public void pickTask(String task) {
        switch (task) {
            case "1":
                System.out.println("Please enter department name:");
                runTask(1);
                break;
            case "2":
                System.out.println("Please enter worker last name");
                runTask(2);
                break;
            case "3":
                System.out.println("Please enter department name:");
                runTask(3);
                break;
            case "exit":
                System.out.println("Terminating...");
                break;
            default:
                System.out.println("Unsupported operation. Please try again.\n");
        }
    }

    private void runTask(int taskNumber) {
        executeTask(taskNumber, SCANNER.nextLine());
    }

    @Override
    public void executeTask(int taskNumber, String s) {
        if (taskNumber == 1) {
            DEPARTMENT_WORKERS.executeTask(s);
        } else if (taskNumber == 2) {
            System.out.println("Please provide maxumim salary difference as percentage");
            WORKER_DETAILS.executeTask(s, new BigDecimal(SCANNER.nextLine()));
        } else if (taskNumber == 3) {
            System.out.println("Please enter worker last name");
            String lastName = SCANNER.nextLine();
            System.out.println("Please provide maxumim salary difference as percentage");
            DEP_WORKERS_DETAILS.executeTask(s, lastName, new BigDecimal(SCANNER.nextLine()));
        }
    }
}
