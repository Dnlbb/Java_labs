import java.util.stream.Collectors;
import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        ApplicantTable table = new ApplicantTable();
        table.add("1021", new int[]{90, 95, 85});
        table.add("1232", new int[]{88, 91, 80});
        table.add("1213", new int[]{100, 100, 100});
        table.add("1203", new int[]{2, 10, 90});
        table.add("1504", new int[]{85, 84, 90});

        Map<Character, List<String>> groupedByLastDigit = table.streamTopApplicants(3, 260)
                .collect(Collectors.groupingBy(regNum -> regNum.charAt(regNum.length() - 1)));

        groupedByLastDigit.forEach((digit, regNums) -> {
            System.out.println("id = " + digit);
            regNums.forEach((String str) -> System.out.println(str));
        });

        table.findTopScorer().ifPresentOrElse(
                regNum -> System.out.println("id = " +  regNum),
                () -> System.out.println("No")
        );
    }
}
