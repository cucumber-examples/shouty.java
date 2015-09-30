# Shouty

Shouty is a social networking application for short physical distances.
When someone shouts, only people within 1000m can hear it.

Shouty doesn't exist yet - you will implement it yourself!

That is, if you're attending a BDD/Cucumber course.

## Agenda

### Get the code

You'll be working on a branch of the repository that has been set up for the
training. This allows you to catch up with the trainer's code throughout the day.

Substitute `THEBRANCH` below with what the trainer tells you.
It's usually today's date, followed by the trainer's initials: `YYYY-MM-DD-FL`.

Git:

    git clone https://github.com/cucumber-ltd/shouty.java.git
    cd shouty.java
    git checkout THEBRANCH

Subversion:

    svn checkout https://github.com/cucumber-ltd/shouty.java/branches/THEBRANCH shouty.java
    cd shouty.java

Or simply [download](https://github.com/cucumber-ltd/shouty.java/releases) a zip or tarball.

### Catch up!

Throughout the day - if you want to catch up with what the trainer has pushed to this
branch, simply do:

    git reset --hard  # This blows away your local changes
    git pull          # This updates your working copy with the latest code

### Set up environment

* Install IntelliJ IDEA
  * Install Gherkin plugin
  * Install Cucumber for Java plugin
* Install Maven
* Run `mvn test`

You should see:

    0 Scenarios
    0 Steps

### Brainstorm capabilities

* Who are the main stakeholders?
* What can people do with the app?
* What are the main differentiators from other apps?

### Pick one capability

* Define rules
* Create high level examples (Friends episodes)

Then do this for each example to discover more examples:

* Can you think of a context where the outcome would be different?
* Are there any other outcomes we haven't thought about?

### Implement one capability. Inner Hexagon only.

* Write a Cucumber Scenario for one of the examples
* Make it pass!
