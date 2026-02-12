package com.rpg.lab01;

/**
 * Healer class extends Character to add healing-specific abilities.
 * This is a specialized character class that has unique healing methods.
 */
public class Healer extends Character {

  private int healingPower; // Base healing amount per heal action

  // Constructor
  public Healer(String name, int level, int healthPoints, Weapon weapon, int healingPower) {
    super(name, level, healthPoints, weapon, "Healer");
    this.healingPower = healingPower;
  }

  // Getter
  public int getHealingPower() {
    return healingPower;
  }

  // Setter
  public void setHealingPower(int healingPower) {
    this.healingPower = healingPower;
  }

  /**
   * Heal method: heals the healer itself or another character
   */
  public void heal() {
    int amountHealed = healingPower + (getLevel() * 3);
    int currentHP = getHealthPoints();
    int maxHP = currentHP + 10 * (getLevel() - 1); // Simplified max HP calculation

    System.out.println(getName() + " (Healer) casts a healing spell!");
    System.out.println("  ✨ Healing Amount: " + amountHealed + " (Base: " + healingPower +
        " + Level Bonus: " + (getLevel() * 3) + ")");

    int healedHP = Math.min(currentHP + amountHealed, maxHP);
    int actualHealing = healedHP - currentHP;
    setHealthPoints(healedHP);
    System.out.println("  💚 Restored " + actualHealing + " HP! Current HP: " + getHealthPoints() + "/" + maxHP);
  }

  /**
   * Heal other character method
   */
  public void healAlly(Character ally) {
    int amountHealed = healingPower + (getLevel() * 3);
    int currentHP = ally.getHealthPoints();

    System.out.println(getName() + " (Healer) casts healing spell on " + ally.getName() + "!");
    System.out.println("  ✨ Healing Amount: " + amountHealed);

    ally.setHealthPoints(currentHP + amountHealed);
    System.out.println("  💚 Restored " + amountHealed + " HP to " + ally.getName() +
        "! Their HP: " + ally.getHealthPoints());
  }

  /**
   * Override displayCharacterDetails to show healing power
   */
  @Override
  public void displayCharacterDetails() {
    super.displayCharacterDetails();
    System.out.println("  Healing Power: " + (healingPower + (getLevel() * 3)));
  }
}
