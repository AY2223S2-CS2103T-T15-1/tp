---
layout: page title: Troy's Project Portfolio Page
---

### Project: Reroll

Reroll is a desktop app for managing tabletop RPG character, monster and item sheets, optimized for use via a Command
Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Reroll
can get your entity management tasks done faster than traditional GUI apps.

Given below are my contributions to the project.

* **New Feature**: Added Edit Mode.
    * What it does: allows the user to enter a runtime state that allows them to easily chain commands to edit multiple
      values within a single entity.
    * Justification: This feature improves the product significantly it cuts out significant amounts of typing and helps
      to keep commands short, preventing the user from getting overwhelmed.
    * Highlights: This enhancement required several additions to be made to the Logic and Model portions of Reroll to
      support the concept of a `currentSelectedEntity`, which required lots of coordination with the developers in
      charge of those features.

* **New Feature**: Added UI to support a comprehensive view of the entity while in Edit Mode.
    * What it does: displays all of the currently selected entity's information in a single, seperate UI panel that
      updates with every command / change made.
    * Justification: This feature is key to allow the user constant feedback while they are editing entities, and it
      allows them easy access to all the entity's information at a glance.
    * Highlights: This enhancement required a significant deep dive into JavaFX, and necessitated integration with the
      information flow from `Logic` to `UI` to support the constantly updating UI.


* **Code
  contributed**: [RepoSense link](https://nus-cs2103-ay2223s2.github.io/tp-dashboard/?search=roultitude&breakdown=true)

* **Project management**:
    * Managed releases `v1.1` - `v1.4` (4 releases) on GitHub

* **Team based tasks**:
    * Setup the Github Repo
    * Carried out initial integration of skeleton code features
    * Additional improvements on UI style such as addition of app icon and entity icons

* **Enhancements to existing features**:
    * Updated the UI styling (Pull request [\#63](https://github.com/AY2223S2-CS2103T-T15-1/tp/pull/63))
    * Wrote additional tests for Edit Mode feature [\#199](https://github.com/AY2223S2-CS2103T-T15-1/tp/pull/199))

* **Documentation**:
    * User Guide:
        * Wrote the initial draft of the User Guide [\#10](https://github.com/AY2223S2-CS2103T-T15-1/tp/pull/10)
    * Developer Guide:
        * Added documentation for the `Ui` component
          and `Edit Mode Logic` [\#92](https://github.com/AY2223S2-CS2103T-T15-1/tp/pull/92)
        * Added documentation for entity `Inventory` [\#214](https://github.com/AY2223S2-CS2103T-T15-1/tp/pull/214)
        