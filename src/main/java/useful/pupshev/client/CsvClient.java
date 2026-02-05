package useful.pupshev.client;

import org.springframework.stereotype.Component;
import java.nio.file.Path;

@Component
public class CsvClient {
  public static final String ULRCLASSIFICATORS = "https://classifikators.ru/assets/downloads/oktmo/oktmo.csv";
  public static final String ULRROSSTAT = "https://rosstat.gov.ru/opendata/7708234640-okfs/data-20231101T1111-structure-20180326T1603.csv";
  public Path targetPath = Path.of("data1.csv");

}
