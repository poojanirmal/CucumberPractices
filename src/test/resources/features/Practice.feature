
@ui @HealthCheckUp

Feature: Myntra website Health check up

Background: Navigate to the home page of web site
Given User navigate to the home page by using url "https://www.myntra.com/"

@ProdSearch
Scenario: User is able to open the browser ,navigate to the URL and search the product
When  USer search for the "Mobile"
Then User validate the next page 

#no space or any symbol inside of < > this type  and for this web element 1 of 1 only ..so we cant used scenario category here just because we cant make web element 1 of 1 and also Examples always at end of scenario outline
@HeaderSection
Scenario Outline: User is able to open the browser,navigate to the URL and check the header section
When User mouse over the desktop_bar
| Men |
| Women |
| Kids |
| Home & Living |
| Beauty |






