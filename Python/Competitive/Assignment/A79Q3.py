import tkinter as tk
from tkinter import messagebox
import math

def CalculateArea():
    try:
        radius = float(entry1.get())

        if radius < 0:
            messagebox.showerror(
                "Error",
                "Radius cannot be negative"
            )
            return

        area = math.pi * radius * radius

        resultLabel.config(text=f"Area of Circle = {area:.2f}")

    except ValueError:
        messagebox.showerror("Error", "Please enter a valid radius")

root = tk.Tk()
root.title("Area of Circle : ")
root.geometry("350x220")

tk.Label(root, text="Enter Radius : ").pack(pady=10)

entry1 = tk.Entry(root)
entry1.pack()

tk.Button(
    root,
    text="Calculate Area",
    command=CalculateArea
).pack(pady=10)

resultLabel = tk.Label(root, text="Area will appear here")
resultLabel.pack()

root.mainloop()