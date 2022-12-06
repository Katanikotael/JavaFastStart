import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FileHandler {

    public LinkedList<Member> readFile() {
        LinkedList<Member> m = new LinkedList<>();
        String lineRead;
        String[] splitLine;
        Member mem;

        try (var reader = new BufferedReader(new FileReader("src/members.csv"))) {
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(", ");
                if (splitLine[0].equals("S")) {
                    var type = splitLine[0].charAt(0);
                    var id = Integer.parseInt(splitLine[1]);
                    var name = splitLine[2];
                    var fee = Double.parseDouble(splitLine[0]);
                    var club = Integer.parseInt(splitLine[4]);
                    mem = new SingleClubMember(type, id, name, fee, club);
                } else {
                    var type = splitLine[0].charAt(0);
                    var id = Integer.parseInt(splitLine[1]);
                    var name = splitLine[2];
                    var fee = Double.parseDouble(splitLine[0]);
                    var points = Integer.parseInt(splitLine[4]);
                    mem = new MultiClubMember(type, id, name, fee, points);
                }
                m.add(mem);
                lineRead = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }

    public void appendFile() {}

    public void overWriteFile() {}
}
