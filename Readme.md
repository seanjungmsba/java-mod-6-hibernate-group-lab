# Jpa and Hibernate Practice

There are 5 projects in here, each in a separate package.

Everyone should keep in mind the following
1. There is a **shared** package with some user input stuff and other stuff.
2. Use OOP.
3. Create a github repo, and make your group partners admins.
4. Group partner with name earlier in alphabet, codes first.
5. Create entities.
6. Agree on when to take lunch break and agree on when to come back.
7. Next person alphabetically will code
8. Work on implementing your repository.
9. Next student codes.
10. Put everything together:
    * Think of "use cases" and making each a method in a service class.
    * Fill in those methods, one at a time.
    * Test each use case manually
    * Simplify



## Student (Teacher's example)

**Phase 1 Features**:
* The user is prompted for a student's name and date of birth. The system assigns their primary teacher.
* The user's input is saved to a database.
* The user can then enter another student's information.
* The user can then view all students.

***Phase 1 Stretch***:
* The user can search for students by name.

**Phase 2 Features**:
* The user can search for restaurants by name and location.
* The user can select a restaurant and is then prompted for dish information (dish name, price, description, and a review (0 to 5 stars).
* The user can select a restaurant see all the dishes at that restaurant.
* One unit test

## Restaurant

**Phase 1 Features**:
* The user is prompted for a restaurant name, its location, and a review (0 to 5 stars).
* The user's input is saved to a database.
* The user can then enter another restaurant's information.
* The user can also see all restaurants (ordered by review high to low).
***Phase 1 Stretch***:
* The user can search for restaurants by name and location.

**Phase 2 Features**:
* The user can search for restaurants by name and location.
* The user can select a restaurant and is then prompted for dish information (dish name, price, description, and a review (0 to 5 stars).
* The user can select a restaurant see all the dishes at that restaurant.
* One unit test



## Sports

**Phase 1 Features**:
* Developers choose a sport.
* The user is prompted for an athlete's name, score in game, other statistics that make sense for your chosen sport.
* The user's input is saved to a database.
* The user can then enter another game of statistics for that same athlete.
* The user can request average number of points, max number of points in a game, etc.
***Phase 1 Stretch***:
* The user can input information for multiple athletes.

**Phase 2 Features**:
* The user can input information for multiple athletes.
* The athletes will have a 'team' property.
* The user can search for athletes by name.
* The user can search for athletes by team.
* The user can request average number of points, etc, for a team.
* One unit test


## Code Snippets

**Phase 1 Features**:
* The user is prompted for a snippet of code, a title for that snippet, a description of that snippet.
* The user's input is saved to a database.
* The user can then enter another snippet.
* The user can search for snippets by title.
***Phase 1 Stretch***:
* The user is prompted for 'tags' for that snippet (easily searchable terms).

**Phase 2 Features**:
* The user is prompted for 'tags' for that snippet (easily searchable terms).
* The user can search for snippets by tag.
* The user can delete snippets.
* The user can edit snippets.
* The user can choose a color for each snippet. The snippet will then display in that color for the user.
* One unit test

## Bank Account

**Phase 1 Features**:
* The user is prompted for name, address, initial deposit amount.
* The user's input is saved to a database.
* The user can deposit money.
* The user can withdraw money.
* The user can see how much money is in their account.
* The user can create another account.
***Phase 1 Stretch***:
* The user can transfer money between accounts.

**Phase 2 Features**:
* The user can transfer money between accounts.
* The user can see a record of all deposits and withdrawals and transfers from their accounts.
* The user sees their balance in red if it is negative and green if it is positive.
* One unit test


