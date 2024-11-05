package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Util.Config;

public class TileUniversalGenAdvanced extends TileUniversalGen {

    @Override
    public int maxProgress() {
        return Config.RequiredGeneratorTickAdvanced;
    }
}
