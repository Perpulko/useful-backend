package useful.pupshev.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import useful.pupshev.client.CsvClient;
import useful.pupshev.service.CsvDownloaderService;
import static useful.pupshev.client.CsvClient.ULRCLASSIFICATORS;
import static useful.pupshev.client.CsvClient.URLCLASSIFICATORSXLS;

@RestController
@RequestMapping("api/v1")
@Tag(name = "Скачивание файлов", description = "Скачивание файлов из интернета по ссылке")
public class CsvAndXslxDownloader {
  private final CsvDownloaderService csvDownloaderService;
  private final CsvClient csvClient;

  public CsvAndXslxDownloader(CsvDownloaderService csvDownloaderService, CsvClient csvClient) {
    this.csvDownloaderService = csvDownloaderService;
    this.csvClient = csvClient;
  }

  @GetMapping("/downloadFile")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Скачивание файла")
  public void setCsvDownloader() {
      try {
//          csvDownloaderService.downloadCsv(ULRCLASSIFICATORS, csvClient.targetPath);
          csvDownloaderService.downloadCsv(URLCLASSIFICATORSXLS, csvClient.targetPath2);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }
}
