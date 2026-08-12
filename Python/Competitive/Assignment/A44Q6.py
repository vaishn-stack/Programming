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




