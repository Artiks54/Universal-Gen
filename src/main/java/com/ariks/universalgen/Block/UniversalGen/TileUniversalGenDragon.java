package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Util.Config;

public class TileUniversalGenDragon extends TileUniversalGen {

    @Override
    public int maxProgress() {
        return Config.RequiredGeneratorTickDragon;
    }
}
