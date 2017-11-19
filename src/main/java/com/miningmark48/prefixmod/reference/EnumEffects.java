package com.miningmark48.prefixmod.reference;

public enum EnumEffects {

    ATTACK_DAMAGE("generic.attackDamage"),
    ATTACK_SPEED("generic.attackSpeed"),
    MOVEMENT_SPEED("generic.movementSpeed"),
    LUCK("generic.luck"),
    MAX_HEALTH("generic.maxHealth"),
    KNOCKBACK_RESISTANCE("generic.knockbackResistance");

    private final String unlocalized;

    EnumEffects(String s) {
        this.unlocalized = s;
    }

    public String getUnlocalized() {
        return unlocalized;
    }

}
