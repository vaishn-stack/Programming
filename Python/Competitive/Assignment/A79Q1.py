import tkinter as tk
from tkinter import messagebox

def AddNumbers():
    try:
        no1 = float(entry1.get())
        no2 = float(entry2.get())

        result = no1 + no2
        resultLabel.config(text = f"Addition = {result}")

    except ValueError:
        messagebox.showerror("Error", "Please enter valid numbers")

root = tk.Tk()
root.title("Addition of Two Numbers : ")
root.geometry("350x250")

tk.Label(root, text = "First Number : ").pack(pady=5)
entry1 = tk.Entry(root)
entry1.pack()

tk.Label(root, text = "Second Number : ").pack(pady=5)
entry2 = tk.Entry(root)
entry2.pack()

tk.Button(root, text="Add", command=AddNumbers).pack(pady=10)

resultLabel = tk.Label(root, text="Result will appear here")
resultLabel.pack()

root.mainloop()