Feature: Login

	@valid	
	Scenario Outline: With Valid Credentials
		Given user is on the login page
		When user enters <username> as username
		And user enters <password> as password
		And user clicks login button
		Then user is able to see <logoText>
	
	Examples:
		| username      | password     | logoText  |
		| standard_user | secret_sauce | Swag Labs |
	
	@invalid
	Scenario Outline: With Invalid Credentials
		Given user is on the login page
		When user enters <username> as username
		And user enters <password> as password
		And user clicks login button
		Then user gets an error which contains <errorText>
	
	Examples:
		| username        | password     | errorText    |
		| standard_user   | secret_sauc  | do not match |
    | locked_out_user | secret_sauce | locked       |