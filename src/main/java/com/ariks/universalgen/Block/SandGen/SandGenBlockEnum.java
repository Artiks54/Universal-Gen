package com.ariks.universalgen.Block.SandGen;

import com.ariks.universalgen.Util.Config;

public enum SandGenBlockEnum {
    lvl_1(Config.count_1),
    lvl_2(Config.count_2),
    lvl_3(Config.count_3),
    lvl_4(Config.count_4);
    private final int count;
    SandGenBlockEnum(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }
}
