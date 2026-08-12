import pandas as pd
import matplotlib.pyplot as plt


# Q1 : Create DataFrame

data = {
    'Name': ['Amit', 'Sagar', 'Pooja'],
    'Math': [85, 90, 78],
    'Science': [92, 88, 80],
    'English': [75, 85, 82]
}

df = pd.DataFrame(data)

print("DataFrame:")
print(df)

print("\nShape:")
print(df.shape)

print("\nColumns:")
print(df.columns)

print("\nData Types:")
print(df.dtypes)

# Q2. Descriptive Statistics using .describe()

print("\nDescriptive Statistics:")
print(df.describe())

