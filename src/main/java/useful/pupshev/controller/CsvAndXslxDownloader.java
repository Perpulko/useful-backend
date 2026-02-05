package useful.pupshev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import useful.pupshev.client.CsvClient;
import useful.pupshev.service.CsvDownloader;

import java.io.IOException;

import static useful.pupshev.client.CsvClient.ULRCLASSIFICATORS;

@RestController
@RequestMapping("api/v1")
public class CsvAndXslxDownloader {
    private final CsvDownloader csvDownloader;
    private final CsvClient csvClient;

    public CsvAndXslxDownloader(CsvDownloader csvDownloader, CsvClient csvClient) {
        this.csvDownloader = csvDownloader;
        this.csvClient = csvClient;
    }
    @GetMapping("/classificators")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setCsvDownloader() throws IOException, InterruptedException {
        csvDownloader.downloadCsv(ULRCLASSIFICATORS, csvClient.targetPath);
    }
}
