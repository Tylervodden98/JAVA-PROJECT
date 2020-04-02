# JAVA-PROJECT

This project uses JAVAFX to create a state design-based framework for a banking application.
There are two types of roles in this account. Manager and Customer.
The first window is for signing in. Managers are always admin, admin, for username and password by default.
While customers can be any user/password, but they must exist in the application to sign in.
Only Managers have the power to add/delete customers to the application first.
Customers once signed in can deposit money, withdraw money, retrieve their balance, and make online purchases.
By default each customer starts with $100
The state of the Customers' account changes based off this balance. At certain thresholds the extra fee for online purchases becomes less.

There are included usecase and class diagrams in these set of files.
