package com.rpg.lab02;

/**
 * Character class represents a game character in the RPG Game.
 * This class manages character attributes like name, level, health points, and
 * weapon.
 */
public class Character {

  // Attributes
  private String name;
  private int level;
  private int healthPoints;
  private int maxHealthPoints;
  private int damage;
  private int defense;
  private Weapon weapon;
  private String characterClass; // e.g., "Warrior", "Mage", "Healer"

  // Constructor
  public Character(String name, int level, int healthPoints, int damage, int defense, Weapon weapon,
                   String characterClass) {
    this.name = name;
    this.level = level;
    this.healthPoints = healthPoints;
    this.maxHealthPoints = healthPoints;
    this.damage = damage;
    this.defense = defense;
    this.weapon = weapon;
    this.characterClass = characterClass;
  }

  // Getters
  public String getName() {
    return name;
  }

  public int getLevel() {
    return level;
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public String getCharacterClass() {
    return characterClass;
  }

  // Setters
  public void setHealthPoints(int healthPoints) {
    this.healthPoints = Math.min(healthPoints, maxHealthPoints);
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public boolean isAlive() {
    return healthPoints > 0;
  }
  /**
   * Attack method: prints an attack message
   * Damage calculation based on weapon's base damage and character level
   */
  public void attack(Character target) {
    if (!isAlive()) {
      System.out.println(name + " cannot attack because they have fainted.");
      return;
    }

    System.out.println(name + " (" + characterClass + ") attacks " + target.getName() + " with " + weapon.getName() + "!");
    int totalDamage = damage + weapon.getBaseDamage();
    System.out.println("  ⚔️  Raw Attack Damage: " + totalDamage);
    // Send raw damage to target - let them handle their own defense
    target.takeDamage(totalDamage);
  }

  /**
   * Level Up method: increases character level and health points
   */
  public void levelUp() {
    level++;
    int healthIncrease = 10;
    maxHealthPoints += healthIncrease;
    healthPoints = maxHealthPoints; // Restore full health on level up
    System.out.println(name + " leveled up to Level " + level + "!");
    System.out.println("  📈 Max Health increased to " + maxHealthPoints + " (full heal applied)");
  }

  /**
   * Take damage method
   */
  public void takeDamage(int damage) {
    healthPoints -= damage;
    if (healthPoints < 0) {
      healthPoints = 0;
    }
    System.out.println(name + " takes " + damage + " damage! Current HP: " + healthPoints + "/" + maxHealthPoints);
  }

  /**
   * Display character details
   */
  public void displayCharacterDetails() {
    System.out.println("\n--- " + name.toUpperCase() + " ---");
    System.out.println("  Class: " + characterClass);
    System.out.println("  Status: " + (isAlive() ? "Active" : "Fainted"));
    System.out.println("  Level: " + level);
    System.out.println("  Health Points: " + healthPoints + "/" + maxHealthPoints);
    System.out.println("  Damage: " + damage);
    System.out.println("  Defense: " + defense);
    if (weapon != null) {
      weapon.displayWeaponDetails();
    }
  }
}
