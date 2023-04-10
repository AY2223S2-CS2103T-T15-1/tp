---
layout: page
title: Jiexuan's Project Portfolio Page
---

### Reroll

Reroll is a desktop address book application used for teaching Software Engineering principles. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Our team focused on their respective components of Reroll, instead of allocation of job by features.

Given below are my contributions to the project.

* **Refactor and implement existing Model component**
    * What it does: Design how entities are modelled and stored within Reroll at runtime to supports various commands and features required by Reroll.
    * Highlights: It required an in-depth analysis of architecture design with defensive programming in mind. The facade design pattern was crucial in developing the model.
  Implementation was not trivial due to the number of different entities and functionalities. Constant communication with members designing the features was important.

* **Refactor and implement existing Storage component**: Implement how entities are stored as JSON file within the user's device.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2223s2.github.io/tp-dashboard/?search=Jiexuan&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2023-02-17&tabOpen=true&tabType=authorship&tabAuthor=jiexuanc&tabRepo=AY2223S2-CS2103T-T15-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

* **Project management**:
    * Managed releases `v1.3` on GitHub

* **Enhancements to existing features**:
    * Wrote tests for model and storage components

* **Documentation**:
    * User Guide:
        * Added documentation for the planned enhancements to address feature flaws [\#208](https://github.com/AY2223S2-CS2103T-T15-1/tp/pull/208)
        * Did cosmetic tweaks to existing documentation of features and entity classification.
    * Developer Guide:
        * Added implementation details of the storage and model components

* **Community**:
    * PRs reviewed (with non-trivial review comments): [\#113](https://github.com/AY2223S2-CS2103T-T15-1/tp/pull/113), [\#114](https://github.com/AY2223S2-CS2103T-T15-1/tp/pull/114)


