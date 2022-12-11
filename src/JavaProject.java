import java.util.LinkedList;

public class JavaProject {
    public static void main(String[] args) {
        var mm = new MembershipManagement();
        var fh = new FileHandler();
        LinkedList<Member> members = fh.readFile();
        int choice = mm.getChoice();

        while (choice != -1) {
            switch (choice) {
                case (1):
                    fh.appendFile(mm.addMembers(members));
                    break;
                case (2):
                    mm.removeMember(members);
                    fh.overWriteFile(members);
                    break;
                case (3):
                    mm.printMemberInfo(members);
                    break;
                default:
                    System.out.println("You have selected an invalid option\n");
            }
            choice = mm.getChoice();
        }
        System.out.println("\n The program is closing.\nBye!");
    }
}
