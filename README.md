# Project of the Second Term. Fundamentals of Programming(Curso 2022/23)
Author: Ionel Tudor Cristian Lacatus   uvus:HPD8118

## Structure of the project's folders:

* **/src**: Directory with the source code
  * **adults**: Package that contains the classes of the project
  * **tests**: Package that contains the test classes of the project
  * **utils**:  Package that contains the utility classes
* **/data**: Contains the data set for the project
    * **adults.csv**: CSV file which contains the data that we will be analyzing
    
## *Structure of the DATASET*

This dateset is focused on to analyze the information of a finantial app which has gathered information from its users, and wants to sell this information to others companies.
The original dataset can be found in the following link -> "https://www.kaggle.com/datasets/overload10/adult-census-dataset".
This dataset has 11 columns and 32562 rows, also, the dataset was modified in order to add a wider variety of parameters, and to delete some irrelevant data. Now, we will describe each column:

* **country**: of type string, indicates the country of an user
* **dateOfbirth**: of type date. Indicates the date of birth of an user 
* **workclass. of type string. Indicates the workclass of an user
* **education**: of type string. Indicates the maximum education that has achieved an user
* **maritalStatus**: of type string. Indicates ther marital status of a user
* **sex**: of type string. Indicates sex of a user
* **hours**: of type double. Indicates the hours that an user works each week
* **savings**: of type integer. Indicates the savings of a user
* **salary**: of type integer. Indicates ther salary of a user
* **mortgage**: of type boolean. Indicates whether a user is paying or not a mortgage
* **mobile_car_sport**: of type list, separated by commas. This column show the brand of the phone and the brand of the principal car of a user, and whether is playing or not a sport, and which one.

## Implemented Types

The types that have been implemented on the project are the following

### Base Type - Adult

**Properties**:

- _dateOfBirth_, of type Date, consultable.
- _workclass_, _education_, _maritalStatus_, of type String, consultable and modifiable.
- _sex_, _country_, of type String, consultable.
- _savings_, _salary_ of type Integer, consultable and modifiable.
- _others_, of type List<Others>, consultable and modifiable.
- _mortgage_, of type Boolean, consultable.
- _salaryPerHour_, of type SalaryPerHour, consultable. Indicates the salary per hour of a user.

**Constructors**: 

- C1: Has a parameter for every basic property.
- C2: Creates an object of type ```Adult``` from the following parameters: ```String a, LocalDate b, String c, String d, String e, Strin f, int g, int h, Integer i, SalaryPerHour j, List<Others> k```.

**Restrictions**:
 
- R1: The savings must be more than 0$.
- R2: The date of birth must be after (1960, 1, 1) and before (2000, 1, 1).

**Equality and Ordenation**

* ***Equality criterion***: Two users are the same if the have the same salary per hour, the same education, the same marital status, and they live in the same country.
* ***Natural order***: By age and salary.

**Other operations**:

- _Integer getAge()_: Computes the age of a user

#### Auxiliary Types

- Others, class. Contains the brand of the smarthphone and the carmaker of the user, and whether the sport that a user plays.
- SalaryPerHour, class. Computes the salary per hour of a user.
- Socialclass, enumerated. Contains the social class of a user based on the salary that he makes. Can take the following values: LOWER, WORKING, MIDDLE, UPPER
