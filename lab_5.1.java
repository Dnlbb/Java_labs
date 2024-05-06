import java.util.*;
class Applicant {
    String regNumber;
    int[] scores;

    Applicant(String regNumber, int[] scores) {
        this.regNumber = regNumber;
        this.scores = scores;
    }
    int totalScore() {
        return Arrays.stream(this.scores).sum();
    }
}
