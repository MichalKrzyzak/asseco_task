import task.DepWorkerDetails;
import task.DepartmentWorkers;
import task.WorkerDetails;
import util.Constant;

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
                System.out.println(Constant.ENTER_DEP_NAME);
                runTask(1);
                break;
            case "2":
                System.out.println(Constant.ENTER_WORKER_LAST_NAME);
                runTask(2);
                break;
            case "3":
                System.out.println(Constant.ENTER_DEP_NAME);
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
            System.out.println(Constant.MAX_PERCENTAGE_DIFF);
            WORKER_DETAILS.executeTask(s, new BigDecimal(SCANNER.nextLine()));
        } else if (taskNumber == 3) {
            System.out.println(Constant.ENTER_WORKER_LAST_NAME);
            String lastName = SCANNER.nextLine();
            System.out.println(Constant.MAX_PERCENTAGE_DIFF);
            DEP_WORKERS_DETAILS.executeTask(s, lastName, new BigDecimal(SCANNER.nextLine()));
        }
    }
}
