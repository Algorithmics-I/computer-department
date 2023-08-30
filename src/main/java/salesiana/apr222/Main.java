package salesiana.apr222;
import salesiana.apr222.Files.DuplicateFileFinder;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    DuplicateFileFinder duplicateFileFinder = new DuplicateFileFinder();
    duplicateFileFinder.processData();
  }


}
