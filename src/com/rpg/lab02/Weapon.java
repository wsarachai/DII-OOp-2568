package com.rpg.lab02;

/**
 * Weapon class represents a weapon used by a character in the RPG Game.
 * This class encapsulates weapon attributes like name, type, and damage.
 */
public class Weapon {

  // Attributes
  private String name;
  private String type; // e.g., "Sword", "Staff", "Bow"
  private int baseDamage;
  private String ability; // Special ability of the weapon

  // Constructor
  public Weapon(String name, String type, int baseDamage, String ability) {
    this.name = name;
    this.type = type;
    this.baseDamage = baseDamage;
    this.ability = ability;
  }

  // Getters
  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public int getBaseDamage() {
    return baseDamage;
  }

  public String getAbility() {
    return ability;
  }

  // Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setBaseDamage(int baseDamage) {
    this.baseDamage = baseDamage;
  }

  // Display weapon details
  public void displayWeaponDetails() {
    System.out.println("    Weapon: " + name + " (Type: " + type +
        ", Damage: " + baseDamage + ", Ability: " + ability + ")");
  }
}
