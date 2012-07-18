import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Organizer { 
  EntryDir rootDir = new EntryDir("/");
  Map<String, Integer> lines = new HashMap<String, Integer>();
  Set<String> alreadyCreated = new HashSet<String>();
  Map<String, Entry> objects = new HashMap<String, Entry>();
  public Organizer(Map<String, Integer> lines) {
    createEntries(lines);
    fillEntries();
  }
  public Entry getRootDir() {
    return rootDir;
  }
  private void createEntries(Map<String, Integer> lines) {
    String tmpPath;
    int tmpSlashPosition;
    for (Map.Entry<String, Integer> entry : lines.entrySet()) {
      tmpPath = entry.getKey();
      createEntryIfPossible(tmpPath, entry.getValue());
      tmpSlashPosition = tmpPath.lastIndexOf('/');
      while (tmpSlashPosition != -1) {
        tmpPath = tmpPath.substring(0, tmpSlashPosition);
        createEntryIfPossible(tmpPath, entry.getValue());
        tmpSlashPosition = tmpPath.lastIndexOf('/');
      }
    }
  }
  private void createEntryIfPossible(String subPath, int tasksNumber) {
    if (subPath.length() > 0 && !objects.containsKey(subPath)) {
      Entry entry = Entry.create(subPath);
      if (entry.getClass().toString().endsWith("EntryFile")) {
        ((EntryFile) entry).setTasksNumber(tasksNumber);
      }
      objects.put(subPath, entry);
    }
  }
  private void fillEntries() {
    int lastSlashPosition;
    String pathWithoutLastPart;
    for(Map.Entry<String, Entry> entry : objects.entrySet()) {
      lastSlashPosition = entry.getKey().lastIndexOf('/');
      if (lastSlashPosition > 0) {
        pathWithoutLastPart = entry.getKey().substring(0, lastSlashPosition);
        addSubEntriesToPath(pathWithoutLastPart, entry.getValue());
      } else {
        rootDir.addSubEntry(entry.getValue());
      }
    }
  }
  private void addSubEntriesToPath(String path, Entry entry) {
    objects.get(path).addSubEntry(entry);
  }
}
