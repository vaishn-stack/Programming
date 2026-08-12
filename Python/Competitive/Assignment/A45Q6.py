import pandas as pd
import matplotlib.pyplot as plt

from sklearn.preprocessing import MinMaxScaler


data = {
    'Name': ['Amit', 'Sagar', 'Pooja'],
    'Math': [85, 90, 78],
    'Science': [92, 88, 80],
    'English': [75, 85, 82]
}

df = pd.DataFrame(data)

# Total column
df['Total'] = (
    df['Math'] +
    df['Science'] +
    df['English']
)

print(df)

# Q1: Normalize Math scores using Min-Max Scaling

scaler = MinMaxScaler()

df['Math_Normalized'] = scaler.fit_transform(
    df[['Math']]
)

print("\nQ1 : Normalized Math Scores")
print(df)

# Q2: Create Gender column and perform One-Hot Encoding

df['Gender'] = ['Male', 'Male', 'Female']

print("\nQ2 : Gender Column")
print(df)

# One-hot encoding:

df = pd.get_dummies(
    df,
    columns=['Gender']
)

print("\nAfter One-Hot Encoding:")
print(df)

# Q3: Group students by Gender and calculate average marks

data = {
    'Name': ['Amit', 'Sagar', 'Pooja'],
    'Math': [85, 90, 78],
    'Science': [92, 88, 80],
    'English': [75, 85, 82],
    'Gender': ['Male', 'Male', 'Female']
}

df_gender = pd.DataFrame(data)

print("\nQ3 : Average Marks by Gender")

result = df_gender.groupby('Gender')[
    ['Math', 'Science', 'English']
].mean()

print(result)

# Q4: Pie Chart of subject marks for Sagar

Sagar = df[df['Name'] == 'Sagar'].iloc[0]

Subjects = [
    'Math',
    'Science',
    'English'
]

Marks = [
    Sagar['Math'],
    Sagar['Science'],
    Sagar['English']
]

plt.pie(
    Marks,
    labels=Subjects,
    autopct='%1.1f%%'
)

plt.title("Sagar's Subject Marks")

plt.show()

# Q5: Add Status column

df['Status'] = df['Total'].apply(
    lambda x: 'Pass' if x >= 250 else 'Fail'
)

print("\nQ5 : Status")
print(df)

# Q6: Count how many students passed

Passed = (df['Status'] == 'Pass').sum()

print("\nQ6 : Number of Students Passed")
print(Passed)

