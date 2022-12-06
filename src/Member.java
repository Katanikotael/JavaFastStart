public class Member {
    private char memberType;
    private int memberID;
    private String memberName;
    private Double memberFees;

    public Member(char mType, int mID, String mName, double mFees) {
        this.memberType = mType;
        this.memberID = mID;
        this.memberName = mName;
        this.memberFees = mFees;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberType=" + memberType +
                ", memberID=" + memberID +
                ", memberName='" + memberName + '\'' +
                ", memberFees=" + memberFees +
                '}';
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Double getMemberFees() {
        return memberFees;
    }

    public void setMemberFees(Double memberFees) {
        this.memberFees = memberFees;
    }
}
