package oncall;

public enum MonthInfo {

    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31)
    ;

    private final int month;
    private final int endOfMonth;

    MonthInfo(int month, int endOfMonth) {
        this.month = month;
        this.endOfMonth = endOfMonth;
    }

    public int getMonth() {
        return month;
    }

    public int getEndOfMonth() {
        return endOfMonth;
    }
}