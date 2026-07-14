class BookStore:

    # Class Variable
    NoOfBooks = 0

    # Constructor
    def __init__(self, Name, Author):
        self.Name = Name
        self.Author = Author

        # Increment class variable whenever an object is created
        BookStore.NoOfBooks += 1

    # Display Method
    def Display(self):
        print(f"{self.Name} by {self.Author}. No of books : {BookStore.NoOfBooks}")


def main():

    # Object 1
    Obj1 = BookStore("Linux System Programming", "Robert Love")
    Obj1.Display()

    # Object 2
    Obj2 = BookStore("C Programming", "Dennis Ritchie")
    Obj2.Display()

    # Object 3
    Obj3 = BookStore("Python Programming", "Guido van Rossum")
    Obj3.Display()


if __name__ == "__main__":
    main()