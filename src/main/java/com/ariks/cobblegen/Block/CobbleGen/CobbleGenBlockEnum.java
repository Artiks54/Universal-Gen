package com.ariks.cobblegen.Block.CobbleGen;

import com.ariks.cobblegen.util.Config;

public enum CobbleGenBlockEnum {
    lvl_1(Config.count_1, Config.speed_1),
    lvl_2(Config.count_2,Config.speed_2),
    lvl_3(Config.count_3,Config.speed_3),
    lvl_4(Config.count_4,Config.speed_4);
    private final int count,speed;
    CobbleGenBlockEnum(int count,int speed) {
        this.count = count;
        this.speed = speed;
    }
    public int getCount() {
        return count;
    }
    public int getSpeed() {
        return speed;
    }
}
