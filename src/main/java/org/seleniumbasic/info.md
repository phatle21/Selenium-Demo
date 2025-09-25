# Test Cases

**TC01: Form Authentication :** [**Login successful with valid credentials**](https://cuhavp.github.io/form-authentication/)

1. Open browser
2. Navigate to <https://the-internet.herokuapp.com/login>
3. Fill in username with **tomsmith**
4. Fill in the password with **SuperSecretPassword!**
    1. Click on Login button
    2. And the home page is appear

**TC02: Checkboxes :** [**Check to a box**](https://cuhavp.github.io/checkboxes/)

1. Open browser
2. Navigate to <https://the-internet.herokuapp.com/checkboxes>
3. Check on **checkbox1**
4. Verify **checkbox1** is `checked`
5. Check on **checkbox2**
6. Verify **checkbox2** is `checked`

**TC03: DropDown :** [**Select option**](https://cuhavp.github.io/drop-down/)

1. Open browser
2. Navigate to <https://the-internet.herokuapp.com/dropdown>
3. Select "option 1"
4. Validate "option 1" is selected

**TC04: Hyper link :** [**Hyperlink - link text**](https://cuhavp.github.io/link-text/)

1. Open browser
2. Navigate to <https://the-internet.herokuapp.com/status_codes>
3. Click on "200"
4. Then "200 status code" page appear
5. Click on "go here"
6. Click on "301"
7. Then "301 status code" page appear
8. Click on "go here"
9. Click on "404"
10. Then "404 status code" page appear
11. Click on "go here"
12. Click on "500"
13. Then "500 status code" page appear
14. Click on "go here"

**TC05: Web Table:** [**Validate largest due person from a table**](https://cuhavp.github.io/java8-web-table/)

1. Open browser
2. Navigate to <https://the-internet.herokuapp.com/tables>
3. Focus on table 1
4. The person who has largest due is "Doe Jacson"

**TC06: Frame :** [**Nested frames**](https://cuhavp.github.io/iframe/)

1. Open browser
2. Navigate to <https://the-internet.herokuapp.com/nested_frames>
3. Verify Text present:

Copy

```
          LEFT

          RIGHT

          MIDDLE

          BOTTOM
```

**TC07: JavaScript Alert**

1. Open browser
2. Navigate to <https://the-internet.herokuapp.com/javascript_alerts>
3. When click on "Click For JS Alert" button
4. Then the Popup is displayed.

**TC08: Hover elements**

1. Open browser
2. Navigate to <https://the-internet.herokuapp.com/hovers>
3. When user hover on user 1 avatar
4. Then the "name: user1" label is present.

**TC09: Right click - Context menu**

1. Open browser
2. Navigate to <https://the-internet.herokuapp.com/context_menu>
3. Right click on square box
4. The context menu is displayed

**TC10: Page Object Model - Body Mass Index Page**

1. Open browser
2. Navigate to <https://www.calculator.net/bmi-calculator.html>
3. Select metric unit tab
4. Fill calculator with age, gender, weight, height
5. Validate result is correct

**TC11: Page Object Model- Todo MVC : Verify user able create a new todo**

1. Open browser
2. Navigate to <https://todomvc.com/examples/react/dist/>
3. Enter a new todo name
4. Verify a todo added

**TC12: Page Object Model- Todo MVC : Verify user able mark complete a todo**

1. Open browser
2. Navigate to <https://todomvc.com/examples/react/dist/>
3. Mark completed a exist todo
4. Verify a todo is marked completed

**TC13: Page Object Model- Todo MVC : Verify user able delete a todo**

1. Open browser
2. Navigate to <https://todomvc.com/examples/react/dist/>
3. Delete a exist todo
4. Verify a todo deleted

**TC14: Page Object Model- Todo MVC : Verify user able update a todo name**

1. Open browser
2. Navigate to <https://todomvc.com/examples/react/dist/>
3. Update a existed todo name
4. Verify a todo updated name successfully
