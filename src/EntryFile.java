class EntryFile extends Entry {
  public EntryFile(String path) {
    super(path);
  }
  public void setTasksNumber(int tasksNumber) throws RuntimeException {
    if (null != this.tasksNumber) {
      throw new RuntimeException("file tasks number cannot be set twice");
    }
    this.tasksNumber = new Integer(tasksNumber);
  }
}
