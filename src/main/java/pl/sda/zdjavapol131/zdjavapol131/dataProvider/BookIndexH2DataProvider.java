package pl.sda.zdjavapol131.zdjavapol131.dataProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import pl.sda.zdjavapol131.zdjavapol131.repository.BooksRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.BooksEntity;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookIndexH2DataProvider implements CommandLineRunner {
    private final BooksRepository booksRepository;
    @Autowired
    public BookIndexH2DataProvider(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    @Value("classpath:bookIndex.txt")
    private Resource resource;

    @Override
    public void run(String... args) throws Exception {
        String filePathString = resource.getFile().getPath();
        Path of = Path.of(filePathString);
        List<BooksEntity> collect = Files.readAllLines(of)
                .stream()
                .map(x -> x.split(","))
                .map(x -> BooksEntity
                        .builder()
                        .author(x[0])
                        .title(x[1])
                        .publisher(x[2])
                        .category(x[3])
                        .releaseDate(LocalDate.parse(x[4].concat("-").concat(x[5]).concat("-").concat(x[6])))
                        .build())
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
