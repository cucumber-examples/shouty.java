# Shouty

Deploy:

    git push heroku shoutyws:master

## Script

Give them a bare bones project similar to this one. Hexagonal Cucumber Scenarios.
One Selenium adapter and one Soap one. Both fail.

Open up your web browser and go to http://shouty-java-ws.herokuapp.com/people/<yourname>.

Play around with the application.
What business rules can you infer from the application?

Instructor: Hand out the following rules
* Can only hear within 1000m

- Better: (Since we did the rules on Day 1)
* Give them code with 2 scenarios

What questions do you have?

What happens if my neighbour shouts her dog's gone missing as I'm leaving work.
Will I see it 30 min later when I get home from work?

Can you write a new Cucumber Scenario that expresses the intended behaviour?

Now that you have written a scenario, you must *automate* it.
You have two options:
* Selenium
  * Link to http://www.seleniumhq.org/docs/03_webdriver.jsp
  * Run with `mvn test -Dautomation=selenium`
* SOAP (http://shouty.cucumber.io/ws?wsdl)
  * Run the `./wsdl2java` script to generate some code

Start with SOAP.

It's hard to get the "should not hear" test to pass. Why?
State is leaking between scenarios. BAD! How can we reset state?

    # http://unirest.io/java.html
    Unirest.post("http://shouty.cucumber.io/reset").asString();

Should the test fail or pass?
When a test fails, what do you want the test to tell you?
How can you make the test tell you what the expected/actual result is?

Instructor - when they all have a good failing scenario, "fix it":
    heroku config:set DELIVERY_MODE=PULL
    # If you ever need to revert to the "buggy" implementation
    heroku config:set DELIVERY_MODE=PUSH

Is it green now? (It should be)

Now let's do Selenium

When they all have Selenium working, flick a switch to change some ids and classes.

    heroku config:set PREFIX=wat
    # Unset it
    heroku config:unset PREFIX

Ask them to run both suites again. (Selenium should fail, SOAP still pass)

What are the pros and cons of each approach?

* Authoring effort (SOAP wins)
* Maintainability (SOAP wins)
* Speed (SOAP wins)
* Confidence (Selenium wins)

Can you think of a 3rd approach? (Direct access)

## TODO

* [x]Start both WS and Web on the same server
  * [x] See https://gist.github.com/hamnis/6171880
* [x] Deploy to Heroku or DO
* [ ] Add server push (EventSource) or simply poll every second (ugh)
* [x] Inject same DomainShouty into WS and Web (obviously)
* [ ] Add form to set location with input field
* [x] Show name and location in UI
* [ ] Some basic styling (font, color, position)
* [x] Fix redirect to referer for shout
* [ ] Fix redirect to referer for setLocation
* [x] Change namespace from web.cucumber to io.cucumber.shouty
* [x] Set up DNS shouty.cucumber.io