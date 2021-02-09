import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyDIr implements FileVisitor<Path> {
    private final Path source;
    private final Path target;

    public CopyDIr(Path source, Path target) {
        this.source = source;
        this.target = target;
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path targetPath = target.resolve(source.relativize(dir));
        if (!targetPath.toFile().exists())
            Files.createDirectory(targetPath);
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Копирование файла " +  file);
        Path targetPath = target.resolve(source.relativize(file));
        Files.copy(file, targetPath, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;

    }
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
