package concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecutorDemo {
    public static long occurrences(String word, Path path){
        try(var in = new Scanner(path)){
            int count=0;
            while(in.hasNext()){
                if(word.equals(in.next())){
                    count++;
                }
            }
            return count;
        }catch (IOException e){
            return 0;
        }
    }

    public static Set<Path> descendants(Path rootDir) throws IOException {
        try(Stream<Path> stream = Files.walk(rootDir)){
            return stream.filter(Files::isRegularFile)
                    .collect(Collectors.toSet());
        }
    }

    public static Callable<Path> searchForTask(String word, Path path) throws IOException {
        return ()->{
            try(var in = new Scanner(path)){
                while(in.hasNext()){
                    if(word.equals(in.next()))
                        return path;
                }
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("search in " + path +" canceled.");
                    return null;
                }
            }
            throw new NoSuchElementException();
        };
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        // 统计某个单词出现在目录下的几个文件中
        try(var in = new Scanner(System.in)){
            System.out.println("enter base directory: ");
            String start = in.nextLine();
            System.out.println("enter keyword: ");
            String word = in.nextLine();

            Set<Path> files = descendants(Paths.get(start));
            var tasks = new ArrayList<Callable<Long>>();
            for(Path file: files){
                Callable<Long> task = () -> occurrences(word, file);
                tasks.add(task);
            }

            ExecutorService exec = Executors.newCachedThreadPool();
//            ExecutorService exec = Executors.newSingleThreadExecutor();
            Instant startTime = Instant.now();
            // 提交Callable对象集合中的所有任务，阻塞直到所有的任务都完成
            List<Future<Long>> results = exec.invokeAll(tasks);
            long total = 0;
            for(Future<Long> f: results)
                total += f.get();
            Instant endTime = Instant.now();
            System.out.println(word+": "+total);
            System.out.println(Duration.between(startTime, endTime).toMillis()+"ms");

            var searchTasks = new ArrayList<Callable<Path>>();
            for(Path file: files){
                searchTasks.add(searchForTask(word, file));
            }
            // 返回某个已完成的任务的结果，如何捕获线程抛出的异常，通过FutureTask
            Path found = exec.invokeAny(searchTasks);
            System.out.println(word+" found in "+found);
            // 获得线程池中出现的最大线程数
            if(exec instanceof ThreadPoolExecutor)
                System.out.println("Largest pool size: " + ((ThreadPoolExecutor) exec).getLargestPoolSize());
            exec.shutdown();
        }
    }

}
