import java.util.*;
import java.util.stream.Stream;

class ApplicantTable {
    HashMap<String, Applicant> table;

    ApplicantTable() {
        table = new HashMap<>();
    }

    void add(String regNumber, int[] scores) {
        table.put(regNumber, new Applicant(regNumber, scores));
    }

    public Stream<String> streamTopApplicants(int n, int s) {
        return table.values().stream()
                .filter(a -> a.totalScore() > s)
                .sorted(Comparator.comparingInt(Applicant::totalScore).reversed())
                .limit(n)
                .map(a -> a.regNumber);
    }

    public Optional<String> findTopScorer() {
        int[] topScores = {-1,-1,-1};
        Applicant[] topApplicants = new Applicant[3];
        for (Applicant applicant : table.values()) {
            for (int i = 0; i < 3; i++) {
                if (applicant.scores[i] > topScores[i]) {
                    topScores[i] = applicant.scores[i];
                    topApplicants[i] = applicant;
                }
            }
        }


        if (topApplicants[0] == topApplicants[1] && topApplicants[1] == topApplicants[2]) {
            return Optional.of(topApplicants[0].regNumber);
        }

        return Optional.empty();
    }
}
