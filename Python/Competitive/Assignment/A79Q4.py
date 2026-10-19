import tkinter as tk
from tkinter import messagebox

def CheckEligibility():
    name = entry1.get().strip()

    try:
        age = int(entry2.get())

        if name == "":
            messagebox.showerror("Error", "Please enter your name")
            return

        if age < 0:
            messagebox.showerror("Error", "Age cannot be negative")
            return

        if age >= 18:
            resultLabel.config(
                text=f"{name} is eligible to vote",
                fg="green"
            )
        else:
            resultLabel.config(
                text=f"{name} is not eligible to vote",
                fg="red"
            )

    except ValueError:
        messagebox.showerror("Error", "Please enter a valid age")

root = tk.Tk()
root.title("Voting Eligibility Checker")
root.geometry("400x250")

tk.Label(root, text="Enter Name : ").pack(pady=5)
entry1 = tk.Entry(root)
entry1.pack()

tk.Label(root, text="Enter Age : ").pack(pady=5)
entry2 = tk.Entry(root)
entry2.pack()

tk.Button(
    root,
    text="Check Eligibility",
    command=CheckEligibility
).pack(pady=10)

resultLabel = tk.Label(root, text="Result will appear here")
resultLabel.pack()

root.mainloop()