abstract class Entry {
  private String shortName;
  private String fullName;
  protected Integer tasksNumber = null;
  abstract public void addSubEntry(Entry entry);
  abstract public Entry[] getSubEntries();
  public String getShortName() { return shortName; }
  public String getFullName() { return fullName; }
  public int countTasks() {
    return (int) this.tasksNumber;
  }
}
