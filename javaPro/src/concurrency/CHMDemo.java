package concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CHMDemo {
    public static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

    public static void process(Path file){
        try(Scanner in = new Scanner(file)){
            while(in.hasNext()){
                String word = in.next();
                map.merge(word, 1L, Long::sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<Path> descendants(Path rootDir) throws IOException{
        try(Stream<Path> stream = Files.walk(rootDir)){
            return stream.collect(Collectors.toSet());
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService exec = Executors.newFixedThreadPool(processors);
        Path pathToRoot = Paths.get(".");
        for(Path p: descendants(pathToRoot)){
            if(p.getFileName().toString().endsWith(".java")){
                exec.execute(()->process(p));
            }
        }
        exec.shutdown();

        exec.awaitTermination(10, TimeUnit.MINUTES);
        map.forEach((k,v)->{
            if(v>=100)
                System.out.println(k + " occurs " + v + " times");
        });
    }
}
