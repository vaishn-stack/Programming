class BankAccount:

    # Class Variable
    ROI = 10.5

    # Constructor
    def __init__(self, Name, Amount):
        self.Name = Name
        self.Amount = Amount

    # Deposit Amount
    def Deposit(self, Value):
        self.Amount = self.Amount + Value
        print("Amount Deposited Successfully.")

    # Withdraw Amount
    def Withdraw(self, Value):
        if Value > self.Amount:
            print("Insufficient Balance.")
        else:
            self.Amount = self.Amount - Value
            print("Amount Withdrawn Successfully.")

    # Calculate Interest
    def CalculateInterest(self):
        Interest = (self.Amount * BankAccount.ROI) / 100
        return Interest

    # Display Details
    def Display(self):
        print("\n----- Account Details -----")
        print("Name :", self.Name)
        print("Balance :", self.Amount)
        print("Rate of Interest :", BankAccount.ROI, "%")
        print("Interest :", self.CalculateInterest())


def main():

    Obj1 = BankAccount("Vaishnavi", 10000)

    Obj1.Display()

    Obj1.Deposit(5000)
    Obj1.Display()

    Obj1.Withdraw(3000)
    Obj1.Display()


if __name__ == "__main__":
    main()