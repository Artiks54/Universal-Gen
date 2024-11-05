import mods.universalgen.TileUniversalGenerator;

// Add generator recipes
// <minecraft:stone> = item
// 30 = need tick to generated
TileUniversalGenerator.addGeneratedItem(<minecraft:stone>, 30);

// Deleted recipes
TileUniversalGenerator.removeGeneratedItem(<minecraft:cobblestone>);