#include<bits/stdc++.h>
using namespace std;
class Bank_Account{
    private:
    string account_holder_name;
    int account_number;
    double balance;
    string account_type;
    string transaction_history;

    public:
    Bank_Account(string n, int accnum, double bal, string type) {
        account_holder_name = n;
        account_number = accnum;
        balance = bal;
        account_type = type;
        transaction_history = "No transactions yet";
    }



    void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            if(transaction_history == "No transactions yet") {
                transaction_history = "Deposited: " + to_string(amount);   
            }
            else {
                transaction_history += "\nDeposited: " + to_string(amount);  
            }

            cout<<"Deposited "<<amount<<" successfully."<<endl;

        }
        else {
            cout<<"Invalid deposit amount!"<<endl;
        }
    }



    void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            if(transaction_history == "No transactions yet") {
                transaction_history = "Withdrew: " + to_string(amount);
            }
            else {
                transaction_history += "\nWithdrew: " + to_string(amount);
            }

            cout<<"Withdrew "<<amount<<" successfully."<<endl;

        }
        else {
            cout<<"Insufficient balance or invalid amount!"<<endl;
        }
    }



    void checkbalance() {
        cout<<"Account Balance: "<<balance<<endl;
    }

    

    void calculateinterest() {
        double interest_rate = 0.0;
        if(account_type == "Savings") {
            interest_rate = 0.04;
        }
        else if(account_type == "Current") {
            interest_rate = 0.02;
        }

        double interest = balance *  interest_rate;
        balance += interest;
        if(transaction_history == "No transactions yet") {
            transaction_history = "Interest applied: " + to_string(interest);
        }
        else {
            transaction_history += "\nInterest applied: " + to_string(interest);
        }

         cout<<"Interest applied: "<<interest<<" successfully."<<endl;

    }



    void display() {
        cout<<"Account Holder: "<<account_holder_name<<endl;
        cout<<"Account Number: "<<account_number<<endl;
        cout<<"Account Type: "<<account_type<<endl;
        checkbalance();
    }  



    void display_transaction_history() {
        cout<<"Transaction History:"<<endl;
        cout<<transaction_history<<endl;
    }

};

int main() {
    string name;
    int account_num;
    double initial_balance;
    string account_type;

    cout<<"Enter Account Holder Name: ";
    getline(cin, name);

    cout<<"Enter Account Number: ";
    cin>>account_num;

    cout<<"Enter Initial Balance: ";
    cin>>initial_balance;

    cout<<"Enter Account Type (Savings/Current): ";
    cin>>account_type;


    Bank_Account account(name, account_num, initial_balance,account_type);


    int choice;
    double amount;

    while(true) {
        cout<<"\nMenu: "<<endl;;
        cout<<"1. Display Account Information"<<endl;
        cout<<"2. Display Transaction History"<<endl;
        cout<<"3. Deposit Money"<<endl;
        cout<<"4. Withdraw Money"<<endl;
        cout<<"5. Calculate Interest"<<endl;
        cout<<"6. Check Balance"<<endl;
        cout<<"7. Exit"<<endl;
        cout<<"Enter your choice: ";
        cin>>choice;
    


        switch (choice) {
            case 1:
                account.display();
                break;

            case 2:
                account.display_transaction_history();
                break;

            case 3:
                cout<<"Enter amount to deposit: ";
                cin>>amount;
                account.deposit(amount);
                break;

            case 4:
                cout<<"Enter amount to withdraw: ";
                cin>>amount;
                account.withdraw(amount);
                break;

            case 5:
                account.calculateinterest();
                break;

            case 6:
                account.checkbalance();
                break;

            case 7:
                cout<<"Existing the program."<<endl;
                return 0;

            default:
                cout<<"Invalid choice, please try again."<<endl;
        }

    }
    
}
