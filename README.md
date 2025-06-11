# Creating-a-zoo
Introduction to Software Development (Course project: Creating a zoo)

This is a Java project built as part of the **"Creating a Zoo"** hands-on lab. It demonstrates the use of **inheritance**, **interfaces**, **method overriding**, and a **menu-based user interface**.

---

## Overview

The project simulates a zoo with 3 animal types:

- Tiger
- Dolphin
- Penguin

Each animal has specific behaviors and properties. The system uses a base class (`Animal`), multiple interfaces (`Walk`, `Swim`, `Eat`), and showcases polymorphism via user interaction.

---

## Features

### Animal (abstract base class)
- Common attributes and methods (e.g., `eatingFood()`, `eatingCompleted()`).

### Tiger
- Inherits from `Animal`
- Additional attributes: `numberOfStripes`, `speed`, `soundLevel`
- Implements `Walk`
- Overrides `eatingFood()` and `eatingCompleted()`

### Dolphin
- Inherits from `Animal`
- Attributes: `color`, `swimmingSpeed`
- Implements `Swim`
- Overrides feeding behavior

### Penguin
- Inherits from `Animal`
- Attributes: `isSwimming` (boolean), `walkSpeed`, `swimSpeed`
- Implements `Walk` and `Swim`
- Overrides eating methods

---

## Interfaces

- `Walk`: defines `walking()` method
- `Swim`: defines `swimming()` method
- `Eat`: defined in `Animal`, but implemented differently by each animal

---

## Menu System

The program uses a `Scanner`-based menu where the user:

1. Selects an animal type
2. Views/modifies properties
3. Performs actions like `eating`, `walking`, or `swimming`
4. Returns or exits

---

## Concepts Practiced

- Inheritance and abstraction  
- Interface-based behavior control  
- Method overriding  
- Switch-based menu logic  
- Polymorphism in action  

---

## Author
**Renan Correa**  
📅 June 2025
