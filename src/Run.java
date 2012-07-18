import java.io.IOException;

public class Run {
  FR fr = new FR();
  Organizer organizer;
  public static void main(String[] args) {
    System.out.println("Run");
    Run run = new Run();
    if (args.length == 1) {
      run.process(args[0]);
    } else {
      run.process(System.getProperty("user.dir") + "/stats.txt");
    }
  }
  private void process(String statsfile) {
    try {
      organizer = new Organizer(fr.read(statsfile).getLines());
    } catch (IOException e) {
      System.out.println("Blad przetwarzania pliku");
    }
    Displayer displayer = new Displayer(organizer.getRootDir());
    displayer.printTxtStructure();
  }
}
