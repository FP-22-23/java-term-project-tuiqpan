# Project of the Second Term. Fundamentals of Programming(Curso 2022/23)
Author: Ionel Tudor Cristian Lacatus   uvus:HPD8118

## Structure of the project's folders:

* **/src**: Directory with the source code
  * **users**: Package that contains the classes of the project
  * **tests**: Package that contains the test classes of the project
  * **utils**:  Package that contains the utility classes
* **/data**: Contains the data set for the project
    * **users.csv**: CSV file which contains the data that we will be analyzing
    
## *Structure of the DATASET*
This dataset is intended for comprehensive analysis of information that has been collected through an online form created by the European Union, specifically with the aim of analyzing financial data of citizens. 
The original dataset can be found in the following link -> "https://www.kaggle.com/datasets/overload10/adult-census-dataset".
This dataset has 12 columns and 12689 rows, also, the dataset was modified in order to add a wider variety of parameters, and to delete some irrelevant data. Now, we will describe each column:

* **username**: of type string, indicates the username of an user
* **country**: of type string, indicates the country of an user
* **dateOfbirth**: of type date. Indicates the date of birth of an user 
* **workclass**. of type string. Indicates the workclass of an user
* **education**: of type string. Indicates the maximum education that has achieved an user
* **maritalStatus**: of type string. Indicates ther marital status of a user
* **sex**: of type string. Indicates sex of a user
* **hours**: of type double. Indicates the hours that an user works each week
* **savings**: of type integer. Indicates the savings of a user
* **salary**: of type integer. Indicates ther salary of a user
* **mortgage**: of type boolean. Indicates whether a user is paying or not a mortgage
* **others**: of type list, separated by commas. This column show the brand of the phone and the brand of the principal car of a user

## Implemented Types

The types that have been implemented on the project are the following

### Base Type - User
Base type

**Properties**:

- _dateOfBirth_, of type Date, consultable and modifiable.
- _workclass_, _username_, _education_, _maritalStatus_, _sex_, of type String, consultable and modifiable
- _savings_, _salary_ of type Integer, consultable and modifiable
- _others_, of type List<String>, consultable and modifiable
- _mortgage_, of type Boolean, consultable and modifiable
- _salaryPerHour_, of type SalaryPerHour, consultable and modifiable. Indicates the salary per hour of a user

**Constructors**: 

- C1: Has a parameter for every basic property
- C2: Creates an object of type ```User``` from the following parameters: ```String a, LocalDate b, String c, String d, String e, String f, Bollean g Integer h, Integer i, Integer j, SalaryPerHour k, List<String> l```

**Restrictions**:
 
- R1: The savings must be more than 0$.
- R2: The date of birth must be after (1960, 1, 1) and before (2000, 1, 1)

**Equality and Ordenation**

* ***Equality criterion***: Two users are the same if they have they have all the properties
* ***Natural order***: By salary and savings

**Other operations**:

- _Integer getAge()_: Computes the age of a user
- _SocialClass getSocialClass()_: Gets the social class of a user

#### Auxiliary Types

- Others, class. Contains the brand of the smarthphone and the carmaker of the user
- SalaryPerHour, class. Computes the salary per hour of a user
- Socialclass, enumerated. Contains the social class of a user based on the salary that he makes. Can take the following values: LOWER, WORKING, MIDDLE, UPPER

 
### Factory - UserFactory
Factory class, which creates objects of type Users.

-_Users readUsers(String fileName)_: Creates an object of type Users from the data in the csv file

-_User parseLine(String line)_ : Creates an object of type User from each line of the file

-_List<String> parseOthers(String oth)_: Parses the list in the file

 
### Container Type - Users
Container type of objects of type User.

**Constructors**: 

- C1: Creates an object of type ```Users``` from a stream
- C2: Creates an object of type ```Users``` from a collection
- C3: Constructor by default. Creates an empty collection

**Equality criterion**

Two users are the same if all their attributes are the same

**Other methods**:
- _Integer getUsers()_: Return the number of users in the database
- _List<Adult> getUsers()_: Gets all the registers
- _void add(User user)_: Adds an user to the database
- _void remove(User user)_: Remove an user from the database
- _String toString()_: Auto-generated toString
- _Boolean checkUsername(String username)_:Checks if exists a certain username in the database
- _Boolean olderThan(Integer age)_: Checks if all users in the list are older than the given age
- _Integer peopleWithGreaterIncome(Integer income)_: Counts how many users have an income greater than the given value
- _Integer savingsTotal()_: Sum the total number of savings of the users
- _averageIncomePerHour(String country)_: Compute the average income of the users per hour in a given country
- _List<String> usersCountryWithMoreSavingsThan(Integer savings, String country)_: Creates a list with the users from a certain country having more savings than a given number.
- _List<String> userMortgage()_: Creates a list with the users paying a mortgage from a given country
- _Map<String, List<String>> usersMaritalStatus(SocialClass socialclass)_: Returns a map that represents the marital status of the users from a given social class
- _Map<String, Map<SocialClass, Integer>> countriesSocialClass()_:	Returns a map that shows the number of people belonging to each social class in each country.
- _Map<String, Integer> countriesIncomeRange(Integer income)_: Return with the countries and the number of people having an income included in the range(income-250, income+250).
- _Boolean checkUsernameStream(String username)_:Checks if exists a certain username in the database (STREAM)
- _Boolean olderThanStream(Integer age)_:Checks if all the users in the database are older than a given age (STREAM)
- _long peopleWithGreaterIncomeStream(Integer income)_:Counts how many users with an iPhone have an income greater than a given value (STREAM)
- _Integer savingsTotalStream()_:Sum the total number of savings of the people (STREAM)
- _Map<Integer, Integer> averageSavingsAge()_:Compute the average income of the different ages
- _List<String> usersCountryWithMoreSavingsThanStream(Integer savings, String country)_:Creates a list with the users from a certain country having more savings than a given number (STREAM)
- _List<String> userMortgageStream(String country)_:Creates a list with the users paying a mortgage from a given country (STREAM)
- _Integer greaterSalaryCountry(String country)_:Finds the user with the greater salary from a given country
- _List<String> workclassList(String workclass)_:Creates a sorted list of users belonging to a given workclass by their salary
- _Map<String, List<String>> usersMaritalStatusStream(SocialClass socialclass)_:Returns a map that represents the marital status of the users from a given social class (STREAM)
- _Map<String, Double> averageSalariesByEducation()_:Returns a map that represents the average salary of the users of each education level
- _Map<String, Map<String, Integer>> maxSalaryByGender()_:Returns a map which shows the users of each gender in each country having the greatest salary
- _SortedMap<Boolean, List<String>> youngestUsersMortgage(Integer n)_:Returns a sorted map that shows the n youngest users paying or not paying a mortgage
- _String findMostSmartphone()_:Returns the most used smartphone among the users
