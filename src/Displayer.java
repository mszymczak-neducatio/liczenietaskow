/**
 *
 * @author maikeru
 */
class Displayer {
  Entry rootDir;
  public Displayer(Entry rootDir) {
    this.rootDir = rootDir;
  }
  public void printTxtStructure() {
    for (Entry entry : rootDir.getSubEntries()) {
      System.out.println(entry);
      for(Entry subentry : entry.getSubEntries()) {
        System.out.println("\t" + subentry);
        for(Entry subsubentry : subentry.getSubEntries()) {
          System.out.println("\t\t" + subsubentry);
          for(Entry subsubsubentry : subsubentry.getSubEntries()) {
            System.out.println("\t\t\t" + subsubsubentry);
            for(Entry subsubsubsubentry : subsubsubentry.getSubEntries()) {
              System.out.println("\t\t\t\t" + subsubsubsubentry);
            }
          }
        }
      }
    }
  }
}
