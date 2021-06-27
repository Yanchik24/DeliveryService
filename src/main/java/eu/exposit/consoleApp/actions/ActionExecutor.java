package eu.exposit.consoleApp.actions;

public class ActionExecutor {

    public static void execute(Action action) {
        try {
            action.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
