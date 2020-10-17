package com.tegres.project.euler.challenges;

import com.tegres.project.euler.common.Preconditions;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Edwin Gertse
 */
public class LargestProductInSeries {

    private static final Integer FIRST_CHARACTER = 1;
    private static final Integer ADJACENT_DIGIT_LENGTH = 13;
    private static final String FILE_NAME = "series.txt";

    private String groupInSeries = null;
    private Long greatestProduct = 0L;

    private Long simpleExecute() throws IOException {
        String numbers = retrieveSeries();
        if (numbers == null) throw new IOException("File not found.");

        Optional<String> group = findGroup(numbers);
        group.ifPresent(grp -> groupInSeries = grp);

        final CharacterIterator it = new StringCharacterIterator(numbers);
        for (char c = it.setIndex(ADJACENT_DIGIT_LENGTH); c != CharacterIterator.DONE; c = it.next()) {
            setGreatestProduct(groupInSeries);
            groupInSeries = moveAdjacentDigits(groupInSeries, c);
        }
        return greatestProduct;
    }

    private Optional<String> findGroup(String series) {
        Preconditions.notNull(series, "Value of <series> should not be NULL");

        Pattern pattern = Pattern.compile("(\\d{" + ADJACENT_DIGIT_LENGTH + "})");
        Matcher matcher = pattern.matcher(series);
        if (matcher.find()) return Optional.ofNullable(matcher.group());

        return Optional.empty();
    }

    private String removeFirstChar(String group) {
        return group.substring(FIRST_CHARACTER);
    }

    private String appendChar(String group, char ch) {
        return new StringBuilder(group).append(ch).toString();
    }

    private String moveAdjacentDigits(String group, char ch) {
        String add = appendChar(group, ch);
        return removeFirstChar(add);
    }

    private void setGreatestProduct(String group) {
        if (group != null) {
            Long vGroup = Long.parseLong(group);
            if (vGroup > greatestProduct) greatestProduct = vGroup;
        }
    }

    private String retrieveSeries() {
        String series = null;
        File file = getResource(FILE_NAME);
        try {
            series = Files.readAllLines(Paths.get(file.toURI()), StandardCharsets.UTF_8)
                    .stream()
                    .map(String::toString)
                    .collect(Collectors.joining());
            series = series.replace(System.getProperty("line.separator"), "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return series;
    }

    private File getResource(String filename) {
        URL resource = LargestProductInSeries.class.getClassLoader().getResource(filename);
        Objects.requireNonNull(resource);
        return new File(resource.getFile());
    }
}
