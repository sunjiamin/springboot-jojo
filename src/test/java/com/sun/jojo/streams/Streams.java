package com.sun.jojo.streams;

import java.time.Clock;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
    private  enum Status{
        OPEN,CLOSE
    }

    public static final class Task{

        private final Status status;

        private final  Integer points ;

        public Task(Status status, Integer points) {
            this.status = status;
            this.points = points;
        }


        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]",status,points);
        }
    }

    /**
     * 新增的Stream API（java.util.stream）将生成环境的函数式编程引入了Java库中
     * @param agrs
     */
    public static void main(String[] agrs){
        List<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 51),
                new Task(Status.OPEN, 2),
                new Task(Status.CLOSE, 3));

        /**
         * * 首先，tasks集合被转换成steam表示；
         * 其次，在steam上的filter操作会过滤掉所有CLOSED的task；
         * 第三，mapToInt操作基于每个task实例的Task::getPoints方法将task流转换成Integer集合；
         * 最后，通过sum方法计算总和，得出最后的结果。
         */
        int sum = tasks.stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();

        System.out.println(sum);


        /**
         * Steam之上的操作可分为中间操作和晚期操作。
         * 中间操作会返回一个新的steam——执行一个中间操作（例如filter）并不会执行实际的过滤操作，
         * 而是创建一个新的steam，并将原steam中符合条件的元素放入新创建的steam。
         * 晚期操作（例如forEach或者sum），会遍历steam并得出结果或者附带结果；在执行晚期操作之后，steam处理线已经处理完毕，就不能使用了。
         * 在几乎所有情况下，晚期操作都是立刻对steam进行遍历。
         * steam的另一个价值是创造性地支持并行处理（parallel processing）。
         * 对于上述的tasks集合，我们可以用下面的代码计算所有任务的点数之和：
         */


        double totalPoints= tasks.stream()
                .parallel()
                .map(task -> task.getPoints())
                // or map( Task::getPoints )
                .reduce(0, Integer::sum);

        //这里我们使用parallel方法并行处理所有的task，并使用reduce方法计算最终的结果。控制台输出如下：
        System.out.println(totalPoints);

        /**
         * 对于一个集合，经常需要根据某些条件对其中的元素分组。利用steam提供的API可以很快完成这类任务
         */

        Map<Status, List<Task>> collect = tasks.stream()
                .collect(Collectors.groupingBy(Task::getStatus));


        System.out.println(collect);

        /**
         * 最后一个关于tasks集合的例子问题是：如何计算集合中每个任务的点数在集合中所占的比重，具体处理的代码如下：
         */
        List<String> collect1 = tasks.stream()
                .mapToInt(Task::getPoints)
                .asLongStream()
                .mapToDouble(points -> points / totalPoints)
                .boxed()
                .mapToLong(weight -> (long) (weight * 100))
                .mapToObj(obj -> obj + "%")
                .collect(Collectors.toList());

        System.out.println(collect1);


        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());


    }
}
