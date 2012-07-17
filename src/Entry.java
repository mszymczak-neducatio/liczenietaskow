abstract class Entry {
  private String shortName;
  private String fullPath;
  private Entry[] subentries;
  protected Integer tasksNumber = null;
  public String getShortName() { return shortName; }
  public String getFullPath() { return fullPath; }
  public String toString() { return getShortName() + "(" + getFullPath() + " - " + countTasks() +  " tasks)"; }
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
    if (this.tasksNumber == null) {
      return 0;
    }
    return (int) this.tasksNumber;
  }
  public void createEntriesFromPath(String path) {
    
  }
  public Entry[] getSubEntries() { return subentries; }
}
