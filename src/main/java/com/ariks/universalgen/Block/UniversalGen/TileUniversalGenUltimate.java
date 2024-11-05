package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Util.Config;

public class TileUniversalGenUltimate extends TileUniversalGen {

    @Override
    public int maxProgress() {
        return Config.RequiredGeneratorTickUltimate;
    }
}
