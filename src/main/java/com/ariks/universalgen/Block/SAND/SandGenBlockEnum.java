package com.ariks.universalgen.Block.SAND;

import com.ariks.universalgen.Util.Config;

public enum SandGenBlockEnum {
    lvl_1(Config.Scount_1),
    lvl_2(Config.Scount_2),
    lvl_3(Config.Scount_3),
    lvl_4(Config.Scount_4),
    lvl_5(Config.Scount_5);
    private final int count;
    SandGenBlockEnum(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }
}
