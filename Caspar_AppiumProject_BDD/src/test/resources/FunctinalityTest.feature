Feature:  Training in Caspar application

  Scenario Outline: Verify the working functionality on the My Training tab
  
    Given Application is installed and launched
    And The User is on the SignIn page
    When The User fills 'ZUM0673' and '63852704'
    And The User clicks on SignIn button
    Then The User is navigated to the My Training tab with 'trainings' title
    And The User clicks on the Go button on the My Training section
    Then  The app should display the number of Exercises, number of Minutes and the You Will Need section
    And The User clicks on the I am Ready button on the My Training page
    Then The app should display the Video training, Sets, Sec, Tools, Instruction and Settings
    And The User clicks on the Start button on the My Training page
    Then The app should count the numbers from 8 to 1
    And The app should start the duration of exercise
    Then The app should display the Well done! page when the app finishes any step