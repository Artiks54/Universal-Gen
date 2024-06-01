package com.ariks.universalgen.Register;

import com.ariks.universalgen.Item.UpgradeItem;
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
    public static Item upgrade_lvl1 = new UpgradeItem("speed_upgrade_1");
    public static Item upgrade_lvl2 = new UpgradeItem("speed_upgrade_2");
    public static Item upgrade_lvl3 = new UpgradeItem("speed_upgrade_3");
    public static Item upgrade_lvl4 = new UpgradeItem("speed_upgrade_4");
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