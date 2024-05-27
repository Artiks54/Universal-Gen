package com.ariks.cobblegen.Block.CobbleGen;

public enum CobbleGenBlockEnum {
    lvl_1(1),
    lvl_2(2),
    lvl_3(3),
    lvl_4(4),
    lvl_5(5);
    private final int id;
    CobbleGenBlockEnum(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
