package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> {
            double avg = Stream.of(pupil)
                    .flatMap(flatPupil -> flatPupil.getSubjects().stream())
                    .mapToInt(Subject::getScore)
                    .average()
                    .orElse(0D);
            return new Tuple(pupil.getName(), avg);
        }
        )
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(stringDoubleEntry -> new Tuple(
                        stringDoubleEntry.getKey(),
                        stringDoubleEntry.getValue()))
                .sorted()
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> {
            double sum = Stream.of(pupil)
                    .flatMap(flatPupil -> flatPupil.getSubjects().stream())
                    .mapToInt(Subject::getScore)
                    .sum();
            return new Tuple(pupil.getName(), sum);
        }
        ).max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(stringDoubleEntry -> new Tuple(
                        stringDoubleEntry.getKey(),
                        stringDoubleEntry.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
