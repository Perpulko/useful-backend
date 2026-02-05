package useful.pupshev.service;

import java.nio.file.Path;

public interface CsvDownloaderService {
  void downloadCsv(String url, Path targetPath) throws Exception;
}
