package me.trouper.clickcrystalsalias.utils;

import org.bukkit.inventory.ItemStack;

public class Utils {

    public static String getItemName(ItemStack i) {
        return capitalizeWords(i.getType().name());
    }
    public static String capitalize(String s) {
        if (s.length() <= 1) return s.toUpperCase();
        s = s.toLowerCase();
        return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1);
    }

    public static String capitalizeWords(String s) {
        s = s.replaceAll("[_-]"," ");
        String[] sArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : sArray) sb.append(capitalize(str)).append(" ");
        return sb.toString().trim();
    }

}
