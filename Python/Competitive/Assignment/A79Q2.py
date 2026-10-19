import tkinter as tk
from tkinter import messagebox

def FindMaximum():
    try:
        num1 = float(entry1.get())
        num2 = float(entry2.get())
        num3 = float(entry3.get())

        largest = max(num1, num2, num3)

        resultLabel.config(text=f"Largest Number = {largest}")

    except ValueError:
        messagebox.showerror("Error", "Please enter valid numbers")

root = tk.Tk()
root.title("Find the Largest Number : ")
root.geometry("350x300")

tk.Label(root, text="First Number : ").pack(pady=5)
entry1 = tk.Entry(root)
entry1.pack()

tk.Label(root, text="Second Number : ").pack(pady=5)
entry2 = tk.Entry(root)
entry2.pack()

tk.Label(root, text="Third Number : ").pack(pady=5)
entry3 = tk.Entry(root)
entry3.pack()

tk.Button(
    root,
    text="Find Maximum",
    command=FindMaximum
).pack(pady=10)

resultLabel = tk.Label(root, text="Result will appear here")
resultLabel.pack()

root.mainloop()