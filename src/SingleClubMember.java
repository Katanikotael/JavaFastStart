public class SingleClubMember extends Member{
    private int club;

    public SingleClubMember(char mType, int mID, String mName, double mFees, int club) {
        super(mType, mID, mName, mFees);
        this.club = club;
    }

    @Override
    public String toString() {
        return "SingleClubMember{" +
                "club=" + club +
                "} " + super.toString();
    }

    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }
}
