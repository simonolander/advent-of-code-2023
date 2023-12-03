package org.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    InputStream is = Main.class.getClassLoader().getResourceAsStream("input-1.txt");
    Scanner scanner = new Scanner(is);
    var calibrationCodeSum =0;
    while (scanner.hasNextLine()) {
      var line = scanner.nextLine();

      final var calibrationCode = getCalibrationCode(line);
      calibrationCodeSum += calibrationCode;
    }
    System.out.println(calibrationCodeSum);
  }

  static int getCalibrationCode(String line) {
    var numbers = getLineNumbers(line);
    var firstNumber = numbers.getFirst();
    var lastNumber = numbers.getLast();
    var calibrationCode = firstNumber * 10 + lastNumber;
    return calibrationCode;
  }

  static List<Integer> getLineNumbers(String line) {
    List<Integer> numbers = new ArrayList<>();
    for (int index = 0; index < line.length(); index += 1) {
      var character = line.charAt(index);
      if (Character.isDigit(character)) {
        var number = Character.getNumericValue(character);
        numbers.add(number);
      }
    }
    return numbers;
  }
}
