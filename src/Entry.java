
import java.util.ArrayList;
import java.util.TreeSet;

abstract class Entry implements Comparable {
  private String shortName;
  private String fullPath;
  private TreeSet<Entry> subentries = new TreeSet<Entry>();
  protected Integer tasksNumber = null;
  public String getShortName() { return shortName; }
  public String getFullPath() { return fullPath; }
  @Override
  public String toString() { return getShortName() + "(" + countTasks() +  " tasks)"; }
  @Override
  public int compareTo(Object entry) {
    Entry entryToCompare = (Entry) entry;
    return fullPath.compareToIgnoreCase(entryToCompare.getFullPath());
  }
  public static Entry create(String path) {
    if (path.endsWith(".xml")) {
      return new EntryFile(path);
    } else {
      return new EntryDir(path);
    }
  }
  public Entry(String path) {
    this.fullPath = path;
    int lastSlashPosition = path.lastIndexOf('/');
    if (lastSlashPosition == -1) {
      this.shortName = path;
    } else {
      this.shortName = path.substring(lastSlashPosition + 1);
    }
  }
  public int countTasks() {
    int tasksInSubEntriesNumber = 0;
    for (Entry subentry : getSubEntries()) {
      tasksInSubEntriesNumber += subentry.countTasks();
    }
    if (this.tasksNumber == null) {
      return tasksInSubEntriesNumber;
    }
    return (int) this.tasksNumber + tasksInSubEntriesNumber;
  }
  public void createEntriesFromPath(String path) {
    
  }
  public TreeSet<Entry> getSubEntries() { return subentries; }
  public void addSubEntry(Entry entry) {
    subentries.add(entry);
  }
}
