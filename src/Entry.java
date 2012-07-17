abstract class Entry {
  private String shortName;
  private String fullName;
  protected Integer tasksNumber = null;
  public String getShortName() { return shortName; }
  public String getFullName() { return fullName; }
  public int countTasks() {
    return (int) this.tasksNumber;
  }
  public void createEntriesFromPath(String path) {
    
  }
  abstract public void addSubEntry(Entry entry);
  abstract public Entry[] getSubEntries();
}
