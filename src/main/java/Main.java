import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final TaskPicker TASK_PICKER = new TaskPicker(SCANNER);

    public static void main(String[] args) {
        String taskToDo;

        do {
            System.out.println("Please enter number of activity you want to perform:\n" +
                    "1 - verify current and former employees of given department\n" +
                    "2 - show in which departments given employee was working\n" +
                    "Enter \"exit\" to terminate program.");

            taskToDo = SCANNER.nextLine().toLowerCase();
            TASK_PICKER.pickTask(taskToDo);
        } while (!taskToDo.equalsIgnoreCase("exit"));
    }
}
