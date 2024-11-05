package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Util.Config;

public class TileUniversalGenAdvanced extends TileUniversalGen {

    @Override
    protected int maxProgress() {
        return (TileUniversalGenItems.getItemsToGenerate().get(getValue(4)).getGenerationTime() / Config.RequiredGeneratorTickAdvanced);
    }
}
