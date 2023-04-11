---
layout: page
title: Leonard's Project Portfolio Page
---

## Project: Reroll
Reroll is desktop app for managing tabletop RPG character, monster and item sheets, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI)

### Glossary:
Entity: refers to a single character, monster or item sheet.

Given below are my contributions to the project.

### Features
* **Make/Delete**: Added the ability to make/delete new entities.
    * What it does: allows the user to make/delete an entity one at a time.
    * Justification: This feature improves the product significantly because a user can make/delete entities with a short and simple command
    * Highlights: It required an in-depth analysis of design alternatives, in particular, the parsing of the new command syntax. The implementation was challenging as it required changes to existing parsers, storage and models.
* **Template**: Added the ability to create new Characters based on pre-determined templates.
  * What it does: allows the user to create a Character based on a template.
  * Justification: This feature improves the product because a user can make new characters with pre-determined fields quickly.
  * Highlights: The design and implementation of this was challenging. In particular, making sure that the given templates would have similar fields as the `Character` class, while not letting it affect the storage and model was challenging.
* **Show**: Added the ability to view a list of pre-determined templates

### General enhancements
* **Short-form commands/fields**: Added the ability to enter short-form commands/fields.
  * Example: `make char John` -> `m c John`
  * What it does: allows users to enter short-form versions of more commonly-used commands/fields.
  * Justification: allows expert users to be even more efficient in using Reroll.

### Code Contribution
* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2223s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2023-02-17&tabOpen=true&tabType=authorship&tabAuthor=LeonardYam&tabRepo=AY2223S2-CS2103T-T15-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

### Team-based tasks
* Managed releases `v1.2` - `v1.4` (3 releases) on GitHub

### Documentation:
* User Guide:
    * Added entity classifications.
    * Added list of fields for each entity.
    * Added `make`, `delete`, `template`, `show` features.
    * Added command summary for commands/fields with short-form variants
* Developer Guide:
    * Added implementation details of the `make` feature.
    * Added planned enhancements for the `delete` feature.
    * Updated various UML diagrams to reflect the Reroll architecture.

* **Tools**:
    * Integrated a third party library (Apache Commons) to the project

