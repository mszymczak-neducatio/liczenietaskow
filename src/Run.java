import java.io.IOException;

public class Run {
  FR fr = new FR();
  Organizer organizer;
  public static void main(String[] args) {
    System.out.println("Run");
    Run run = new Run();
    run.process("/tmp/abc.txt");
  }
  private void process(String statsfile) {
    try {
      organizer = new Organizer(fr.read(statsfile).getLines());
    } catch (IOException e) {
      System.out.println("Blad przetwarzania pliku");
    }
  }
}
