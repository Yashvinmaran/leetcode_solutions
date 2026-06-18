class Solution {
    public double angleClock(int hour, int minutes) {
        double mindeg_move = minutes*6.0;
        double hrdeg_move = (30.0*hour) + (mindeg_move/12.0);

        double gap = (mindeg_move - hrdeg_move) < (hrdeg_move - mindeg_move)?(mindeg_move - hrdeg_move):(hrdeg_move - mindeg_move);

        gap = gap < 0 ? 360+gap:gap;
        return 360-gap < gap ? 360-gap : gap;
    }
}
