class EntryFile extends Entry {
  public void addSubEntry(Entry entry) {
  }
  public Entry[] getSubEntries() {
    return new EntryFile[0];
  }
  public int countTasks() {
    return (int) this.tasksNumber;
  }
  public void setTasksNumber(int tasksNumber) throws RuntimeException {
    if (null != this.tasksNumber) {
      throw new RuntimeException("file tasks number cannot be set twice");
    }
    this.tasksNumber = new Integer(tasksNumber);
  }
}
