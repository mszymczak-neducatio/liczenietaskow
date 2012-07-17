import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Organizer { 
  EntryDir rootDir = new EntryDir();
  Map<String, Integer> lines = new HashMap<String, Integer>();
  Set<String> alreadyCreated = new HashSet<String>();
  Map<String, Integer> objects = new HashMap<String, Integer>();
  public Organizer(Map lines) {
    this.lines = lines;
  }
  private void createEntryIfNotExists(String path) {
    if (!alreadyCreated.contains(path)) {
      lines.clear();
    }
  }
}
