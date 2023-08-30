package salesiana.apr222;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String path = scanner.nextLine();
    String termination = scanner.nextLine();

    File folder = new File(path);

    if (folder.isDirectory()) {
      Map<String, List<String>> fileMap = new HashMap<>();
      Set<String> uniqueFiles = new HashSet<>();
      Set<String> duplicatedFiles = new HashSet<>();

      File[] files = folder.listFiles(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
          return name.toLowerCase().endsWith(termination);
        }
      });

      for (File file : files) {
        try {
          String hash = getFileHash(file.toPath());
          if (fileMap.containsKey(hash)) {
            duplicatedFiles.add(fileMap.get(hash).get(0));
            duplicatedFiles.add(file.getAbsolutePath());
          } else {
            fileMap.computeIfAbsent(hash, k -> new ArrayList<>()).add(file.getAbsolutePath());
            uniqueFiles.add(file.getAbsolutePath());
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      System.out.println("Files scanned: " + files.length);
      System.out.println("Unique files: " + uniqueFiles.size());
      System.out.println("Potentially duplicated files: " + duplicatedFiles.size());

      System.out.println("List of duplicated files:");
      for (String file : duplicatedFiles) {
        System.out.println(file);
      }
    } else {
      System.out.println("Invalid path.");
    }
    scanner.close();
  }

  private static String getFileHash(Path path) throws IOException {
    byte[] data = Files.readAllBytes(path);
    return Arrays.toString(data);
  }
}
