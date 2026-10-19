import tkinter as tk
from tkinter import messagebox

def Login():
    username = entry1.get()
    password = entry2.get()

    if username == "admin" and password == "admin123":
        resultLabel.config(
            text="Login Successful!",
            fg="green"
        )
        messagebox.showinfo("Success", "Welcome, admin!")
    else:
        resultLabel.config(
            text="Invalid username or password",
            fg="red"
        )
        messagebox.showerror(
            "Login Failed",
            "Invalid username or password"
        )

root = tk.Tk()
root.title("Basic Login Form")
root.geometry("350x250")

tk.Label(root, text="Username").pack(pady=5)
entry1 = tk.Entry(root)
entry1.pack()

tk.Label(root, text="Password").pack(pady=5)
entry2 = tk.Entry(root, show="*")
entry2.pack()

tk.Button(
    root,
    text="Login",
    command=Login
).pack(pady=10)

resultLabel = tk.Label(root, text="Please log in")
resultLabel.pack()

root.mainloop()