public class MultiClubMember extends Member{
    private int membershipPoints;

    public MultiClubMember(char mType, int mID, String mName, double mFees, int membershipPoints) {
        super(mType, mID, mName, mFees);
        this.membershipPoints = membershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }

    @Override
    public String toString() {
        return "MultiClubMember{" +
                "membershipPoints=" + membershipPoints +
                "} " + super.toString();
    }
}
