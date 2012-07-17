import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
class FR { 
  Map<String, Integer> lines = new HashMap<String, Integer>();
  public static void main(String[] args) {
    FR fr = new FR();
    try {
    fr.read(System.getProperty("user.dir") + "/" + "abc.txt");
    } catch (IOException e) {
      System.out.println("Blad przetwarzania pliku");
    }
    System.out.print(fr.getLines());
  }
  public FR read(String filename) throws IOException {
    BufferedReader br = null;
    String sCurrentLine;
    br = new BufferedReader(new FileReader(filename));
    while ((sCurrentLine = br.readLine()) != null) {
        String[] splitLine = (sCurrentLine.split("\\t+"));
        if (splitLine.length == 2) {
          lines.put(splitLine[0], Integer.parseInt(splitLine[1]));
          //System.out.println(sCurrentLine);
        }
    }
    if (br != null)br.close();
    return this;
  }
  public Map getLines() {
    return lines;
  }
}
