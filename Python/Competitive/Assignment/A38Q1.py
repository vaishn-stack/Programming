import pandas as pd

# Load Dataset
df = pd.read_csv("student_performance_ml.csv")

# first 5 records
print("First 5 records : ")
print(df.head())

# last 5 records
print("\nLast 5 records : ")
print(df.tail())

# Number of rows and columns
print("Number of rows and columns : ")
print(df.shape)

# columns names
print("\nColumn names : ")
print(df.columns)

# Data type
print("\nData Types : ")
print(df.dtypes)