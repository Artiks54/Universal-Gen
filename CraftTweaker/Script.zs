import mods.universalgen.TileUniversalGenerator;

// Add generator recipes
// <minecraft:stone> = item
// 30 = need tick to generated
TileUniversalGenerator.addGeneratedItem(<minecraft:stone>, 30);

// Deleted recipes
TileUniversalGenerator.removeGeneratedItem(<minecraft:cobblestone>);

//Warning
If you delete absolutely all recipes, this may lead to an error. At a minimum, there must be at least 1 recipe in the mechanism