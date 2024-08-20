# Steps to setup project in local

1. Clone project from `git url`
2. Open project in a Code Editor as a `Maven` Project
3. Build the project
4. Navigate to `src>main>java>com.crm.qa>utilities` package, open `TesUtils.java` file
   - Update the worksapce path in your local machine for `WORKSPACE_PATH` String

## Step to provide test data

Navigate to `src>main>java>com.crm.qa>config` package, open `config.properties` file, update following variable values:

Set URL to navigate to expected website
`url`

To set expected browser, chrome - Chrome Browser || FF - Firefox browser
`browser`

Update value for defining Departure place
`LeavingFrom` 

Update value for defining Departure Date (Follow M/DD/YYYY Date format)
`DepartureDate`

-> Update value for defining Return Date (Follow M/DD/YYYY Date format)
`ReturnDate`

## Steps to run Automation Suite

1. Follow above mentioned points in `Project setup in local machine` section
2. Navigate to src>main>resources, Run `testng.xml`