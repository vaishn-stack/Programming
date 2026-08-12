import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

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

# Q3. Add Total column

df['Total'] = df['Math'] + df['Science'] + df['English']

print("\nDataFrame with Total:")
print(df)

# Q4. Students who scored more than 85 in Science

result = df[df['Science'] > 85]

print("\nStudents scoring more than 85 in Science:")
print(result)

# Q5. Replace Pooja with Puja

df['Name'] = df['Name'].replace('Pooja', 'Puja')

print("\nAfter replacing Pooja with Puja:")
print(df)

# Q6. Sort by Total in descending order

df = df.sort_values(by='Total', ascending=False)

print("\nSorted DataFrame:")
print(df)

# Q7. Bar Plot – Student Names vs Total Marks

plt.bar(df['Name'], df['Total'])

plt.xlabel("Student Name")
plt.ylabel("Total Marks")
plt.title("Student Names vs Total Marks")

plt.show()

# Q8. Line Chart of Amit's marks

Amit = df[df['Name'] == 'Amit'].iloc[0]

Subjects = ['Math', 'Science', 'English']

Marks = [
    Amit['Math'],
    Amit['Science'],
    Amit['English']
]

plt.plot(Subjects, Marks, marker='o')

plt.xlabel("Subjects")
plt.ylabel("Marks")
plt.title("Amit's Marks")

plt.show()

# Q9. DataFrame with missing values and fill with column mean

data2 = {
    'Name': ['Amit', 'Sagar', 'Pooja'],
    'Math': [np.nan, 76, 88],
    'Science': [91, np.nan, 85]
}

df2 = pd.DataFrame(data2)

print("\nOriginal DataFrame:")
print(df2)

# Fill missing values with column mean
df2['Math'] = df2['Math'].fillna(df2['Math'].mean())

df2['Science'] = df2['Science'].fillna(
    df2['Science'].mean()
)

print("\nDataFrame after filling missing values:")
print(df2)


