package factory.gui;

public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    private static void configure() {
        System.out.println(System.getProperty("os.name"));
        if (System.getProperty("os.name").equals("HTML"))
            dialog = new HtmlDialog();
        else
            dialog = new WindowsDialog();
    }

    private static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
