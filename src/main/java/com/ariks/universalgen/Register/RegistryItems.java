package com.ariks.universalgen.Register;

import com.ariks.universalgen.Item.UpgradeCount;
import com.ariks.universalgen.Item.UpgradeGen;
import com.ariks.universalgen.Item.UpgradeItem;
import com.ariks.universalgen.Item.UpgradeSpeed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegistryItems {
    public static Item upgrade_speed_lvl1 = new UpgradeSpeed("upgrade_speed_lvl1");
    public static Item upgrade_speed_lvl2 = new UpgradeSpeed("upgrade_speed_lvl2");
    public static Item upgrade_speed_lvl3 = new UpgradeSpeed("upgrade_speed_lvl3");
    public static Item upgrade_speed_lvl4 = new UpgradeSpeed("upgrade_speed_lvl4");
    public static Item upgrade_speed_lvl5 = new UpgradeSpeed("upgrade_speed_lvl5");
    public static Item upgrade_speed_lvl6 = new UpgradeSpeed("upgrade_speed_lvl6");
    public static Item upgrade_count_lvl1 = new UpgradeCount("upgrade_count_lvl1");
    public static Item upgrade_count_lvl2 = new UpgradeCount("upgrade_count_lvl2");
    public static Item upgrade_count_lvl3 = new UpgradeCount("upgrade_count_lvl3");
    public static Item upgrade_count_lvl4 = new UpgradeCount("upgrade_count_lvl4");
    public static Item upgrade_count_lvl5 = new UpgradeCount("upgrade_count_lvl5");
    public static Item upgrade_count_lvl6 = new UpgradeCount("upgrade_count_lvl6");
    public static Item upgrade_gen_sand = new UpgradeGen("upgrade_gen_sand");
    public static Item upgrade_gen_gravel = new UpgradeGen("upgrade_gen_gravel");
    public static Item upgrade_gen_cobblestone = new UpgradeGen("upgrade_gen_cobblestone");
    public static Item upgrade_blank = new UpgradeItem("upgrade_blank");
    public static final List<Item> ITEMS = new ArrayList<>();
    static {
        Field[] fields = RegistryItems.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (Item.class.isAssignableFrom(field.getType())) {
                    Item item = (Item) field.get(null);
                    ITEMS.add(item);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public static void preInit() {
        for (Item item : ITEMS) {
            setRegister(item);
        }
    }
    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        for (Item item : ITEMS) {
            setRender(item);
        }
    }
    private static void setRegister(Item item) {
        ForgeRegistries.ITEMS.register(item);
    }
    @SideOnly(Side.CLIENT)
    private static void setRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }
}