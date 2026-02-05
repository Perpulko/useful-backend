package useful.pupshev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import useful.pupshev.client.CsvClient;
import useful.pupshev.service.CsvDownloaderService;
import static useful.pupshev.client.CsvClient.ULRCLASSIFICATORS;

@RestController
@RequestMapping("api/v1")
public class CsvAndXslxDownloader {
  private final CsvDownloaderService csvDownloaderService;
  private final CsvClient csvClient;

  public CsvAndXslxDownloader(CsvDownloaderService csvDownloaderService, CsvClient csvClient) {
    this.csvDownloaderService = csvDownloaderService;
    this.csvClient = csvClient;
  }

  @GetMapping("/classificators")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void setCsvDownloader() {
      try {
          csvDownloaderService.downloadCsv(ULRCLASSIFICATORS, csvClient.targetPath);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }
}
