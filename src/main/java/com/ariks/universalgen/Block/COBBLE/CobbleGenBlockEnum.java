package com.ariks.universalgen.Block.COBBLE;

import com.ariks.universalgen.Util.Config;

public enum CobbleGenBlockEnum {
    lvl_1(Config.Ccount_1),
    lvl_2(Config.Ccount_2),
    lvl_3(Config.Ccount_3),
    lvl_4(Config.Ccount_4),
    lvl_5(Config.Ccount_5);
    private final int count;
    CobbleGenBlockEnum(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }
}
