import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    final private Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        var choice = 0;
        while (choice == 0) {
            try {
                choice = reader.nextInt();
                if (choice == 0) throw new InputMismatchException();
                reader.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("ERROR: INVALID INPUT. Please try again: ");
                choice = reader.nextInt();
                reader.nextLine();
            }
        }
        return choice;
    }

    private void printClubOptions() {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice() {
        System.out.println();
        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("================================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println("Please select an option (or Enter -1 to quit): ");
        return getIntInput();
    }

    public String addMembers(LinkedList<Member> m) {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;
        System.out.print("Enter member name please: ");
        name = reader.nextLine();
        printClubOptions();
        System.out.println("Choose the club please: ");
        club = getIntInput();
        while (club < 1 || club > 4) {
            System.out.println("ERROR: INVALID INPUT. Please try again: ");
            club = getIntInput();
        }
        if (m.size() > 0) memberID = m.getLast().getMemberID() + 1;
        else memberID = 1;
        if (club != 4) {
            cal = (n) -> {
                switch (n) {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Single Club Member added\n");
        } else {
            cal = (n) -> {
                if (n == 4) {
                    return 1200;
                }
                return -1;
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Multi Club Member added\n");
        }
        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        System.out.println();
        System.out.println("Enter member's ID to remove him: ");
        int memberID = getIntInput();
        for (int i = 0; i < m.size(); i++) {
            if (memberID == m.get(i).getMemberID()) {
                System.out.printf("\nSTATUS: Member №%d %s deleted\n",m.get(i).getMemberID(), m.get(i).getMemberName());
                m.remove(i);
                return;
            }
        }
        System.out.println("\nSTATUS: Member №" + memberID + " not found.");
    }

    public void printMemberInfo(LinkedList<Member> m) {
        System.out.println();
        System.out.println("Enter member's ID: ");
        int memberID = getIntInput();
        for (Member member : m) {
            if (memberID == member.getMemberID()) {
                String[] currentMember = member.toString().split(", ");
                String mType = currentMember[0];
                String ID = currentMember[1];
                String name = currentMember[2];
                String fees = currentMember[3];
                String clubOrPoints = currentMember[4];
                if (mType.equals("S")) {
                    System.out.println("\nMember Type = " + mType);
                    System.out.println("Member ID = " + ID);
                    System.out.println("Member Name = " + name);
                    System.out.println("Membership Fees = " + fees);
                    System.out.println("Club ID = " + clubOrPoints);
                } else {
                    System.out.println("\nMember Type = " + mType);
                    System.out.println("Member ID = " + ID);
                    System.out.println("Member Name = " + name);
                    System.out.println("Membership Fees = " + fees);
                    System.out.println("Membership Points = " + clubOrPoints);
                }
                return;
            }
        }
        System.out.println("\nSTATUS: Member №" + memberID + " not found.");
    }
}
