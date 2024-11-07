package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Util.Config;

import static com.ariks.universalgen.Block.UniversalGen.GeneratorRecipes.recipes;

public class TileUniversalGenAdvanced extends TileUniversalGen {

    @Override
    protected int maxProgress() {
        return (recipes.get(getValue(4)).getGenerationTime() / Config.RequiredGeneratorTickAdvanced);
    }
    @Override
    protected int maxModesAmount(){
        return 3;
    }
}
